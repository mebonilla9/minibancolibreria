/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.vo;

import java.io.Serializable;

/**
 *
 * @author Capacitaciones_pc18
 */
public class TipoCliente implements Serializable{
    
    private Long idTipoCliente;
    private String nombre;
    private Boolean estado;

    public TipoCliente() {
    }

    public TipoCliente(Long idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }
    
    /**
     * @return the idTipoCliente
     */
    public Long getIdTipoCliente() {
        return idTipoCliente;
    }

    /**
     * @param idTipoCliente the idTipoCliente to set
     */
    public void setIdTipoCliente(Long idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
