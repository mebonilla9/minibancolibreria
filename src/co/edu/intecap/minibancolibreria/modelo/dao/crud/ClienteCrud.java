/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Capacitaciones_pc18
 */
public class ClienteCrud implements IGenericoDao<Cliente> {

    protected final int ID = 1;
    protected Connection cnn;

    public ClienteCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(Cliente entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO cliente(nombre,apellido,identificacion,telefono,direccion,usuario,contrasena,fecha_nacimiento,correo,rol,id_tipo_cliente,id_tipo_documento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(Cliente entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consular(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
