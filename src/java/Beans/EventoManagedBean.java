/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Evento;
import ImplementarDatos.EventoImplementarBD;
import Interfaces.InterEvento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ImplementarDatos.UsuarioImplementarBD;
import java.util.Date;

/**
 *
 * @author HP
 */
@Named(value = "eventotBean")
@ViewScoped
public class EventoManagedBean implements Serializable {
    
    private Evento evento = new Evento();
    private InterEvento imp = new EventoImplementarBD();
    private List<Evento> listaEve=new ArrayList<>();
    UsuarioImplementarBD us = new UsuarioImplementarBD();

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getListaEve() {
        return listaEve;
    }

    public void setListaEve(List<Evento> listaEve) {
        this.listaEve = listaEve;
    }
    @PostConstruct
    public void init(){
        listaEve=imp.listar();
    }

    public EventoManagedBean() {
    }
        
    public void guardarEvento(){
    FacesContext context = FacesContext.getCurrentInstance();
    evento.setUsuario(us.compartirCodigo());
    imp.guardar(evento);
    imp.listar();
    }
    
    public void actualizarEvento(){
    FacesContext context = FacesContext.getCurrentInstance();
    evento.setUsuario(us.compartirCodigo());
    imp.actualizar(evento);
    imp.listar();
    }       
}
