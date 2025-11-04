package org.uni.recurso.utilidad;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Marco {

    public static Rectangle crear(Stage miEscenario, double porcentajeAlto,
            double porcentajeAncho, Stop[] arrColores, String colorBorde) {

        // Crea un nuevo rectángulo
        Rectangle marco = new Rectangle();

        marco.widthProperty().bind(miEscenario.widthProperty().multiply(porcentajeAncho));
        // El alto del marco se ajusta automáticamente al alto de la ventana
        marco.heightProperty().bind(miEscenario.heightProperty().multiply(porcentajeAlto));

        // Configuración de bordes redondeados
        marco.setArcWidth(30);// ancho de la curvatura
        marco.setArcHeight(30);// alto de la curvatura

        marco.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, arrColores));
        // Configura el color del borde
        marco.setStroke(Color.web(colorBorde));

        // Retorna el marco configurado
        return marco;
    }

}
