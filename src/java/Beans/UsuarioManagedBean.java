/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Clases.Usuario;
import ImplementarDatos.UsuarioImplementarBD;
import Interfaces.InterUsuario;
import java.io.Serializable;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Named;

/**
 *
 * @author E304
 */
@ManagedBean(name = "UsuarioBean")
@ViewScoped

public class UsuarioManagedBean implements Serializable{
    
    private Usuario usuario = new Usuario();
    private InterUsuario imp=new UsuarioImplementarBD(); //imp = implementar
    
    private int cod;
    private String correo;
    private String contrasena;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
//--------------------------------------------------------------------------
    public UsuarioManagedBean() {
    }

    
    public Usuario getUsuario() {
        return usuario;
        
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void guardar(){
    //FacesContext context = FacesContext.getCurrentInstance();
    imp.guardar(usuario);
    }
    
    public String actualizar(){
        //FacesContext context = FacesContext.getCurrentInstance();
        String c = imp.actualizar(correo, cod);
        return c;
    }
    
    public String pedirNombre(){
       // FacesContext context = FacesContext.getCurrentInstance();
        UsuarioImplementarBD us = new UsuarioImplementarBD();
        String n= (String)imp.pedirNombre(us.compartirCodigo());
        return n.toUpperCase();
    }
    
    public String recurperarContrasena(){
        UsuarioImplementarBD us = new UsuarioImplementarBD();
        String c = us.recuperarContrasena(cod,contrasena,correo);
        return c;
    }
    
}
