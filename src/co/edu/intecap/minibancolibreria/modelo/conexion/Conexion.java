/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.conexion;

import co.edu.intecap.minibancolibreria.negocio.constantes.EMensajes;
import co.edu.intecap.minibancolibreria.negocio.excepciones.MiniBancoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Capacitaciones_pc18
 */
public final class Conexion {

    public static Connection conectar() throws MiniBancoException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*Connection cnn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.7.12:3306/minibanco",
                    "minibanco",
                    "123456"
            );*/
            Connection cnn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/minibanco",
                    "minibanco",
                    "123456"
            );
            cnn.setAutoCommit(false);
            return cnn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new MiniBancoException(EMensajes.ERROR_CONEXION_BD);
        }
    }

    private static void desconectar(Connection cnn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException e) {
            // registrar en log
            e.printStackTrace(System.err);
        }
    }

    public static void desconectar(PreparedStatement ps) {
        desconectar(null, ps);
    }

    public static void desconectar(Connection cnn) {
        desconectar(cnn, null);
    }

    public static void rollback(Connection cnn) {
        try {
            cnn.rollback();
        } catch (SQLException e) {
            // registrar en log
            e.printStackTrace(System.err);
        }
    }
    
    public static void commit(Connection cnn) {
        try {
            cnn.commit();
        } catch (SQLException e) {
            // registrar en log
            e.printStackTrace(System.err);
        }
    }
}
