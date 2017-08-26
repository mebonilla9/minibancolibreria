/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao.crud;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Capacitaciones_pc18
 */
public interface IGenericoDao<T> {
    
    public void insertar(T entidad) throws SQLException;
    
    public abstract void editar(T entidad) throws SQLException;
    
    public List<T> consultar() throws SQLException;
    
    public T consular(Long id) throws SQLException;
    
}
