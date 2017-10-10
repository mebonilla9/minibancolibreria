package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.crud.TipoProductoCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.RowSetMetaDataImpl;

/**
 *
 * @author TheZadock
 */
public class TipoProductoDao extends TipoProductoCrud{
        
    public TipoProductoDao(Connection cnn) {
        super(cnn);
    }

    public ResultSetMetaData columnasTipoProducto() throws SQLException{
        PreparedStatement sentencia = null;
        ResultSetMetaData columnas = new RowSetMetaDataImpl();
        try{
            String sql = "SELECT * FROM tipo_producto LIMIT 1;";
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
}
