/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import co.edu.intecap.minibancolibreria.modelo.vo.ClienteProducto;
import co.edu.intecap.minibancolibreria.modelo.vo.Movimiento;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilo Diaz
 */
public class MovimientoCrud implements IGenericoDao<Movimiento>{

    protected final int ID = 1;
    protected Connection cnn;

    public MovimientoCrud(Connection cnn) {
        this.cnn = cnn;
    }
    
    @Override
    public void insertar(Movimiento entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO movimiento(descripcion, fecha, valor, cuota, id_tipo_movimiento, id_cliente_producto) VALUES (?,?,?,?,?);";
            
            sentencia.setObject(i++, entidad.getDescripcion());
            sentencia.setObject(i++, entidad.getFecha());
            sentencia.setObject(i++, entidad.getValor());
            sentencia.setObject(i++, entidad.getCuota());
            sentencia.setObject(i++, entidad.getTipoMovimiento().getidTipoMovimiento());
            sentencia.setObject(i++, entidad.getClienteProducto().getIdClienteProducto());
            
            sentencia.executeUpdate();
            
            ResultSet rs = sentencia.getGeneratedKeys();
            
            if (rs.next()) {
                entidad.setIdMovimiento(rs.getLong(ID));
            }
            
        } finally {
            Conexion.desconectar(sentencia);
        }
        
    }

    @Override
    public void editar(Movimiento entidad) throws SQLException {
        PreparedStatement sentencia = null;
        
        try {
            int i = 1;
            String sql = "UPDATE mivimiento SET descripcion = ?, fecha = ?, valor = ?, cuota = ?, id_tipo_movimiento = ?, id_cliente_producto = ? WHERE id_movimiento= ;";
            
            sentencia.setObject(i++, entidad.getDescripcion());
            sentencia.setObject(i++, entidad.getFecha());
            sentencia.setObject(i++, entidad.getValor());
            sentencia.setObject(i++, entidad.getCuota());
            sentencia.setObject(i++, entidad.getTipoMovimiento().getidTipoMovimiento());
            sentencia.setObject(i++, entidad.getClienteProducto().getIdClienteProducto());
            sentencia.setObject(i++, entidad.getIdMovimiento());
            
            sentencia.executeUpdate();
            
        } finally {
            Conexion.desconectar(sentencia);
        }
        
    }

    @Override
    public List<Movimiento> consultar() throws SQLException {
        
        PreparedStatement sentencia = null;
        List<Movimiento> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM movimiento;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(getMovimiento(rs));
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public Movimiento consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        Movimiento movimiento = new Movimiento();
        try{
            String sql = "SELECT * FROM movimiento WHERE id_movimiento = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                movimiento = getMovimiento(rs);
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return movimiento;
    }

    private static Movimiento getMovimiento(ResultSet rs) throws SQLException {
    
        Movimiento movimiento = new Movimiento();
        movimiento.setDescripcion(rs.getString("descripcion"));
        movimiento.setFecha(rs.getDate("fecha"));
        movimiento.setValor(rs.getLong("valor"));
        movimiento.setCuota(rs.getInt("valor"));
        movimiento.setTipoMovimiento(new TipoMovimiento(rs.getLong("id_tipo_movimiento")));
        movimiento.setClienteProducto(new ClienteProducto(rs.getLong("id_cliente_producto")));
        return movimiento;
    }
 
}
