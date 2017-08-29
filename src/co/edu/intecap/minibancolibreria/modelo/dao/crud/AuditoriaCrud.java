/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Auditoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            
        } finally {
            Conexion.desconectar(sentencia);
        }
  }

  @Override
  public void editar(Auditoria entidad) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Auditoria> consultar() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Auditoria consultar(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
