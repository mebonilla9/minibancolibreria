/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.vo;

import java.util.Date;

/**
 *
 * @author Camilo Diaz
 */
public class Movimiento {

    private Long idMovimiento;
    private String descripcion;
    private Date fecha;
    private Long valor;
    private Integer cuota;
    private TipoMovimiento tipoMovimiento;
    private ClienteProducto clienteProducto;

    public Movimiento() {
    }
    
    public Movimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public ClienteProducto getClienteProducto() {
        return clienteProducto;
    }

    public void setClienteProducto(ClienteProducto clienteProducto) {
        this.clienteProducto = clienteProducto;
    }
}
