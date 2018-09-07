/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author HP
 * @param <Actividad>
 */
public interface InterActividad <Actividad>{
    void guardar(Actividad a);
    void actualizar(Actividad a);
    void eliminar(Actividad a);
    List<Actividad>listar(); 
    
}
