/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.MovimientoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.Movimiento;
import java.sql.Connection;

/**
 *
 * @author Camilo Diaz
 */
public class MovimientoDelegado extends GenericoDelegado<Movimiento>{
    
    private final MovimientoDao movimientoDao;
    
    public MovimientoDelegado(Connection cnn) {
        super(cnn);
        movimientoDao = new MovimientoDao(cnn);
        genericoDao = movimientoDao;
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
