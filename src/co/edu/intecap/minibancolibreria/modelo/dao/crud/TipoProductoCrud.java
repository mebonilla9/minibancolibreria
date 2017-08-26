package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TheZadock
 */
public class TipoProductoCrud implements IGenericoDao<TipoProducto> {

    protected final int ID = 1;
    protected Connection cnn;

    public TipoProductoCrud(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(TipoProducto entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "INSERT INTO tipo_producto(nombre, estado) VALUES (?,?)";

        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(TipoProducto entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoProducto> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProducto consular(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
