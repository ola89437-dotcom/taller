/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;
import org.uni.servicio.EditorialServicio;

/**
 *
 * @author ruizr
 */



public class EditorialControladorEliminar {

    public static Boolean borrar(int codigo) {
        Boolean correcto;
        EditorialServicio editorialServicio = new EditorialServicio();
        correcto = editorialServicio.delectFrom(codigo);
        return correcto;
    }

}
