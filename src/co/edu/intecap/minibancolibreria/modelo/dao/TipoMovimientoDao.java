/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.dao.crud.TipoMovimientoCrud;
import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class TipoMovimientoDao extends TipoMovimientoCrud{
    
    public TipoMovimientoDao(Connection cnn) {
        super(cnn);
    }
    
}
