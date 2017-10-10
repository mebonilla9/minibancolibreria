/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin VICTOR DANIEL
 */
public class TipoDocumentoCrud implements IGenericoDao<TipoDocumento>{
    protected final int ID = 1;
    protected Connection cnn;

    public TipoDocumentoCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(TipoDocumento entidad) throws SQLException {
        PreparedStatement sentencia = null;

        try {
            int i = 1;
            String sql = "INSERT INTO tipo_documento(nombre, estado) VALUES (?,?);";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre().toUpperCase());
            sentencia.setObject(i++, entidad.getEstado());

            sentencia.executeUpdate();

            ResultSet rs = sentencia.getGeneratedKeys();

            if (rs.next()) {
                entidad.setIdTipoDocumento(rs.getLong(ID));
            }

        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(TipoDocumento entidad) throws SQLException {
        PreparedStatement sentencia = null; 
        try {
            int i = 1;
            String sql = "UPDATE tipo_documento SET nombre = ?, estado = ? WHERE id_tipo_documento = ?;";
            sentencia = cnn.prepareCall(sql);
            sentencia.setObject(i++, entidad.getNombre().toUpperCase());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getIdTipoDocumento());
                        
            sentencia.executeUpdate();
            
        } finally {
            Conexion.desconectar(sentencia);
        }        
    }

    @Override
    public List<TipoDocumento> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<TipoDocumento> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipo_documento";
            sentencia = cnn.prepareCall(sql);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                lista.add(getTipoDocumento(rs));
            }          
        } finally {
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public TipoDocumento consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        TipoDocumento tipoDocumento = new TipoDocumento();
        try {
            String sql = "SELECT * FROM tipo_documento WHERE id_tipo_documento = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                tipoDocumento = getTipoDocumento(rs);
            }
        } finally {
            Conexion.desconectar(sentencia);
        }
        return tipoDocumento;
    }

    private TipoDocumento getTipoDocumento(ResultSet rs) throws SQLException {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(rs.getLong("id_tipo_documento"));
        tipoDocumento.setNombre(rs.getString("nombre").toUpperCase());
        tipoDocumento.setEstado(rs.getBoolean("estado"));
        return tipoDocumento;
    }
    
}
