/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.modelo;

/**
 *
 * @author ruizr
 */
public class Editorial {
     private Integer idEditorial;
    private String nombreEditorial;
    private String paisEditorial;
    private Short formatoEditorial;
    private Short cantidadLibrosEditorial;

    public Editorial() {
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getPaisEditorial() {
        return paisEditorial;
    }

    public void setPaisEditorial(String paisEditorial) {
        this.paisEditorial = paisEditorial;
    }

    public Short getFormatoEditorial() {
        return formatoEditorial;
    }

    public void setFormatoEditorial(Short formatoEditorial) {
        this.formatoEditorial = formatoEditorial;
    }

    public Short getCantidadLibrosEditorial() {
        return cantidadLibrosEditorial;
    }

    public void setCantidadLibrosEditorial(Short cantidadLibrosEditorial) {
        this.cantidadLibrosEditorial = cantidadLibrosEditorial;
    }

    @Override
    public String toString() {
        return "Editorial{" + "idEditorial=" + idEditorial + ", nombreEditorial=" + nombreEditorial + ", paisEditorial=" + paisEditorial + ", formatoEditorial=" + formatoEditorial + ", cantidadLibrosEditorial=" + cantidadLibrosEditorial + '}';
    }

   
    
    
}
