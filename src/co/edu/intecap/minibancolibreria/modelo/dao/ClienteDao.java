/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.dao.crud.ClienteCrud;
import java.sql.Connection;

/**
 *
 * @author Capacitaciones_pc18
 */
public class ClienteDao extends ClienteCrud{
    
    public ClienteDao(Connection cnn) {
        super(cnn);
    }
    
}
