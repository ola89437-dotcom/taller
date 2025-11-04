package org.uni.recurso.utilidad;

import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Clase utilitaria para el manejo de mensajes y alertas
 * Proporciona métodos para crear y mostrar diferentes tipos de diálogos
 * Centraliza la lógica de interacción con el usuario
 */
public class Mensaje {

    /**
     * Método estático para crear una alerta personalizada
     * @param tipo tipo de alerta (INFORMATION, WARNING, ERROR, CONFIRMATION)
     * @param ventanaPadre ventana padre de la alerta (puede ser null)
     * @param titulo título de la alerta
     * @param contenido contenido o mensaje de la alerta
     * @return Alert configurada y lista para mostrar
     */
    public static Alert crearAlerta(Alert.AlertType tipo, Window ventanaPadre,
                                    String titulo, String contenido) {
        // Crea una nueva alerta con el tipo especificado o INFORMATION por defecto
        Alert alerta = new Alert(tipo != null ? tipo : Alert.AlertType.INFORMATION);
        // Establece el título o usa "Mensaje" por defecto
        alerta.setTitle(titulo != null ? titulo : "Mensaje");
        // Elimina el texto de encabezado
        alerta.setHeaderText(null);
        // Establece el contenido o cadena vacía por defecto
        alerta.setContentText(contenido != null ? contenido : "");
        // Si se proporciona una ventana padre, la establece como propietaria
        if (ventanaPadre != null) {
            alerta.initOwner(ventanaPadre);
        }
        return alerta;
    }

    /**
     * Método estático para mostrar un diálogo de confirmación de salida
     * @param escenario la ventana principal que se va a cerrar
     */
    public static void salir(Stage escenario) {
        // Crea una alerta de confirmación
        Alert msg = crearAlerta(Alert.AlertType.CONFIRMATION,
                                escenario, "Confirmación de salida", "¿Estás seguro que deseas salir?");
        // Muestra la alerta y espera la respuesta del usuario
        msg.showAndWait().ifPresent(respuesta -> {
            // Si el usuario confirma (OK) y el escenario no es null, cierra la ventana
            if (respuesta == ButtonType.OK && escenario != null) {
                escenario.close();
            }
        });
    }

    /**
     * Método estático para mostrar una alerta simple
     * @param tipo tipo de alerta a mostrar
     * @param ventanaPadre ventana padre de la alerta
     * @param titulo título de la alerta
     * @param contenido contenido de la alerta
     */
    public static void mostrar(Alert.AlertType tipo, Window ventanaPadre, String titulo,
                               String contenido) {
        // Crea la alerta usando el método crearAlerta
        Alert msg = crearAlerta(tipo, ventanaPadre, titulo, contenido);
        // Muestra la alerta sin esperar respuesta
        msg.show();
    }
}