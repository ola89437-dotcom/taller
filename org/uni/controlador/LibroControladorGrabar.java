/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import org.uni.dto.LibroDto;
import org.uni.servicio.LibroServicio;

/**
 *
 * @author ruizr
 */
public class LibroControladorGrabar {
    public static Boolean crearLibro (LibroDto dto){
        Boolean correcto = false;
        
        LibroServicio libroServicio = new LibroServicio();
        LibroDto dtoRespuesta;
        dtoRespuesta = libroServicio.insertInto(dto, "");
        if (dtoRespuesta!=null) {
            correcto = true;
            
        }
        return correcto;
    }
}
