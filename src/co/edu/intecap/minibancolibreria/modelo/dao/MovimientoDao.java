/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.dao.crud.MovimientoCrud;
import java.sql.Connection;

/**
 *
 * @author Camilo Diaz
 */
public class MovimientoDao extends MovimientoCrud{
    
    public MovimientoDao(Connection cnn) {
        super(cnn);
    }
    
}
