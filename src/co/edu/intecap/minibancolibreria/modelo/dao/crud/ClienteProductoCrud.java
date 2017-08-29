/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import co.edu.intecap.minibancolibreria.modelo.vo.ClienteProducto;
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
 * @author joave
 */
public class ClienteProductoCrud implements IGenericoDao<ClienteProducto> {

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
            String sql = "INSERT INTO cliente_producto (numero, valor, fecha_desembolso, pago_minimo, fecha_pago_minimo, total_pagar, interes, estado_pago, numero_cuotas, id_tipo_producto, id_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
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
        PreparedStatement sentencia = null;
        try {
            int i = 1;
            String sql = "UPDATE cliente_producto SET numero = ?, valor = ?, fecha_desembolso = ?, pago_minimo = ?, fecha_pago_minimo = ?, total_pagar = ?, interes = ?, estado_pagado = ?, numero_cuotas = ?, id_tipo_producto = ?, id_cliente = ? WHERE id_cliente_producto = ?;";
            sentencia = cnn.prepareStatement(sql);
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
            sentencia.setObject(i++, entidad.getIdClienteProducto());

            sentencia.executeUpdate();
        } finally {
            Conexion.desconectar(sentencia);
        }
    }

    @Override
    public List<ClienteProducto> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<ClienteProducto> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente_producto";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(getClienteProducto(rs));
            }
        } finally {
            Conexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public ClienteProducto consular(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        ClienteProducto clienteProducto = new ClienteProducto();
        try {
            String sql = "SELECT * FROM cliente_producto WHERE id_cliente_producto = ?;";
            sentencia= cnn.prepareStatement(sql);
            sentencia.setLong(ID, id);
            ResultSet rs = sentencia.executeQuery();
            
            if (rs.next()) {
                clienteProducto = getClienteProducto(rs);
            }
        } finally {
            Conexion.desconectar(sentencia);
        }
        
        return clienteProducto;
    }

    private static ClienteProducto getClienteProducto(ResultSet rs) throws SQLException {
        ClienteProducto clienteProducto = new ClienteProducto();
        clienteProducto.setIdClienteProducto(rs.getLong("id_cliente_producto"));
        clienteProducto.setNumero(rs.getString("numero"));
        clienteProducto.setFechaDesembolso(rs.getDate("fecha_desembolso"));
        clienteProducto.setPagoMinimo(rs.getLong("pago_minimo"));
        clienteProducto.setFechaPagoMinimo(rs.getDate("fecha_pago_minimo"));
        clienteProducto.setTotalPagar(rs.getLong("total_pagar"));
        clienteProducto.setInteres(rs.getDouble("interes"));
        clienteProducto.setEstadoPago(rs.getBoolean("estado_pagado"));
        clienteProducto.setNumeroCuotas(rs.getInt("numero_cuotas"));
        clienteProducto.setTipoProducto(new TipoProducto(rs.getLong("id_tipo_producto")));
        clienteProducto.setCliente(new Cliente(rs.getLong("id_cliente")));
        return clienteProducto;
    }

}
