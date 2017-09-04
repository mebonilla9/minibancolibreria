/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.constantes;

/**
 *
 * @author Capacitaciones_pc18
 */
public enum EMensajes {

    INSERTO(1, "Se ha insertado correctamente"),
    ELIMINO(1, "Se ha eliminado correctamente"),
    CONSULTO(1, "Se ha consultado correctamente"),
    MODIFICO(1, "Se ha modificado correctamente"),
    NO_RESULTADOS(0, "No se encontraron registros"),
    ERROR_INSERTAR(-1, "Error al insertar el registro"),
    ERROR_ELIMINAR(-1, "Error al eliminar el registro"),
    ERROR_CONSULTAR(-1, "Error al consultar el registro"),
    ERROR_MODIFICAR(-1, "Error al modificar el registro"),
    ERROR_REGISTRO_EXISTE(-1, "El registro ya existe"),
    ERROR_CONEXION_BD(-2, "No hay conexion con la base de datos"),
    ERROR_FORMATO_FECHA(-3,"Digite una fecha valida debe usar el siguiente formato (dd-MM-yyyy)");

    private EMensajes(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    private int codigo;
    private String descripcion;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
