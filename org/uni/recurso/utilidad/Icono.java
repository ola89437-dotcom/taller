package org.uni.recurso.utilidad;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.uni.recurso.constante.Configuracion;
import org.uni.recurso.constante.Persistencia;

public class Icono {

    public static ImageView obtenerIcono(String nombre, int tamanio) {
        try {
            String miRuta = Persistencia.RUTA_IMAGENES_INTERNAS + nombre;
            Image iconito = new Image(miRuta);
            ImageView vistaIconito = new ImageView(iconito);
            if (tamanio > 0) {
                vistaIconito.setFitHeight(tamanio);
            }
            vistaIconito.setPreserveRatio(true);
            vistaIconito.setSmooth(true);
            
            return vistaIconito;
        } catch (Exception ex) {
            // Si hay error cargando la imagen, usar la imagen por defecto
            return obtenerIconoPorDefecto(tamanio);
        }
    }
    
      public static ImageView obtenerIconoPorDefecto(int tamanio) {
        try {
            String miRuta = Persistencia.RUTA_IMAGENES_INTERNAS + Configuracion.ICONO_NO_DISPONIBLE;
            Image iconito = new Image(miRuta);
            ImageView vistaIconito = new ImageView(iconito);
            if (tamanio > 0) {
                vistaIconito.setFitHeight(tamanio);
            }
            vistaIconito.setPreserveRatio(true);
            vistaIconito.setSmooth(true);
            
            return vistaIconito;
        } catch (Exception ex) {
            // Si incluso la imagen por defecto falla, devolver un ImageView vacío
            ImageView vistaVacia = new ImageView();
            if (tamanio > 0) {
                vistaVacia.setFitHeight(tamanio);
            }
            return vistaVacia;
        }
    }

}
 