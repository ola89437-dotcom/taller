package org.uni.dto;

import org.uni.dto.AutorDto;
import org.uni.dto.EditorialDto;

public class LibroDto {
        private Integer idLibro;
    private String nombreLibro;
    private Double precioLibro;
    private Short anioLibro;
    private EditorialDto idEditorial;
    private AutorDto idAutor;

    public LibroDto() {
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(Double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public Short getAnioLibro() {
        return anioLibro;
    }

    public void setAnioLibro(Short anioLibro) {
        this.anioLibro = anioLibro;
    }

    public EditorialDto getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(EditorialDto idEditorial) {
        this.idEditorial = idEditorial;
    }

    public AutorDto getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(AutorDto idAutor) {
        this.idAutor = idAutor;
    }

   
   

  
    

}
