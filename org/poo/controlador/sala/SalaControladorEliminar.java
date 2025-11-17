/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.controlador.sala;

import org.poo.servicio.SalaServicio;

public class SalaControladorEliminar {
    public static Boolean borrar(int codigo) {
        boolean correcto;
        SalaServicio salaServicio = new SalaServicio();
        correcto = salaServicio.deleteFrom(codigo);
        return correcto;
    }
}
