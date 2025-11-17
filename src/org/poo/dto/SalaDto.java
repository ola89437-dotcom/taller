/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.dto;

/**
 *
 * @author ruizr
 */
public class SalaDto {
    
    private Integer idSala;
    private String nombreSala;
    private Short capacidadSala;
    private Short cantidadFuncionesSala;

    public SalaDto() {
    }

    public SalaDto(Integer idSala, String nombreSala, Short capacidadSala, Short cantidadFuncionesSala) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.capacidadSala = capacidadSala;
        this.cantidadFuncionesSala = cantidadFuncionesSala;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Short getCapacidadSala() {
        return capacidadSala;
    }

    public void setCapacidadSala(Short capacidadSala) {
        this.capacidadSala = capacidadSala;
    }

    public Short getCantidadFuncionesSala() {
        return cantidadFuncionesSala;
    }

    public void setCantidadFuncionesSala(Short cantidadFuncionesSala) {
        this.cantidadFuncionesSala = cantidadFuncionesSala;
    }

    @Override
    public String toString() {
        return "SalaDto{" + "idSala=" + idSala + ", nombreSala=" + nombreSala + ", capacidadSala=" + capacidadSala + ", cantidadFuncionesSala=" + cantidadFuncionesSala + '}';
    }

    
}
