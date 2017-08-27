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
import java.sql.SQLException;
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

    } finally {
      Conexion.desconectar(sentencia);
    }
  }

  @Override
  public void editar(TipoCliente entidad) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<TipoCliente> consultar() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public TipoCliente consular(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
