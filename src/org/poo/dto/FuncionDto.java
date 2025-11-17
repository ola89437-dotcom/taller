/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.dto;

import org.poo.modelo.Pelicula;
import org.poo.modelo.Sala;

/**
 *
 * @author ruizr
 */
public class FuncionDto {
      private Integer idFuncion;
    private String fechaFuncion;
    private String horaFuncion;
    private Double precioFuncion;
    private Pelicula peliculaFuncion;
    private Sala salaFuncion;
    private Short cantidadBoletasFuncion;

    public FuncionDto() {
    }

    public FuncionDto(Integer idFuncion, String fechaFuncion, String horaFuncion, Double precioFuncion, Pelicula peliculaFuncion, Sala salaFuncion, Short cantidadBoletasFuncion) {
        this.idFuncion = idFuncion;
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.precioFuncion = precioFuncion;
        this.peliculaFuncion = peliculaFuncion;
        this.salaFuncion = salaFuncion;
        this.cantidadBoletasFuncion = cantidadBoletasFuncion;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(String fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(String horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public Double getPrecioFuncion() {
        return precioFuncion;
    }

    public void setPrecioFuncion(Double precioFuncion) {
        this.precioFuncion = precioFuncion;
    }

    public Pelicula getPeliculaFuncion() {
        return peliculaFuncion;
    }

    public void setPeliculaFuncion(Pelicula peliculaFuncion) {
        this.peliculaFuncion = peliculaFuncion;
    }

    public Sala getSalaFuncion() {
        return salaFuncion;
    }

    public void setSalaFuncion(Sala salaFuncion) {
        this.salaFuncion = salaFuncion;
    }

    public Short getCantidadBoletasFuncion() {
        return cantidadBoletasFuncion;
    }

    public void setCantidadBoletasFuncion(Short cantidadBoletasFuncion) {
        this.cantidadBoletasFuncion = cantidadBoletasFuncion;
    }

    @Override
    public String toString() {
        return "FuncionDto{" + "idFuncion=" + idFuncion + ", fechaFuncion=" + fechaFuncion + ", horaFuncion=" + horaFuncion + ", precioFuncion=" + precioFuncion + ", peliculaFuncion=" + peliculaFuncion + ", salaFuncion=" + salaFuncion + ", cantidadBoletasFuncion=" + cantidadBoletasFuncion + '}';
    }
    
    
}
