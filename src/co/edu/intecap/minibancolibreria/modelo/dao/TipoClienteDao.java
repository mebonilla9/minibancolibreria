/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.dao.crud.TipoClienteCrud;
import java.sql.Connection;

/**
 *
 * @author Nelcy
 */
public class TipoClienteDao extends TipoClienteCrud {
    
    public TipoClienteDao(Connection cnn) {
        super(cnn);
    }
    
}
