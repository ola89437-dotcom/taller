package org.uni.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uni.api.ApiOperacionBD;
import org.uni.dto.AutorDto;
import org.uni.dto.EditorialDto;
import org.uni.dto.LibroDto;
import org.uni.modelo.Autor;
import org.uni.modelo.Editorial;
import org.uni.modelo.Libro;
import org.uni.recurso.constante.Persistencia;
import org.uni.servicio.AutorServicio;
import org.uni.servicio.EditorialServicio;



public class LibroServicio implements ApiOperacionBD<LibroDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public LibroServicio() {
        nombrePersistencia = Persistencia.NOMBRE_LIBRO;
        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;
        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public LibroDto insertInto(LibroDto dto, String ruta) {
        Editorial objEditorial = new Editorial();
        objEditorial.setIdEditorial(dto.getIdEditorial().getIdEditorial());
        objEditorial.setNombreEditorial(dto.getIdEditorial().getNombreEditorial());
        objEditorial.setPaisEditorial(dto.getIdEditorial().getPaisEditorial());
        objEditorial.setFormatoEditorial(dto.getIdEditorial().getFormatoEditorial());
        objEditorial.setCantidadLibrosEditorial(dto.getIdEditorial().getCanitdadLibrosEditorial());

        Autor objAutor = new Autor();
        objAutor.setIdAutor(dto.getIdAutor().getIdAutor());
        objAutor.setNombreAutor(dto.getIdAutor().getNombreAutor());
        objAutor.setGeneroAutor(dto.getIdAutor().getGeneroAutor());
        objAutor.setCanitdadLibrosAutor(dto.getIdAutor().getCanitdadLibrosAutor());

        Libro objLibro = new Libro();
        objLibro.setIdLibro(getSerial());
        objLibro.setNombreLibro(dto.getNombreLibro());
        objLibro.setPrecioLibro(dto.getPrecioLibro());
        objLibro.setAnioLibro(dto.getAnioLibro());
        objLibro.setIdEditorial(objEditorial);
        objLibro.setIdAutor(objAutor);

        String filaGrabar = objLibro.getIdLibro() + Persistencia.SEPARADOR_COLUMNAS
                + objLibro.getNombreLibro() + Persistencia.SEPARADOR_COLUMNAS
                + String.format("%.2f", objLibro.getPrecioLibro()) + Persistencia.SEPARADOR_COLUMNAS
                + objLibro.getAnioLibro() + Persistencia.SEPARADOR_COLUMNAS
                + objLibro.getIdEditorial().getIdEditorial() + Persistencia.SEPARADOR_COLUMNAS
                + objLibro.getIdAutor().getIdAutor();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdLibro(objLibro.getIdLibro());
            return dto;
        }
        return dto;
    }

    @Override
    public List<LibroDto> selectFrom() {
        List<LibroDto> lista = new ArrayList<>();
        List<String> datos = miArchivo.obtenerDatos();

        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();

        for (String cadena : datos) {
            if (cadena.isBlank()) continue;
            cadena = cadena.replace("@", "").trim();
            String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

            if (columnas.length < 6) continue;

            int idLibro = Integer.parseInt(columnas[0].trim());
            String nombre = columnas[1].trim();
            double precio = Double.parseDouble(columnas[2].trim().replace(",", "."));
            short anio = Short.parseShort(columnas[3].trim());
            int idEditorial = Integer.parseInt(columnas[4].trim());
            int idAutor = Integer.parseInt(columnas[5].trim());
            

            EditorialDto editorial= editorialServicio.getOne(idEditorial);
            AutorDto autor=  autorServicio.getOne(idAutor);
            
//            EditorialDto editorial = editorialServicio.getOne(idEditorial);
//            AutorDto autor = autorServicio.getOne(idAutor);

            LibroDto dto = new LibroDto();
            dto.setIdLibro(idLibro);
            dto.setNombreLibro(nombre);
            dto.setPrecioLibro(precio);
            dto.setAnioLibro(anio);
            dto.setIdEditorial(editorial);
            dto.setIdAutor(autor);

            lista.add(dto);
        }

        return lista;
    
    }

    @Override
    public int numRows() {
        try {
            return miArchivo.cantidadFilas();
        } catch (IOException ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

 
    @Override
    public LibroDto updateSet(Integer codigo, LibroDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LibroDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short contarLibrosPorAutor(int idAutor) {
        List<LibroDto> libros = selectFrom();
        short cantidad = 0;
        for (LibroDto libro : libros) {
            if (libro.getIdAutor() != null && libro.getIdAutor().getIdAutor() == idAutor) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public short contarLibrosPorEditorial(int idEditorial) {
        List<LibroDto> libros = selectFrom();
        short cantidad = 0;
        for (LibroDto libro : libros) {
            if (libro.getIdEditorial() != null && libro.getIdEditorial().getIdEditorial() == idEditorial) {
                cantidad++;
            }
        }
        return cantidad;
    }

    @Override
    public Boolean delectFrom(Integer codigo) {
      Boolean correcto = false;
        try {
            List<String> arreglo;
            arreglo = miArchivo.borrarFilaPosicion(codigo);
            if (!arreglo.isEmpty()) {
                correcto = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

}