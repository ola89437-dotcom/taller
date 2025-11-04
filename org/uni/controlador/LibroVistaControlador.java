/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.uni.vista.libro.VistaLibroAdministrar;
import org.uni.vista.libro.VistaLibroCrear;
import org.uni.vista.libro.VistaLibroListar;


/**
 *
 * @author ruizr
 */
public class LibroVistaControlador {
     public static StackPane crearLibro(Stage esce,
            double anchito, double altito) {
        return new VistaLibroCrear(esce, anchito, altito);
    }

    public static StackPane listarLibros(Stage esce,
            double ancho, double alto) {
        return new VistaLibroListar(esce, ancho, alto);
    }
  public static  StackPane AdministrarLibro ( Stage esce, double anc,double alt){
        return new VistaLibroAdministrar(esce, anc, alt);
    }
}
