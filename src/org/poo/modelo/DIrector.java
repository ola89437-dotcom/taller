/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.modelo;

/**
 *
 * @author ruizr
 */
public class DIrector {
     private Integer idDirector;
    private String nombreDirector;
    private String nacionalidadDirector;
    private Short cantidadPeliculasDirector;
    private String nombreImagenPublicoDirector;
    private String nombreImagenPrivadoDirector;

    public DIrector() {
    }

    public DIrector(Integer idDirector, String nombreDirector, String nacionalidadDirector, Short cantidadPeliculasDirector, String nombreImagenPublicoDirector, String nombreImagenPrivadoDirector) {
        this.idDirector = idDirector;
        this.nombreDirector = nombreDirector;
        this.nacionalidadDirector = nacionalidadDirector;
        this.cantidadPeliculasDirector = cantidadPeliculasDirector;
        this.nombreImagenPublicoDirector = nombreImagenPublicoDirector;
        this.nombreImagenPrivadoDirector = nombreImagenPrivadoDirector;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getNacionalidadDirector() {
        return nacionalidadDirector;
    }

    public void setNacionalidadDirector(String nacionalidadDirector) {
        this.nacionalidadDirector = nacionalidadDirector;
    }

    public Short getCantidadPeliculasDirector() {
        return cantidadPeliculasDirector;
    }

    public void setCantidadPeliculasDirector(Short cantidadPeliculasDirector) {
        this.cantidadPeliculasDirector = cantidadPeliculasDirector;
    }

    public String getNombreImagenPublicoDirector() {
        return nombreImagenPublicoDirector;
    }

    public void setNombreImagenPublicoDirector(String nombreImagenPublicoDirector) {
        this.nombreImagenPublicoDirector = nombreImagenPublicoDirector;
    }

    public String getNombreImagenPrivadoDirector() {
        return nombreImagenPrivadoDirector;
    }

    public void setNombreImagenPrivadoDirector(String nombreImagenPrivadoDirector) {
        this.nombreImagenPrivadoDirector = nombreImagenPrivadoDirector;
    }

    @Override
    public String toString() {
        return "DIrector{" + "idDirector=" + idDirector + ", nombreDirector=" + nombreDirector + ", nacionalidadDirector=" + nacionalidadDirector + ", cantidadPeliculasDirector=" + cantidadPeliculasDirector + ", nombreImagenPublicoDirector=" + nombreImagenPublicoDirector + ", nombreImagenPrivadoDirector=" + nombreImagenPrivadoDirector + '}';
    }
    
    
}
