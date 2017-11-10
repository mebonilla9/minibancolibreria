/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dto;

import java.util.List;

/**
 *
 * @author instructor
 */
public class MenuDto {
    
    private Integer idMenu;
    private String nombre;
    private List<MenuDto> subMenu;
    private MenuDto menuPadre;
    
    

    /**
     * @return the idMenu
     */
    public Integer getIdMenu() {
        return idMenu;
    }

    /**
     * @param idMenu the idMenu to set
     */
    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
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
     * @return the subMenu
     */
    public List<MenuDto> getSubMenu() {
        return subMenu;
    }

    /**
     * @param subMenu the subMenu to set
     */
    public void setSubMenu(List<MenuDto> subMenu) {
        this.subMenu = subMenu;
    }

    /**
     * @return the menuPadre
     */
    public MenuDto getMenuPadre() {
        return menuPadre;
    }

    /**
     * @param menuPadre the menuPadre to set
     */
    public void setMenuPadre(MenuDto menuPadre) {
        this.menuPadre = menuPadre;
    }
    
    
    
}
