/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Usuario;
import ImplementarDatos.EventoImplementarBD;
import ImplementarDatos.UsuarioImplementarBD;
import java.io.Serializable;
import java.util.Random;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;


/**
 *
 * @author E304
 */
@ManagedBean(name="login")
@ViewScoped
public class LoginManagedBean implements Serializable{

    UsuarioImplementarBD us = new UsuarioImplementarBD();
    EventoImplementarBD ev = new EventoImplementarBD();
    
    private int user;
    private String password;    

    
    public LoginManagedBean() {
    }
   

    public String validation() {
            int m;
            if(getUser() != 0 && getPassword()!=null){
            m = us.iniciarSession(getUser(), getPassword());
            if(m==1){
                return "inicio";
            }
            return "login";
        }return "login"; 
    }
    
    public Usuario cargarUsuario(Usuario usu){
        return us.cargarUsuario();
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void cerrarSesion(){
        ev.setIdUsu(0);
        us.cerrarSesion();
    }
    
    public int imagenAleatoria(){
       Random m = new Random();
       int n = m.nextInt(12)+1;
       return n;
    }
}
