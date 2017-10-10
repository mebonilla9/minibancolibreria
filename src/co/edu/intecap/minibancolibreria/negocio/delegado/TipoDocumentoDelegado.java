/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoDocumentoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoDocumento;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Capacitaciones_pc04
 */
public class TipoDocumentoDelegado extends GenericoDelegado<TipoDocumento>{
    
    private TipoDocumentoDao tipoDocumentoDao;
    
    public TipoDocumentoDelegado(Connection cnn) {
        super(cnn);
        tipoDocumentoDao = new TipoDocumentoDao(cnn);
        genericoDao = tipoDocumentoDao;
    }
    
    public ResultSetMetaData consultarColumnasTipoDocumento() throws MiniBancoException {
        try {
            return tipoDocumentoDao.columnasTipoDocuemnto();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
}
