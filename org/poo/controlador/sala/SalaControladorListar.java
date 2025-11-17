/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.controlador.sala;

import java.util.List;
import org.poo.dto.SalaDto;
import org.poo.servicio.SalaServicio;

public class SalaControladorListar {
    public static List<SalaDto> obtenerSalas() {
        SalaServicio miDao = new SalaServicio();
        List<SalaDto> arreglo = miDao.selectFrom();
        return arreglo;
    }

    public static int obtenerCantidadSalas() {
        SalaServicio miDao = new SalaServicio();
        int cantidad = miDao.numRows();
        return cantidad;
    }
}
