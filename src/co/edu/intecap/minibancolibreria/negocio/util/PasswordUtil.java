/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.util;

/**
 *
 * @author Capacitaciones_pc04
 */
public final class PasswordUtil {
    
    public static String armarContrasena(char[] contrasena){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contrasena.length; i++) {
            sb.append(contrasena[i]);
        }
        return sb.toString();
    }
}
