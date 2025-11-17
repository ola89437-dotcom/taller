/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.dto;

import org.poo.modelo.Cliente;
import org.poo.modelo.Funcion;

/**
 *
 * @author ruizr
 */
public class BoletaDto {
       private Integer idBoleta;
    private String numeroAsientoBoleta;
    private String fechaCompraBoleta;
    private Funcion funcionBoleta;
    private Cliente clienteBoleta;
    private Boolean estadoBoleta;

    public BoletaDto() {
    }

    public BoletaDto(Integer idBoleta, String numeroAsientoBoleta, String fechaCompraBoleta, Funcion funcionBoleta, Cliente clienteBoleta, Boolean estadoBoleta) {
        this.idBoleta = idBoleta;
        this.numeroAsientoBoleta = numeroAsientoBoleta;
        this.fechaCompraBoleta = fechaCompraBoleta;
        this.funcionBoleta = funcionBoleta;
        this.clienteBoleta = clienteBoleta;
        this.estadoBoleta = estadoBoleta;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getNumeroAsientoBoleta() {
        return numeroAsientoBoleta;
    }

    public void setNumeroAsientoBoleta(String numeroAsientoBoleta) {
        this.numeroAsientoBoleta = numeroAsientoBoleta;
    }

    public String getFechaCompraBoleta() {
        return fechaCompraBoleta;
    }

    public void setFechaCompraBoleta(String fechaCompraBoleta) {
        this.fechaCompraBoleta = fechaCompraBoleta;
    }

    public Funcion getFuncionBoleta() {
        return funcionBoleta;
    }

    public void setFuncionBoleta(Funcion funcionBoleta) {
        this.funcionBoleta = funcionBoleta;
    }

    public Cliente getClienteBoleta() {
        return clienteBoleta;
    }

    public void setClienteBoleta(Cliente clienteBoleta) {
        this.clienteBoleta = clienteBoleta;
    }

    public Boolean getEstadoBoleta() {
        return estadoBoleta;
    }

    public void setEstadoBoleta(Boolean estadoBoleta) {
        this.estadoBoleta = estadoBoleta;
    }

    @Override
    public String toString() {
        return "BoletaDto{" + "idBoleta=" + idBoleta + ", numeroAsientoBoleta=" + numeroAsientoBoleta + ", fechaCompraBoleta=" + fechaCompraBoleta + ", funcionBoleta=" + funcionBoleta + ", clienteBoleta=" + clienteBoleta + ", estadoBoleta=" + estadoBoleta + '}';
    }
    
    
}
