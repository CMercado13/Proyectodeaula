/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementarDatos;

import Clases.Evento;
import Interfaces.InterEvento;
import JdbcConexion.JdbcConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class EventoImplementarBD implements InterEvento <Evento>{
    
    static int idUsu;

    public static int getIdUsu() {
        return idUsu;
    }

    public static void setIdUsu(int idUsu) {
        EventoImplementarBD.idUsu = idUsu;
    }
  

    @Override
    public void guardar(Evento e) {
        setIdUsu(e.getUsuario());
        Connection conect = null;
            try {
                conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("insert into Evento values(?,?,?,?,?,?,?)");
                res.setString(1, e.getNombreEve());
                res.setTimestamp(2, new Timestamp(e.getFechaEve().getTime()));
                res.setString(3, e.getDescripcionEve());
                res.setString(4, e.getAccesoEve());
                res.setString(5, e.getParticipantesEve());
                res.setString(6, e.getLugarEve());
                res.setInt(7, e.getUsuario());
                res.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void actualizar(Evento e) {
        setIdUsu(e.getUsuario());
        Connection conect = null;
            try {
                conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("UPDATE Evento SET NombreEve=?, FechaEve=?, DescripcionEve=?, "
                           + "AccesoEve=?, ParticipantesEve=?, "
                           + "LugarEve=?, Usuario="+getIdUsu()+" WHERE IdEve=?");
                res.setString(1, e.getNombreEve());
                res.setTimestamp(2, new Timestamp(e.getFechaEve().getTime()));
                res.setString(3, e.getDescripcionEve());
                res.setString(4, e.getAccesoEve());
                res.setString(5, e.getParticipantesEve());
                res.setString(6, e.getLugarEve());
                res.setInt(7, e.getIdEve());
                res.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void eliminar(Evento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evento> listar() {
        List<Evento> listaEvento=new ArrayList<>();
        try {
          Connection con = JdbcConexion.conexion(); 
          PreparedStatement pst = con.
                     prepareStatement("SELECT NombreEve, FechaEve, DescripcionEve, AccesoEve, "
                             + "ParticipantesEve, LugarEve, IdEve FROM Evento WHERE Usuario="+getIdUsu()+"OR AccesoEve='Publico'");
          ResultSet rs = (ResultSet)pst.executeQuery();
          while(rs.next()){
              Evento e = new Evento();
              e.setNombreEve(rs.getString(1));
              e.setFechaEve(new Timestamp(rs.getDate(2).getTime()));
              e.setDescripcionEve(rs.getString(3));
              e.setAccesoEve(rs.getString(4));
              e.setParticipantesEve(rs.getString(5));
              e.setLugarEve(rs.getString(6));
              e.setIdEve(rs.getInt(7));
              listaEvento.add(e);
          }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EventoImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEvento;
    }
    
    public int generarIdEve(){
        int id=0;
        Connection conect = null;
            try {
                conect = JdbcConexion.conexion();
                PreparedStatement res = conect.
                   prepareStatement("SELECT MAX(IdEve) FROM Evento");
                ResultSet rs = (ResultSet)res.executeQuery();
                id=(int)rs.getInt(1)+1;
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioImplementarBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return id;
    }
    
    
}
