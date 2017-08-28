/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.ClienteProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joave
 */
public class ClienteProductoCrud implements IGenericoDao<ClienteProducto>{
    
    protected final int ID = 1;
    protected Connection cnn;

    public ClienteProductoCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(ClienteProducto entidad) throws SQLException {
        PreparedStatement sentecia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO cliente_producto (numero, valor, fecha_desembolso, pago_minimo, fecha_pago_minimo, total_pagar, interes, estado_pago, numero_cuotas, id_tipo_producto, id_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        } finally {
            Conexion.desconectar(sentecia);
        }
    }

    @Override
    public void editar(ClienteProducto entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteProducto> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteProducto consular(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
