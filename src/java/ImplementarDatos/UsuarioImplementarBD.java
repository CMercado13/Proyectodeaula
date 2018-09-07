/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementarDatos;

//import Beans.UsuarioManagedBean;
import Clases.Usuario;
import Interfaces.InterUsuario;
import JdbcConexion.JdbcConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UsuarioImplementarBD implements InterUsuario <Usuario> {
    
    
    static int i;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        UsuarioImplementarBD.i = i;
    }
       

    @Override
    public void guardar(Usuario u) {
        setI(u.getCodigo());
        Connection conect = null;
            try {
                conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("insert into Usuario values(?,?,?,?,?,?)");
                res.setString(1, u.getNombre());
                res.setString(2, u.getCorreo());
                res.setInt(3, u.getCodigo());
                res.setString(4, u.getContrasena());
                res.setInt(5, u.getTel());
                res.setString(6, u.getTipoU());
                res.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    @Override
    public String actualizar(String correo, int num) {
        int i;
            try {
                Connection conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("UPDATE Usuario SET Correo='"+correo+"', Telefono="+num+" WHERE Codigo="+getI()+"");
                i = (int)res.executeUpdate(); 
                if(i==1){
                  return "porfile";  
                }else{
                    return "editarUsuario";
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
                return "editarUsuario";
            }
    }

    @Override
    public String pedirNombre(int cod) {
        setI(cod);
        String n="";
        String sql = "SELECT Nombre FROM Usuario WHERE Codigo="+cod+"";
            try {
            Connection con = JdbcConexion.conexion();
            PreparedStatement pst = con.
                    prepareStatement(sql);
            ResultSet rs = (ResultSet)pst.executeQuery();
            while(rs.next()){
            n = rs.getString("Nombre");            
            }return n;
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
                return "Error";
            } 
            
    }
    
    public int compartirCodigo(){
        return getI();
    }
    
    public int iniciarSession(int codigo, String contrasena){
        setI(codigo);
        String n="";
        String sql = "SELECT Contrasena FROM Usuario WHERE Codigo="+codigo+"";
            try {
            Connection con = JdbcConexion.conexion();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = (ResultSet)pst.executeQuery();
            while(rs.next()){
            n = rs.getString("Contrasena");            
            }
            if(n.equals(contrasena)){
                return 1;
            }else{
            return 0;  
            }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
    }
    
    public Usuario cargarUsuario(){
    Usuario u=null;
        String sql = "SELECT * FROM Usuario WHERE Codigo="+getI()+"";
            try {
            Connection con = JdbcConexion.conexion();
            PreparedStatement pst = con.
                    prepareStatement(sql);
            ResultSet rs = (ResultSet)pst.executeQuery();
            while(rs.next()){
            u = new Usuario();
            u.setNombre(rs.getString(1));
            u.setCorreo(rs.getString(2));
            u.setCodigo(rs.getInt(3));
            u.setContrasena(rs.getString(4));
            u.setTel(rs.getInt(5));
            u.setTipoU(rs.getString(6));
            }return u;
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    
    public void cerrarSesion(){
        setI(0);
    }
    
    public String recuperarContrasena(int cod, String contrasena, String correo){
            int i;
            try {
                Connection conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("UPDATE Usuario SET Contrasena='"+contrasena+"' WHERE Codigo="+cod+" AND Correo='"+correo+"'");
                i = (int)res.executeUpdate(); 
                if(i==1){
                  cerrarSesion();
                  return "login";  
                }else{
                    return "restaurar";
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
                return "restaurar";
            }
    }
        
}
