/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.vo;

/**
 *
 * @author Admin VICTOR DANIEL
 */
public class TipoMovimiento {
    private Long idTipoMovimiento;
    private String nombre;
    private Boolean estado;
    
    public TipoMovimiento() {
    }

    public TipoMovimiento(Long idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }
    
    /**
     * @return the idTipoMovimiento
     */
    public Long getidTipoMovimiento() {
        return idTipoMovimiento;
    }

    /**
     * @param idTipoMovimiento the idTipoMovimiento to set
     */
    public void setidTipoMovimiento(Long idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
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
