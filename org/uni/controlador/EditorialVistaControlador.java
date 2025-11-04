/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.controlador;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.uni.vista.editorial.VistaEditorialAdministrar;
import org.uni.vista.editorial.VistaEditorialListar;

/**
 *
 * @author ruizr
 */
public class EditorialVistaControlador {
      public static StackPane listarEditorial(Stage esce,
            double ancho, double alto) {
        return new VistaEditorialListar(esce, ancho, alto);
    }
        public static  StackPane AdministrarEditorial( Stage esce, double anc,double alt){
        return new VistaEditorialAdministrar(esce, anc, alt);
    }
}

