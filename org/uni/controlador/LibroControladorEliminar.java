/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;
import org.uni.servicio.LibroServicio;

/**
 *
 * @author ruizr
 */
public class LibroControladorEliminar {
    

    
    public static Boolean borrar(int pos) {
        Boolean correcto;
        LibroServicio libroServicio = new LibroServicio();
        correcto = libroServicio.delectFrom(pos);
        return correcto;
    }
}
