/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.controlador.sala;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.poo.vista.sala.VistaSalaAdministrar;
import org.poo.vista.sala.VistaSalaCrear;
import org.poo.vista.sala.VistaSalaListar;

public class SalaVistasControlador {
    public static StackPane crearSala(Stage esce, double ancho, double alto) {
        return new VistaSalaCrear(esce, ancho, alto);
    }
    
    public static StackPane listarSala(Stage esce, double ancho, double alto) {
        return new VistaSalaListar(esce, ancho, alto);
    }

    public static StackPane administrarSala(Stage esce, double ancho, double alto) {
        return new VistaSalaAdministrar(esce, ancho, alto);
    }
}