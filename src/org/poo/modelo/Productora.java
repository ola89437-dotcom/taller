/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.modelo;

/**
 *
 * @author ruizr
 */
public class Productora {
   private Integer idProductora;
    private String nombreProductora;
    private String fundadorProductora;
    private String paisProductora;
    private Short cantidadPeliculasProductora;
    private String nombreImagenPublicoProductora;
    private String nombreImagenPrivadoProductora;

    public Productora() {
    }

    public Productora(Integer idProductora, String nombreProductora, String fundadorProductora, String paisProductora, Short cantidadPeliculasProductora, String nombreImagenPublicoProductora, String nombreImagenPrivadoProductora) {
        this.idProductora = idProductora;
        this.nombreProductora = nombreProductora;
        this.fundadorProductora = fundadorProductora;
        this.paisProductora = paisProductora;
        this.cantidadPeliculasProductora = cantidadPeliculasProductora;
        this.nombreImagenPublicoProductora = nombreImagenPublicoProductora;
        this.nombreImagenPrivadoProductora = nombreImagenPrivadoProductora;
    }

    public Integer getIdProductora() {
        return idProductora;
    }

    public void setIdProductora(Integer idProductora) {
        this.idProductora = idProductora;
    }

    public String getNombreProductora() {
        return nombreProductora;
    }

    public void setNombreProductora(String nombreProductora) {
        this.nombreProductora = nombreProductora;
    }

    public String getFundadorProductora() {
        return fundadorProductora;
    }

    public void setFundadorProductora(String fundadorProductora) {
        this.fundadorProductora = fundadorProductora;
    }

    public String getPaisProductora() {
        return paisProductora;
    }

    public void setPaisProductora(String paisProductora) {
        this.paisProductora = paisProductora;
    }

    public Short getCantidadPeliculasProductora() {
        return cantidadPeliculasProductora;
    }

    public void setCantidadPeliculasProductora(Short cantidadPeliculasProductora) {
        this.cantidadPeliculasProductora = cantidadPeliculasProductora;
    }

    public String getNombreImagenPublicoProductora() {
        return nombreImagenPublicoProductora;
    }

    public void setNombreImagenPublicoProductora(String nombreImagenPublicoProductora) {
        this.nombreImagenPublicoProductora = nombreImagenPublicoProductora;
    }

    public String getNombreImagenPrivadoProductora() {
        return nombreImagenPrivadoProductora;
    }

    public void setNombreImagenPrivadoProductora(String nombreImagenPrivadoProductora) {
        this.nombreImagenPrivadoProductora = nombreImagenPrivadoProductora;
    }

    @Override
    public String toString() {
        return "Productora{" + "idProductora=" + idProductora + ", nombreProductora=" + nombreProductora + ", fundadorProductora=" + fundadorProductora + ", paisProductora=" + paisProductora + ", cantidadPeliculasProductora=" + cantidadPeliculasProductora + ", nombreImagenPublicoProductora=" + nombreImagenPublicoProductora + ", nombreImagenPrivadoProductora=" + nombreImagenPrivadoProductora + '}';
    }
    
    
}
