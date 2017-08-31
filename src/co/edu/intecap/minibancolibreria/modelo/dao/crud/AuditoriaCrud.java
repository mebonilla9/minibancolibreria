/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Auditoria;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;

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
public class AuditoriaCrud implements IGenericoDao<Auditoria> {

  protected final int ID = 1;
  protected Connection cnn;

  public AuditoriaCrud(Connection cnn) {
    this.cnn = cnn;
  }

  @Override
  public void insertar(Auditoria entidad) throws SQLException {
    PreparedStatement sentencia = null;
    try {
      int i = 1;
      String sql = "INSERT INTO auditoria(transaccion,fecha,id_cliente) VALUES(?,?,?)";
      sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      sentencia.setObject(i++, entidad.getTransaccion());
      sentencia.setObject(i++, entidad.getFecha());
      sentencia.setObject(i++, entidad.getCliente().getIdCliente());

      sentencia.executeUpdate();

      ResultSet rs = sentencia.getGeneratedKeys();

      if (rs.next()) {
        entidad.setIdAuditoria(rs.getLong(ID));
      }
    } finally {
      Conexion.desconectar(sentencia);
    }
  }

  @Override
  public void editar(Auditoria entidad) throws SQLException {
    PreparedStatement sentencia = null;
    try {
      int i = 1;
      String sql = "UPDATE auditoria SET transaccion = ?, fecha = ?, id_cliente = ? WHERE id_auditoria = ?;";
      sentencia = cnn.prepareStatement(sql);
      sentencia.setObject(i++, entidad.getTransaccion());
      sentencia.setObject(i++, entidad.getFecha());
      sentencia.setObject(i++, entidad.getCliente().getIdCliente());

      sentencia.executeUpdate();
    } finally {
      Conexion.desconectar(sentencia);
    }
  }

  @Override
  public List<Auditoria> consultar() throws SQLException {
    PreparedStatement sentencia = null;
    List<Auditoria> lista = new ArrayList<>();
    try {
      String sql = "SELECT * FROM auditoria;";
      sentencia = cnn.prepareStatement(sql);
      ResultSet rs = sentencia.executeQuery();
      while (rs.next()) {
        lista.add(getAuditoria(rs));
      }
    } finally {
      Conexion.desconectar(sentencia);
    }
    return lista;
  }

  @Override
  public Auditoria consultar(Long id) throws SQLException {
    PreparedStatement sentencia = null;
    Auditoria auditoria = new Auditoria();
    try {
      String sql = "SELECT * FROM auditoria WHERE id_auditoria = ?;";
      sentencia = cnn.prepareStatement(sql);
      sentencia.setLong(ID, id);
      ResultSet rs = sentencia.executeQuery();

      if (rs.next()) {
        auditoria = getAuditoria(rs);
      }
    } finally {
      Conexion.desconectar(sentencia);
    }
    return auditoria;
  }

  private Auditoria getAuditoria(ResultSet rs) throws SQLException{
    Auditoria auditoria = new Auditoria();
    auditoria.setIdAuditoria(rs.getLong("id_auditoria"));
    auditoria.setTransaccion(rs.getString("transaccion"));
    auditoria.setFecha(rs.getDate("fecha"));
    
    auditoria.setCliente(new Cliente(rs.getLong("id_cliente")));
    
    return auditoria;
  }

}
