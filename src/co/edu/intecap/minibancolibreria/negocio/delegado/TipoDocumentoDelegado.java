/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoDocumentoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoDocumento;
import java.sql.Connection;

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
    
}
