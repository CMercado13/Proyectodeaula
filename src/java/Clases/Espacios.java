/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author HP
 */
public class Espacios {
    
    private String nombreEsp;
    private String descripcionEsp;
    private String serviciosEsp;
    private String horariosEsp;

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    public String getDescripcionEsp() {
        return descripcionEsp;
    }

    public void setDescripcionEsp(String descripcionEsp) {
        this.descripcionEsp = descripcionEsp;
    }

    public String getServiciosEsp() {
        return serviciosEsp;
    }

    public void setServiciosEsp(String serviciosEsp) {
        this.serviciosEsp = serviciosEsp;
    }

    public String getHorariosEsp() {
        return horariosEsp;
    }

    public void setHorariosEsp(String horariosEsp) {
        this.horariosEsp = horariosEsp;
    }

    @Override
    public String toString() {
        return "Espacios{" + "nombreEsp=" + nombreEsp + ", descripcionEsp=" + descripcionEsp + ", serviciosEsp=" + serviciosEsp + ", horariosEsp=" + horariosEsp + '}';
    }
    
    
}
