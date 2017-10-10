/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.modelo.dao;

import co.edu.intecap.minibancolibreria.modelo.conexion.Conexion;
import co.edu.intecap.minibancolibreria.modelo.dao.crud.TipoDocumentoCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.RowSetMetaDataImpl;

/**
 *
 * @author Capacitaciones_pc11
 */
public class TipoDocumentoDao extends TipoDocumentoCrud{
    
    public TipoDocumentoDao(Connection cnn) {
        super(cnn);
    }
    
    public ResultSetMetaData columnasTipoDocuemnto() throws SQLException{
        PreparedStatement sentencia = null;
        ResultSetMetaData columnas = new RowSetMetaDataImpl();
        try{
            String sql = "SELECT * FROM tipo_documento LIMIT 1;";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                columnas = rs.getMetaData();
            }
        } finally{
            Conexion.desconectar(sentencia);
        }
        return columnas;
    }
    
}
