/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.controlador.sala;

import org.poo.dto.SalaDto;
import org.poo.servicio.SalaServicio;

public class SalaControladorGrabar {
    public static Boolean crearSala(SalaDto dto) {
        Boolean correcto = false;
        SalaServicio salaServicio = new SalaServicio();
        SalaDto dtoRespuesta = salaServicio.insertInto(dto, "");
        if (dtoRespuesta != null) {
            correcto = true;
        }
        return correcto;
    }
}
