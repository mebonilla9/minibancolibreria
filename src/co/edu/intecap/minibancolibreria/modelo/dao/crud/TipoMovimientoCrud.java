/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
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
public class TipoMovimientoCrud implements IGenericoDao<TipoMovimiento> {

    protected final int ID = 1;
    protected Connection cnn;

    public TipoMovimientoCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(TipoMovimiento entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO tipo_movimiento(nombre, estado) VALUES (?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.executeUpdate();
            
             ResultSet rs = sentencia.getGeneratedKeys();
            
            if (rs.next()) {
               entidad.setidTipoMovimiento(rs.getLong(ID));
            }
            
        } finally {
            Conexion.desconectar(sentencia);
        }
    }
    @Override
    public void editar(TipoMovimiento entidad) throws SQLException {
     PreparedStatement sentencia=null;
     
     try{
     int i=1;
     String sql="UPDATE tipo_movimiento SET nombre=?, estado=? WHERE id_tipo_movimiento=?;";
     sentencia= cnn.prepareStatement(sql);
     sentencia.setObject(i++, entidad.getNombre());                             
     sentencia.setObject(i++, entidad.getEstado());
     sentencia.executeUpdate();
     } finally{
        Conexion.desconectar(sentencia);    
        }
    }

    @Override
    public List<TipoMovimiento> consultar() throws SQLException {
        PreparedStatement sentencia=null;
        List<TipoMovimiento> lista=new ArrayList<>();
        
        try{
        String sql= "SELECT * FROM tipo_movimiento;";
        sentencia=cnn.prepareStatement(sql);
       ResultSet rs = sentencia.executeQuery();
        
        while (rs.next()){
      lista.add(getTipoMovimiento(rs));
        }
  }finally {
        Conexion.desconectar(sentencia);
        }
     return lista;
    }

    @Override
    public TipoMovimiento consultar(Long id) throws SQLException {
      PreparedStatement sentencia=null;
      TipoMovimiento tipomovimiento =new TipoMovimiento();
      try{
       String sql= "SELECT * FROM tipo_movimiento;";
      sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                tipomovimiento = getTipoMovimiento(rs);
            }     
      }finally{
       Conexion.desconectar(sentencia);
      }
      return tipomovimiento;
    }

    private static TipoMovimiento getTipoMovimiento(ResultSet rs) throws SQLException {
       TipoMovimiento tipomovimiento=new TipoMovimiento();
       //tipomovimiento.setNombre(rs.getLong("id_tipo_movimiento"));
       tipomovimiento.setNombre(rs.getString("nombre"));
       tipomovimiento.setEstado(rs.getBoolean("estado"));
       return tipomovimiento;
    }
}
