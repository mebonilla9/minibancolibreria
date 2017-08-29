package co.edu.intecap.minibancolibreria.modelo.vo;

/**
 *
 * @author TheZadock
 */
public class TipoProducto {
    
    private Long idTipoProducto;
    private String nombre;
    private Boolean estado;

    public TipoProducto() {
    }

    public TipoProducto(Long idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the idTipoProducto
     */
    public Long getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(Long idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
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
