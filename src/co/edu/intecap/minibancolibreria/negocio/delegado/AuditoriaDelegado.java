/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.minibancolibreria.negocio.delegado;

import co.edu.intecap.minibancolibreria.modelo.dao.AuditoriaDao;
import co.edu.intecap.minibancolibreria.modelo.vo.Auditoria;
import java.sql.Connection;


/**
 *
 * @author Nelcy
 */
public class AuditoriaDelegado extends GenericoDelegado<Auditoria> {

    private final AuditoriaDao auditoriaDao;

    public AuditoriaDelegado(Connection cnn) {
        super(cnn);
        auditoriaDao = new AuditoriaDao(cnn);
        genericoDao = auditoriaDao;
    }


}
