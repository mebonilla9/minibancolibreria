/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.vo;

import java.util.Date;

/**
 *
 * @author Nelcy
 */
public class Auditoria {
  
  private Long idAuditoria;
  private String transaccion;
  private Date fecha;
  private Cliente idCliente;

  public Auditoria() {
    
  }
  
  public Auditoria(Long idAuditoria) {
    this.idAuditoria = idAuditoria;
  }
  
  public Long getIdAuditoria() {
    return idAuditoria;
  }

  public void setIdAuditoria(Long idAuditoria) {
    this.idAuditoria = idAuditoria;
  }

  public String getTransaccion() {
    return transaccion;
  }

  public void setTransaccion(String transaccion) {
    this.transaccion = transaccion;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }
  
  
  
}
