/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.ClienteDao;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Capacitaciones_pc18
 */
public class ClienteDelegado extends GenericoDelegado<Cliente> {

    private final ClienteDao clienteDao;

    public ClienteDelegado(Connection cnn) {
        super(cnn);
        clienteDao = new ClienteDao(cnn);
        genericoDao = clienteDao;
    }

    public ResultSetMetaData consultarColumnasCliente() throws MiniBancoException {
        try {
            return clienteDao.columnasCliente();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
    
    public Cliente consultaLogin(String usuario, String contrasena) throws MiniBancoException{
        try {
            return clienteDao.consultar(usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
    
    public List<Cliente> consultar(Boolean estado) throws MiniBancoException{
        try {
            return clienteDao.consultar(estado);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
    
    public void registrarClienteTransaccion(Cliente cliente) throws MiniBancoException{
        try {
            // registrar primero tipo cliente
            if (cliente.getTipoCliente().getIdTipoCliente() == null) {
                new TipoClienteDelegado(cnn).insertar(cliente.getTipoCliente());
            }
            
            // registrar segundo tipo documento 
            if (cliente.getTipoDocumento().getIdTipoDocumento() == null) {
                new TipoDocumentoDelegado(cnn).insertar(cliente.getTipoDocumento());
            }
            
            // registrar el cliente
            new ClienteDao(cnn).insertar(cliente);
        } catch (SQLException e) {
            Conexion.rollback(cnn);
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_INSERTAR);
        }
    }
    
    

    /*{
        try {
            List<Cliente> consultar = new ClienteDelegado(cnn).consultar();
            for (Cliente cliente : consultar) {
                cliente.setContrasena("123456789!");
                new ClienteDelegado(cnn).editar(cliente);
            }
            Cliente nuevoCliente = new Cliente();
            
            new ClienteDelegado(cnn).insertar(nuevoCliente);
            Conexion.commit(cnn);
        } catch (MiniBancoException ex) {
            System.out.println("Mensaje: "+ex.getMensaje());
        }
    }*/
}
