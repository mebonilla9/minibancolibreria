/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            String sql = "INSERT INTO movimiento(descripcion, fecha, valor, cuota, id_tipo_movimiento, id_cliente, producto) VALUES (?,?,?,?,?,?)";
            
        } finally {
            Conexion.desconectar(sentencia);
        }
        
    }

    @Override
    public void editar(Movimiento entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento consular(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
