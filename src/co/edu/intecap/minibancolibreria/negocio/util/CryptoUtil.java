/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Capacitaciones_pc18
 */
public final class CryptoUtil {
    
    private static String cifrarSha256(String contrasena) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(contrasena.getBytes());
        
        byte[] byteData = md.digest();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,16).substring(1));
        }
        return sb.toString();
    }
    
    public static String cifrarContrasena(String contrasena){
        String contrasenaCifrada = "";
        try {
            contrasenaCifrada = cifrarSha256(contrasena);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.err);
        }
        return contrasenaCifrada;
    }
    
}
