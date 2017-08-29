/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.ClienteProductoDAO;
import co.edu.intecap.minibancolibreria.modelo.vo.ClienteProducto;
import java.sql.Connection;

/**
 *
 * @author joave
 */
public class ClienteProductoDelegado extends GenericoDelegado<ClienteProducto>{
    
    private final ClienteProductoDAO clienteProductoDao;
    
    public ClienteProductoDelegado(Connection cnn){
        super(cnn);
        clienteProductoDao = new ClienteProductoDAO(cnn);
        genericoDao = clienteProductoDao;
    }
    
}
