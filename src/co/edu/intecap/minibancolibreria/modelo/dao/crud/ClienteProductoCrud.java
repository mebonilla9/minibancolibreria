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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO cliente_producto (numero, valor, fecha_desembolso, pago_minimo, fecha_pago_minimo, total_pagar, interes, estado_pago, numero_cuotas, id_tipo_producto, id_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNumero());
            sentencia.setObject(i++, entidad.getValor());
            sentencia.setObject(i++, entidad.getFechaDesembolso());
            sentencia.setObject(i++, entidad.getPagoMinimo());
            sentencia.setObject(i++, entidad.getFechaPagoMinimo());
            sentencia.setObject(i++, entidad.getTotalPagar());
            sentencia.setObject(i++, entidad.getInteres());
            sentencia.setObject(i++, entidad.getEstadoPago());
            sentencia.setObject(i++, entidad.getNumeroCuotas());
            sentencia.setObject(i++, entidad.getTipoProducto().getIdTipoProducto());
            sentencia.setObject(i++, entidad.getCliente().getIdCliente());
            
            sentencia.executeUpdate();
            ResultSet rs = sentencia.getGeneratedKeys();
            
            if (rs.next()) {
                entidad.setIdClienteProducto(rs.getLong(ID));
            }
            
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(ClienteProducto entidad) throws SQLException {
       
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
