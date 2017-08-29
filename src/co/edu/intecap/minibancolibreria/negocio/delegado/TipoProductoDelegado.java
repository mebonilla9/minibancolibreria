package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoProductoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoProducto;
import java.sql.Connection;

/**
 *
 * @author TheZadock
 */
public class TipoProductoDelegado extends GenericoDelegado<TipoProducto>{

    private final TipoProductoDao tipoProductoDao;
    
    public TipoProductoDelegado(Connection cnn) {
        super(cnn);
        tipoProductoDao = new TipoProductoDao(cnn);
        genericoDao = tipoProductoDao;
    }
    
}
