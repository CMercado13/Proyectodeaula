/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Actividad {
    
    private String nombreAct;
    private Date fechaAct;
    private String descripcionAct;
    private String accesoAct;
    private String participantesAct;
    private int usuario;

    public String getNombreAct() {
        return nombreAct;
    }

    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getDescripcionAct() {
        return descripcionAct;
    }

    public void setDescripcionAct(String descripcionAct) {
        this.descripcionAct = descripcionAct;
    }

    public String getAccesoAct() {
        return accesoAct;
    }

    public void setAccesoAct(String accesoAct) {
        this.accesoAct = accesoAct;
    }

    public String getParticipantesAct() {
        return participantesAct;
    }

    public void setParticipantesAct(String participantesAct) {
        this.participantesAct = participantesAct;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Actividad{" + "nombreAct=" + nombreAct + ", fechaAct=" + fechaAct + ", descripcionAct=" + descripcionAct + ", accesoAct=" + accesoAct + ", participantesAct=" + participantesAct + ", usuario=" + usuario + '}';
    }
    
    
    
}
