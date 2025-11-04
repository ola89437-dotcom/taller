package org.uni.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uni.api.ApiOperacionBD;
import org.uni.dto.AutorDto;
import org.uni.modelo.Autor;
import org.uni.recurso.constante.Persistencia;


public class AutorServicio implements ApiOperacionBD<AutorDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public AutorServicio() {
        nombrePersistencia = Persistencia.NOMBRE_AUTOR;
        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(AutorServicio.class.getName()).log(Level.SEVERE, null, ex);
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
    public AutorDto insertInto(AutorDto dto, String ruta) {
        Autor objAutor = new Autor();
        objAutor.setIdAutor(getSerial());
        objAutor.setNombreAutor(dto.getNombreAutor());
        objAutor.setGeneroAutor(dto.getGeneroAutor());
        objAutor.setCanitdadLibrosAutor(dto.getCanitdadLibrosAutor());

        String filaGrabar = objAutor.getIdAutor() + Persistencia.SEPARADOR_COLUMNAS
                + objAutor.getNombreAutor() + Persistencia.SEPARADOR_COLUMNAS
                + objAutor.getGeneroAutor();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdAutor(objAutor.getIdAutor());
            return dto;
        }
        return null;
    }

@Override
public List<AutorDto> selectFrom() {
    List<AutorDto> lista = new ArrayList<>();
    List<String> datos = miArchivo.obtenerDatos();

    for (String cadena : datos) {
        cadena = cadena.replace("@", "");
        String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

        AutorDto dto = new AutorDto();
        dto.setIdAutor(Integer.valueOf(columnas[0].trim()));
        dto.setNombreAutor(columnas[1].trim());

        // ⚙️ Convierte 1 -> true (Masculino), 2 -> false (Femenino)
        int generoNum = Integer.parseInt(columnas[2].trim());
        dto.setGeneroAutor(generoNum == 1);

        // Calcula la cantidad de libros del autor
        short cantidad = contarLibrosPorAutor(dto.getIdAutor());
        dto.setCanitdadLibrosAutor(cantidad);

        lista.add(dto);
    }
    return lista;
}


    @Override
    public int numRows() {
        try {
            return miArchivo.cantidadFilas();
        } catch (IOException ex) {
            Logger.getLogger(AutorServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    

    @Override
    public AutorDto updateSet(Integer codigo, AutorDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AutorDto getOne(Integer idAutor) {
        List<String> datos = miArchivo.obtenerDatos();
        for (String fila : datos) {
            String[] columnas = fila.split(Persistencia.SEPARADOR_COLUMNAS);
            int codigo = Integer.parseInt(columnas[0].trim());
            if (codigo == idAutor) {
                AutorDto dto = new AutorDto();
                dto.setIdAutor(codigo);
                dto.setNombreAutor(columnas[1].trim());
                
                // Convierte el género correctamente: 1 -> true (Masculino), 2 -> false (Femenino)
                int generoNum = Integer.parseInt(columnas[2].replace("@", "").trim());
                dto.setGeneroAutor(generoNum == 1);
                
                // Calcula la cantidad de libros del autor (ahora es seguro)
                short cantidad = contarLibrosPorAutor(dto.getIdAutor());
                dto.setCanitdadLibrosAutor(cantidad);

                return dto;
            }
        }
        return null;
    }

    // 🔹 Cuenta libros asociados a un autor (sin dependencia circular)
    public short contarLibrosPorAutor(int idAutor) {
        short cantidad = 0;
        try {
            // Leer directamente el archivo de libros para evitar dependencia circular
            NioFile archivoLibros = new NioFile(Persistencia.NOMBRE_LIBRO);
            List<String> datosLibros = archivoLibros.obtenerDatos();
            
            for (String cadena : datosLibros) {
                if (cadena.isBlank()) continue;
                cadena = cadena.replace("@", "").trim();
                String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);
                
                if (columnas.length >= 6) {
                    int idAutorLibro = Integer.parseInt(columnas[5].trim());
                    if (idAutorLibro == idAutor) {
                        cantidad++;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AutorServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean delectFrom(Integer codigo) {
        try {
            // Regla: si el autor tiene libros, no se elimina
            short cantidad = contarLibrosPorAutor(codigo);
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

            java.nio.file.Files.write(java.nio.file.Paths.get(Persistencia.NOMBRE_AUTOR), nuevos);
            return eliminado;
        } catch (IOException ex) {
            Logger.getLogger(AutorServicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
