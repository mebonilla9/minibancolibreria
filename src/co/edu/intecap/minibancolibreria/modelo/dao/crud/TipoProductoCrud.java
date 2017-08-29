package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            String sql = "INSERT INTO tipo_producto(nombre, estado) VALUES (?,?);";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());

            sentencia.executeUpdate();

            ResultSet rs = sentencia.getGeneratedKeys();

            if (rs.next()) {
                entidad.setIdTipoProducto(rs.getLong(ID));
            }

        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(TipoProducto entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "UPDATE tipo_producto SET nombre = ?, estado = ? WHERE id_tipo_producto = ?;";
            sentencia = cnn.prepareCall(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getIdTipoProducto());
                        
            sentencia.executeUpdate();
            
        } finally {
            Conexion.desconectar(sentencia);
        }        
    }

    @Override
    public List<TipoProducto> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<TipoProducto> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipo_producto";
            sentencia = cnn.prepareCall(sql);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                lista.add(getTipoProducto(rs));
            }          
        } finally {
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public TipoProducto consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        TipoProducto tipoProducto = new TipoProducto();
        try {
            String sql = "SELECT * FROM tipo_producto WHERE id_tipo_producto = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                tipoProducto = getTipoProducto(rs);
            }
        } finally {
            Conexion.desconectar(sentencia);
        }
        return tipoProducto;
    }

    private TipoProducto getTipoProducto(ResultSet rs) throws SQLException{
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setIdTipoProducto(rs.getLong("id_tipo_producto"));
        tipoProducto.setNombre(rs.getString("nombre"));
        tipoProducto.setEstado(rs.getBoolean("estado"));
        return tipoProducto;
    }

}
