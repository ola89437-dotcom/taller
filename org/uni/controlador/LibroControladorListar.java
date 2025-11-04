/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import java.util.List;
import org.uni.dto.LibroDto;
import org.uni.servicio.LibroServicio;

/**
 *
 * @author ruizr
 */
public class LibroControladorListar {
       public static List<LibroDto> obtenerLibro() {
            LibroServicio miDao = new LibroServicio();
        List<LibroDto> arreglo = miDao.selectFrom();
        return arreglo;
    }
    
    public static int obtenerCantidadLibros() {
        LibroServicio miDao = new LibroServicio();
        int cantidad = miDao.numRows();
        return cantidad;
    }
    
}
