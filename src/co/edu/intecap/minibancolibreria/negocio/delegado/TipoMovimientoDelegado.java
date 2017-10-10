/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoMovimientoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Admin VICTOR ARIAS
 */
public class TipoMovimientoDelegado extends GenericoDelegado<TipoMovimiento>{
     private final TipoMovimientoDao tipoMovimientoDao;
    public TipoMovimientoDelegado(Connection cnn) {
        super(cnn);
    tipoMovimientoDao = new TipoMovimientoDao(cnn);
    genericoDao=tipoMovimientoDao;
    }
    
    public ResultSetMetaData consultarColumnasTipoMovimiento() throws MiniBancoException {
        try {
            return tipoMovimientoDao.columnasTipoMovimiento();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
}
