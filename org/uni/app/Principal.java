/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.app;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uni.controlador.SalidaControlador;
import org.uni.vista.gestor.VistaAdmin;

/**
 *
 * @author ruizr
 */

    public class Principal extends Application{
        
    private VistaAdmin vistaAdmin;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        vistaAdmin = new VistaAdmin(stage);
        stage.setTitle("dios mio que sirva");
        
        vistaAdmin.configurarSalida(()->{
            SalidaControlador.verificar(stage);
        });
        
        
        stage.show();
    }

}
