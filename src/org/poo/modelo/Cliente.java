/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.poo.modelo;

/**
 *
 * @author ruizr
 */
public class Cliente {
 
    private Integer idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String documentoCliente;
    private String telefonoCliente;
    private String emailCliente;
    private Short cantidadBoletasCliente;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombreCliente, String apellidoCliente, String documentoCliente, String telefonoCliente, String emailCliente, Short cantidadBoletasCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.documentoCliente = documentoCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.cantidadBoletasCliente = cantidadBoletasCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Short getCantidadBoletasCliente() {
        return cantidadBoletasCliente;
    }

    public void setCantidadBoletasCliente(Short cantidadBoletasCliente) {
        this.cantidadBoletasCliente = cantidadBoletasCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", documentoCliente=" + documentoCliente + ", telefonoCliente=" + telefonoCliente + ", emailCliente=" + emailCliente + ", cantidadBoletasCliente=" + cantidadBoletasCliente + '}';
    }

  
}
