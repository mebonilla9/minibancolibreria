/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.ClienteDao;
import co.edu.intecap.minibancolibreria.modelo.vo.Cliente;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
