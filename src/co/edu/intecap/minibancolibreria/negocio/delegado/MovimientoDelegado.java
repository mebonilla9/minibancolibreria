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
}
