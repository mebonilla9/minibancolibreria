/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoClienteDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoCliente;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author Nelcy
 */
public class TipoClienteDelegado extends GenericoDelegado<TipoCliente> {

    private final TipoClienteDao tipoClienteDao;

    public TipoClienteDelegado(Connection cnn) {
        super(cnn);
        tipoClienteDao = new TipoClienteDao(cnn);
        genericoDao = tipoClienteDao;
    }

    public ResultSetMetaData consultarColumnasTipoCliente() throws MiniBancoException {
        try {
            return tipoClienteDao.columnasTipoCliente();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
}
