package org.uni.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uni.api.ApiOperacionBD;
import org.uni.dto.EditorialDto;
import org.uni.modelo.Editorial;
import org.uni.recurso.constante.Persistencia;
import org.uni.servicio.AutorServicio;


public class EditorialServicio implements ApiOperacionBD<EditorialDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public EditorialServicio() {
        nombrePersistencia = Persistencia.NOMBRE_EDITORIAL;
        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(EditorialServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getSerial() {
        int id = 0;
        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(AutorServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public EditorialDto insertInto(EditorialDto dto, String ruta) {
        Editorial objEditorial = new Editorial();
        objEditorial.setIdEditorial(getSerial());
        objEditorial.setNombreEditorial(dto.getNombreEditorial());
        objEditorial.setPaisEditorial(dto.getPaisEditorial());
        objEditorial.setCantidadLibrosEditorial(dto.getCanitdadLibrosEditorial());
        objEditorial.setFormatoEditorial(dto.getFormatoEditorial());

        String filaGrabar
                = objEditorial.getIdEditorial() + Persistencia.SEPARADOR_COLUMNAS
                + objEditorial.getNombreEditorial() + Persistencia.SEPARADOR_COLUMNAS
                + objEditorial.getPaisEditorial() + Persistencia.SEPARADOR_COLUMNAS
                + objEditorial.getFormatoEditorial();
        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdEditorial(objEditorial.getIdEditorial());
            return dto;
        }
        return null;

    }

    @Override
    public List<EditorialDto> selectFrom() {
        List<EditorialDto> lista = new ArrayList<>();
        List<String> datos = miArchivo.obtenerDatos();

        for (String cadena : datos) {
            cadena = cadena.replace("@", "");
            String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

            EditorialDto dto = new EditorialDto();
            dto.setIdEditorial(Integer.valueOf(columnas[0].trim()));
            dto.setNombreEditorial(columnas[1].trim());
            dto.setPaisEditorial(columnas[2].trim());
            dto.setFormatoEditorial(Short.valueOf(columnas[3].replace("@", "").trim()));
            
            // Calcula la cantidad de libros de la editorial
            short cantidad = contarLibrosPorEditorial(dto.getIdEditorial());
            dto.setCanitdadLibrosEditorial(cantidad);
            
            lista.add(dto);
        }
        return lista;
    }
    @Override
    public int numRows() {
        try {
            return miArchivo.cantidadFilas();
        } catch (IOException ex) {
            Logger.getLogger(EditorialServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

  

    @Override
    public EditorialDto updateSet(Integer codigo, EditorialDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EditorialDto getOne(Integer idEditorial) {
        List<String> datos = miArchivo.obtenerDatos();
        for (String fila : datos) {
            String[] columnas = fila.split(Persistencia.SEPARADOR_COLUMNAS);
            int codigo = Integer.parseInt(columnas[0].trim());
            if (codigo == idEditorial) {
                EditorialDto dto = new EditorialDto();
                dto.setIdEditorial(codigo);
                dto.setNombreEditorial(columnas[1].trim());
                dto.setPaisEditorial(columnas[2].trim());
                dto.setFormatoEditorial(Short.valueOf(columnas[3].replace("@", "").trim()));
                
                // Calcula la cantidad de libros de la editorial
                short cantidad = contarLibrosPorEditorial(dto.getIdEditorial());
                dto.setCanitdadLibrosEditorial(cantidad);

                return dto;
            }
        }
        return null;
    }
    public short contarLibrosPorEditorial(int idEditorial) {
        short cantidad = 0;
        try {
            // Leer directamente el archivo de libros para evitar dependencia circular
            NioFile archivoLibros = new NioFile(Persistencia.NOMBRE_LIBRO);
            List<String> datosLibros = archivoLibros.obtenerDatos();
            
            for (String cadena : datosLibros) {
                if (cadena == null || cadena.trim().isEmpty()) continue;
                
                cadena = cadena.replace("@", "").trim();
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);
                
                if (columnas.length >= 5) {
                    try {
                        int idEditorialLibro = Integer.parseInt(columnas[4].trim());
                        if (idEditorialLibro == idEditorial) {
                            cantidad++;
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar líneas con formato incorrecto
                        continue;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EditorialServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean delectFrom(Integer codigo) {
        try {
            // Regla: si la editorial tiene libros, no se elimina
            short cantidad = contarLibrosPorEditorial(codigo);
            if (cantidad > 0) {
                return false;
            }

            List<String> datos = miArchivo.obtenerDatos();
            if (datos == null || datos.isEmpty()) return false;

            List<String> nuevos = new ArrayList<>();
            boolean eliminado = false;

            for (String fila : datos) {
                if (fila == null || fila.isBlank()) continue;
                String limpia = fila.replace("@", "").trim();
                String[] columnas = limpia.split(Persistencia.SEPARADOR_COLUMNAS);
                if (columnas.length == 0) continue;
                try {
                    int id = Integer.parseInt(columnas[0].trim());
                    if (id == codigo) {
                        eliminado = true;
                        continue; // omitir
                    }
                } catch (NumberFormatException e) {
                    // conservar línea si está corrupta
                }
                nuevos.add(fila);
            }

            java.nio.file.Files.write(java.nio.file.Paths.get(Persistencia.NOMBRE_EDITORIAL), nuevos);
            return eliminado;
        } catch (IOException ex) {
            Logger.getLogger(EditorialServicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
}
