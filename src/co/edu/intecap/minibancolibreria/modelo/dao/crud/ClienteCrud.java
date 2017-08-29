/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoCliente;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            String sql = "INSERT INTO cliente(nombre,apellido,identificacion,telefono,direccion,usuario,contrasena,fecha_nacimiento,correo,rol,id_tipo_cliente,id_tipo_documento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getApellido());
            sentencia.setObject(i++, entidad.getIdentificacion());
            sentencia.setObject(i++, entidad.getTelefono());
            sentencia.setObject(i++, entidad.getDireccion());
            sentencia.setObject(i++, entidad.getUsuario());
            sentencia.setObject(i++, entidad.getContrasena());
            sentencia.setObject(i++, entidad.getFechaNacimiento());
            sentencia.setObject(i++, entidad.getCorreo());
            sentencia.setObject(i++, entidad.getRol());
            sentencia.setObject(i++, entidad.getTipoCliente().getIdTipoCliente());
            sentencia.setObject(i++, entidad.getTipoDocumento().getIdTipoDocumento());

            sentencia.executeUpdate();

            ResultSet rs = sentencia.getGeneratedKeys();

            if (rs.next()) {
                entidad.setIdCliente(rs.getLong(ID));
            }
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(Cliente entidad) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, identificacion = ?, telefono = ?, direccion = ?, usuario = ?, contrasena = ?, fecha_nacimiento = ?, correo = ?, rol = ?, id_tipo_cliente = ?, id_tipo_documento = ? WHERE id_cliente = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getApellido());
            sentencia.setObject(i++, entidad.getIdentificacion());
            sentencia.setObject(i++, entidad.getTelefono());
            sentencia.setObject(i++, entidad.getDireccion());
            sentencia.setObject(i++, entidad.getUsuario());
            sentencia.setObject(i++, entidad.getContrasena());
            sentencia.setObject(i++, entidad.getFechaNacimiento());
            sentencia.setObject(i++, entidad.getCorreo());
            sentencia.setObject(i++, entidad.getRol());
            sentencia.setObject(i++, entidad.getTipoCliente().getIdTipoCliente());
            sentencia.setObject(i++, entidad.getTipoDocumento().getIdTipoDocumento());
            sentencia.setObject(i++, entidad.getIdCliente());

            sentencia.executeUpdate();
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public List<Cliente> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<Cliente> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM cliente;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(getCliente(rs));
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public Cliente consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        Cliente cliente = new Cliente();
        try{
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                cliente = getCliente(rs);
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return cliente;
    }

    private static Cliente getCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getLong("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setIdentificacion(rs.getString("identificacion"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setUsuario(rs.getString("usuario"));
        cliente.setContrasena(rs.getString("contrasena"));
        cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setRol(rs.getInt("rol"));
        cliente.setTipoCliente(new TipoCliente(rs.getLong("id_tipo_cliente")));
        cliente.setTipoDocumento(new TipoDocumento(rs.getLong("id_tipo_documento")));
        return cliente;
    }

}
