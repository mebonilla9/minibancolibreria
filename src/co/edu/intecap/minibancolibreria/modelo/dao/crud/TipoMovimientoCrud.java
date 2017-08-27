/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import co.edu.intecap.minibancolibreria.modelo.vo.TipoMovimiento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin VICTOR DANIEL
 */
public class TipoMovimientoCrud implements IGenericoDao<TipoMovimiento>{

    @Override
    public void insertar(TipoMovimiento entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(TipoMovimiento entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoMovimiento> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoMovimiento consular(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
