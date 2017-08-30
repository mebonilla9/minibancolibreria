/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.TipoClienteDao;
import co.edu.intecap.minibancolibreria.modelo.dao.TipoMovimientoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Admin VICTOR ARIAS
 */
public class TipoMovimientoDelegado extends GenericoDelegado<TipoMovimiento>{
     private final TipoMovimientoDao tipomovimientoDao;
    public TipoMovimientoDelegado(Connection cnn) {
        super(cnn);
    tipomovimientoDao = new TipoMovimientoDao(cnn);
    genericoDao=tipomovimientoDao;
    }
    /** {
        try {
            List<TipoMovimiento> consultar = new TipoMovimientoDelegado(cnn).consultar();
            for (TipoMovimiento tipomovimiento : consultar) {
                tipomovimiento.setNombre("123456789!");
                new TipoMovimientoDao(cnn).editar(tipomovimiento);
            }
            TipoMovimiento nuevoTipoMovimiento = new TipoMovimiento();
            
            new TipoMovimientoDao(cnn).insertar(nuevoTipoMovimiento);
            Conexion.commit(cnn);
        } catch (MiniBancoException ex) {
            System.out.println("Mensaje: "+ex.getMensaje());
        }
    }**/
}
