/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.recurso.constante;

import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.stage.Screen;

public class Configuracion {

       public static final int ALTO_APP = (int) (Screen.getPrimary().getBounds().getHeight() * 0.70);
    public static final int ANCHO_APP = (int) (Screen.getPrimary().getBounds().getWidth() * 0.80);

    private static final double CABECERA_ALTO_POCERTANJE = 0.1;
    public static final double ALTO_CABECERA = CABECERA_ALTO_POCERTANJE * ALTO_APP;

    public static final String AZUL_MARINO = "#0077BE";
    public static final String AZUL_CLARO = "#5BC0EB";
    public static final String AZUL_BRILLANTE = "#FFD23F";
    public static final String AZUL_MEDIO = "#E63946";
    public static final String CABECERA_ESTILO_FONDO = String.format(
            "-fx-background-color: linear-gradient(%s,%s,%s,%s);",
            AZUL_MARINO,AZUL_CLARO,AZUL_BRILLANTE,AZUL_MEDIO);
    

    public static final double MARCO_ALTO_PORCENTAJE = 0.6;
    public static final double MARCO_ANCHO_PORCENTAJE = 0.7;
    
    public static final double GRILLA_ANCHO_PORCENTAJE = 0.5;

    
    public static final String DEGRADDE_BORDE = "#8D5524";
    public  static final Stop[] DEGRADE_ARREGLO = new Stop[]{
        new Stop(0.0, Color.web("#0077BE", 0.8)),
            new Stop(0.2, Color.web("#5BC0EB", 0.7)),
            new Stop(0.4, Color.web("#FFD23F", 0.6)),
            new Stop(0.6, Color.web("#E63946", 0.5))
    };
    

    public static final String ICONO_BORRAR = "iconoBorrar.png";
    public static final String ICONO_EDITAR = "iconoEditar.png";
    public static final String ICONO_CANCELAR = "iconoCancelar.png";
    public static final String ICONO_NO_DISPONIBLE = "imgNoDisponible.png";
}

   