/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ImplementarDatos.EventoImplementarBD;
import java.util.Date;


/**
 *
 * @author HP
 */
public class Evento {

    
    private String nombreEve;
    private Date fechaEve;
    private String descripcionEve;
    private String accesoEve;    
    private String participantesEve;
    private String lugarEve;
    private static int usuario;
    private int idEve;
    
    EventoImplementarBD ev = new EventoImplementarBD();

    public String getNombreEve() {
        return nombreEve;
    }

    public void setNombreEve(String nombreEve) {
        this.nombreEve = nombreEve;
    }

    public Date getFechaEve() {
        return fechaEve;
    }

    public void setFechaEve(Date fechaEve) {
        this.fechaEve = fechaEve;
    }

    public String getDescripcionEve() {
        return descripcionEve;
    }

    public void setDescripcionEve(String descripcionEve) {
        this.descripcionEve = descripcionEve;
    }

    public String getAccesoEve() {
        return accesoEve;
    }

    public void setAccesoEve(String accesoEve) {
        this.accesoEve = accesoEve;
    }

    public String getParticipantesEve() {
        return participantesEve;
    }

    public void setParticipantesEve(String participantesEve) {
        this.participantesEve = participantesEve;
    }

    public String getLugarEve() {
        return lugarEve;
    }

    public void setLugarEve(String lugarEve) {
        this.lugarEve = lugarEve;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getIdEve() {
        return idEve;
    }

    public void setIdEve(int idEve) {
        //idEve= ev.generarIdEve();
        this.idEve = idEve;
    }

    

    
    
    
    
}
