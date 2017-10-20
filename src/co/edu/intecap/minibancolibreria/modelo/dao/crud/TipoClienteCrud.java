/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nelcy
 */
public class TipoClienteCrud implements IGenericoDao<TipoCliente> {

    protected final int ID = 1;
    protected Connection cnn;

    public TipoClienteCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(TipoCliente entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO tipo_cliente(nombre, estado) VALUES(?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            
            sentencia.executeUpdate();

            ResultSet rs = sentencia.getGeneratedKeys();

            if (rs.next()) {
                entidad.setIdTipoCliente(rs.getLong(ID));
            }
            
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(TipoCliente entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "UPDATE tipo_cliente SET nombre = ?, estado = ? WHERE id_tipo_cliente = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getIdTipoCliente());

            sentencia.executeUpdate();
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public List<TipoCliente> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<TipoCliente> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM tipo_cliente;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(getTipoCliente(rs));
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public TipoCliente consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        TipoCliente tipoCliente = new TipoCliente();
        try{
            String sql = "SELECT * FROM tipo_cliente WHERE id_tipo_cliente = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                tipoCliente = getTipoCliente(rs);
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return tipoCliente;
    }

    private TipoCliente getTipoCliente(ResultSet rs) throws SQLException{
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setIdTipoCliente(rs.getLong("id_tipo_cliente"));
        tipoCliente.setNombre(rs.getString("nombre"));
        tipoCliente.setEstado(rs.getBoolean("estado"));
        return tipoCliente;
    }

}
