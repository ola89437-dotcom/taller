/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import java.util.List;
import org.uni.dto.EditorialDto;
import org.uni.servicio.EditorialServicio;

/**
 *
 * @author ruizr
 */
public class EditorialControladorListar {
      
     public static List<EditorialDto> obtenerEditorail() {
        EditorialServicio miDao = new EditorialServicio();
        List<EditorialDto> arreglo = miDao.selectFrom();
        return arreglo;
    }
    
     public static int obtenerCantidadEditoriales() {
        EditorialServicio miDao = new EditorialServicio();
        int cantidad = miDao.numRows();
        return cantidad;
    }
}
