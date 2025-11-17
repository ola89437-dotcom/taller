/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.dto;

/**
 *
 * @author ruizr
 */
public class DistribuidoraDto {
     private Integer idDistribuidora;
    private String nombreDistribuidora;
    private String paisDistribuidora;
    private Boolean estadoDistribuidora;
    private Short cantidadPeliculasDistribuidora;
    private String nombreImagenPublicoDistribuidora;
    private String nombreImagenPrivadoDistribuidora;

    public DistribuidoraDto() {
    }

    public DistribuidoraDto(Integer idDistribuidora, String nombreDistribuidora, String paisDistribuidora, Boolean estadoDistribuidora, Short cantidadPeliculasDistribuidora, String nombreImagenPublicoDistribuidora, String nombreImagenPrivadoDistribuidora) {
        this.idDistribuidora = idDistribuidora;
        this.nombreDistribuidora = nombreDistribuidora;
        this.paisDistribuidora = paisDistribuidora;
        this.estadoDistribuidora = estadoDistribuidora;
        this.cantidadPeliculasDistribuidora = cantidadPeliculasDistribuidora;
        this.nombreImagenPublicoDistribuidora = nombreImagenPublicoDistribuidora;
        this.nombreImagenPrivadoDistribuidora = nombreImagenPrivadoDistribuidora;
    }

    public Integer getIdDistribuidora() {
        return idDistribuidora;
    }

    public void setIdDistribuidora(Integer idDistribuidora) {
        this.idDistribuidora = idDistribuidora;
    }

    public String getNombreDistribuidora() {
        return nombreDistribuidora;
    }

    public void setNombreDistribuidora(String nombreDistribuidora) {
        this.nombreDistribuidora = nombreDistribuidora;
    }

    public String getPaisDistribuidora() {
        return paisDistribuidora;
    }

    public void setPaisDistribuidora(String paisDistribuidora) {
        this.paisDistribuidora = paisDistribuidora;
    }

    public Boolean getEstadoDistribuidora() {
        return estadoDistribuidora;
    }

    public void setEstadoDistribuidora(Boolean estadoDistribuidora) {
        this.estadoDistribuidora = estadoDistribuidora;
    }

    public Short getCantidadPeliculasDistribuidora() {
        return cantidadPeliculasDistribuidora;
    }

    public void setCantidadPeliculasDistribuidora(Short cantidadPeliculasDistribuidora) {
        this.cantidadPeliculasDistribuidora = cantidadPeliculasDistribuidora;
    }

    public String getNombreImagenPublicoDistribuidora() {
        return nombreImagenPublicoDistribuidora;
    }

    public void setNombreImagenPublicoDistribuidora(String nombreImagenPublicoDistribuidora) {
        this.nombreImagenPublicoDistribuidora = nombreImagenPublicoDistribuidora;
    }

    public String getNombreImagenPrivadoDistribuidora() {
        return nombreImagenPrivadoDistribuidora;
    }

    public void setNombreImagenPrivadoDistribuidora(String nombreImagenPrivadoDistribuidora) {
        this.nombreImagenPrivadoDistribuidora = nombreImagenPrivadoDistribuidora;
    }

    @Override
    public String toString() {
        return "DistribuidoraDto{" + "idDistribuidora=" + idDistribuidora + ", nombreDistribuidora=" + nombreDistribuidora + ", paisDistribuidora=" + paisDistribuidora + ", estadoDistribuidora=" + estadoDistribuidora + ", cantidadPeliculasDistribuidora=" + cantidadPeliculasDistribuidora + ", nombreImagenPublicoDistribuidora=" + nombreImagenPublicoDistribuidora + ", nombreImagenPrivadoDistribuidora=" + nombreImagenPrivadoDistribuidora + '}';
    }
    
    
}
