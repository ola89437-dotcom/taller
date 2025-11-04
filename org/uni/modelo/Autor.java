/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.modelo;

/**
 *
 * @author ruizr
 */
public class Autor {
      private Integer idAutor;
    private String nombreAutor;
    private Boolean generoAutor;
    private Short canitdadLibrosAutor;

    public Autor() {
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Boolean getGeneroAutor() {
        return generoAutor;
    }

    public void setGeneroAutor(Boolean generoAutor) {
        this.generoAutor = generoAutor;
    }

    public Short getCanitdadLibrosAutor() {
        return canitdadLibrosAutor;
    }

    public void setCanitdadLibrosAutor(Short canitdadLibrosAutor) {
        this.canitdadLibrosAutor = canitdadLibrosAutor;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + ", generoAutor=" + generoAutor + ", canitdadLibrosAutor=" + canitdadLibrosAutor + '}';
    }

   
    
}
