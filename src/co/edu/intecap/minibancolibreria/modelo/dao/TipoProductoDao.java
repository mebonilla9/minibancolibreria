package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.dao.crud.TipoProductoCrud;
import java.sql.Connection;

/**
 *
 * @author TheZadock
 */
public class TipoProductoDao extends TipoProductoCrud{
        
    public TipoProductoDao(Connection cnn) {
        super(cnn);
    }

}
