package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.TipoProductoDao;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoProducto;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
    
    public ResultSetMetaData consultarColumnasTipoProducto() throws MiniBancoException {
        try {
            return tipoProductoDao.columnasTipoProducto();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
}
