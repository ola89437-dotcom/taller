/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;




import org.uni.servicio.AutorServicio;

public class AutorControladorEliminar {

    public static Boolean borrar(int codigo) {
        Boolean correcto;
        AutorServicio autorServicio = new AutorServicio();
        correcto = autorServicio.delectFrom(codigo);
        return correcto;
    }
}