/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import java.util.List;
import org.uni.dto.AutorDto;
import org.uni.servicio.AutorServicio;

/**
 *
 * @author ruizr
 */
public class AutorControladorLista {
        public static List<AutorDto> obtenerAutores() {
        AutorServicio miDao = new AutorServicio();
        List<AutorDto> arreglo = miDao.selectFrom();
        return arreglo;
    }
    
     public static int obtenerCantidadAutores() {
         AutorServicio miDao = new AutorServicio();
        int cantidad = miDao.numRows();
        return cantidad;
    }
}
