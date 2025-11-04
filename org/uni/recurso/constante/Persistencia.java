/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.recurso.constante;

/**
 *
 * @author ruizr
 */
import java.io.File;

public class Persistencia {

    public static final String RUTA_PROYECTO = System.getProperty("user.dir");
    public static final String NOMBRE_BASE_DATOS_AUTOR= "autores.txt";
    public static final String NOMBRE_BASE_DATOS_EDITORIAL = "editoriales.txt";
    public static final String NOMBRE_BASE_DATOS_LIBRO= "libros.txt";
    
    public static final String NOMBRE_CARPETA = "La_base_de_datos";
    public static final String NOMBRE_CARPETA_IMAGENES_EXTERNAS = "lasImagenesJajaja";


    public static final String SEPARADOR_COLUMNAS = ";";
    public static final String SEPARADOR_CARPETAS = File.separator;

    public static final String NOMBRE_AUTOR = RUTA_PROYECTO + SEPARADOR_CARPETAS
            + NOMBRE_CARPETA + SEPARADOR_CARPETAS + NOMBRE_BASE_DATOS_AUTOR;

    public static final String NOMBRE_EDITORIAL = RUTA_PROYECTO + SEPARADOR_CARPETAS
            + NOMBRE_CARPETA + SEPARADOR_CARPETAS + NOMBRE_BASE_DATOS_EDITORIAL;
    
    public static final String NOMBRE_LIBRO = RUTA_PROYECTO + SEPARADOR_CARPETAS
            + NOMBRE_CARPETA + SEPARADOR_CARPETAS + NOMBRE_BASE_DATOS_LIBRO;
    
     public static final String RUTA_IMAGENES_INTERNAS = "/org/uni/recurso/imagenes/";
    public static final String RUTA_IMAGENES_EXTERNAS = RUTA_PROYECTO
            + SEPARADOR_CARPETAS + NOMBRE_CARPETA_IMAGENES_EXTERNAS;


}