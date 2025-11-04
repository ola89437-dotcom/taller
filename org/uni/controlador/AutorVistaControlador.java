/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.uni.vista.autor.VistaAutorAdministrar;
import org.uni.vista.autor.VistaAutorListar;

/**
 *
 * @author ruizr
 */
public class AutorVistaControlador {
     public static StackPane listarAutor(Stage esce,
            double ancho, double alto) {
        return new VistaAutorListar(esce, ancho, alto);
    }
       public static  StackPane AdministrarAutor ( Stage esce, double anc,double alt){
        return new VistaAutorAdministrar(esce, anc, alt);
    }
}
