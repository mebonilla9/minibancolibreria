/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.crud.ClienteCrud;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.RowSetMetaDataImpl;

/**
 *
 * @author Capacitaciones_pc18
 */
public class ClienteDao extends ClienteCrud{
    
    public ClienteDao(Connection cnn) {
        super(cnn);
    }
    
    public ResultSetMetaData columnasCliente() throws SQLException{
        PreparedStatement sentencia = null;
        ResultSetMetaData columnas = new RowSetMetaDataImpl();
        try{
            String sql = "SELECT * FROM cliente LIMIT 1;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                columnas = rs.getMetaData();
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return columnas;
    }
    
    public Cliente consultar(String usuario, String contrasena) throws SQLException {
        PreparedStatement sentencia = null;
        Cliente cliente = new Cliente();
        try{
            String sql = "SELECT * FROM cliente WHERE usuario = ? AND contrasena = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setString(1,usuario);
            sentencia.setString(2,contrasena);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                cliente = getCliente(rs);
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return cliente;
    }
    
}
