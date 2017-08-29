/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.vo;

import java.util.Date;

/**
 *
 * @author joave
 */
public class ClienteProducto {
 
    private Long idClienteProducto;
    private String numero;
    private Long valor;
    private Date fechaDesembolso;
    private Long pagoMinimo;
    private Date fechaPagoMinimo;
    private Long totalPagar;
    private Double interes;
    private Boolean estadoPago;
    private Integer numeroCuotas;
    private TipoProducto tipoProducto;
    private Cliente cliente;

    public ClienteProducto() {
    
    }

    public ClienteProducto(Long idClienteProducto) {
        this.idClienteProducto = idClienteProducto;
    }

    public Long getIdClienteProducto() {
        return idClienteProducto;
    }

    public void setIdClienteProducto(Long idClienteProducto) {
        this.idClienteProducto = idClienteProducto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Long getPagoMinimo() {
        return pagoMinimo;
    }

    public void setPagoMinimo(Long pagoMinimo) {
        this.pagoMinimo = pagoMinimo;
    }

    public Date getFechaPagoMinimo() {
        return fechaPagoMinimo;
    }

    public void setFechaPagoMinimo(Date fechaPagoMinimo) {
        this.fechaPagoMinimo = fechaPagoMinimo;
    }

    public Long getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Long totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
