/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.crud.IGenericoDao;
import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Capacitaciones_pc18
 */
public abstract class GenericoDelegado<T> {
    
    protected Connection cnn;
    protected IGenericoDao genericoDao;
    protected boolean confirmar = true;

    public GenericoDelegado(Connection cnn) {
        this.cnn = cnn;
    }
    
    public void insertar(T entidad) throws MiniBancoException{
        try {
            genericoDao.insertar(entidad);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            Conexion.rollback(cnn);
            throw new MiniBancoException(EMensajes.ERROR_INSERTAR);
        }
    }
    
    public void editar(T entidad) throws MiniBancoException{
        try {
            genericoDao.editar(entidad);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            Conexion.rollback(cnn);
            throw new MiniBancoException(EMensajes.ERROR_MODIFICAR);
        }
    }
    
    public List<T> consultar()throws MiniBancoException{
        try {
            return genericoDao.consultar();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            Conexion.rollback(cnn);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }
    
    public T consultar(Long id) throws MiniBancoException{
        try {
            return (T) genericoDao.consultar(id);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            Conexion.rollback(cnn);
            throw new MiniBancoException(EMensajes.ERROR_CONSULTAR);
        }
    }    
}
