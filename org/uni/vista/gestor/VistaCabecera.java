package org.uni.vista.gestor;


import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import org.uni.controlador.AutorControladorLista;
import org.uni.controlador.AutorVistaControlador;
import org.uni.controlador.EditorialVistaControlador;
import org.uni.controlador.LibroControladorGrabar;
import org.uni.controlador.LibroControladorListar;
import org.uni.controlador.LibroVistaControlador;
import org.uni.recurso.constante.Configuracion;




     
   public class VistaCabecera extends HBox{
    // Dimensiones de los botones de menú
    private final int menuAncho = 175;
    private final int menuAlto = 35;
    // Espacio entre botones de menú
    private final int menuEspacio = 40;

    // Referencias a la ventana principal y al panel principal
    private final Stage miEscenario;
    private final BorderPane miPanelPrincipal;

    /**
     * Constructor que inicializa la cabecera
     *
     * @param esce la ventana principal (Stage) de la aplicación
     * @param bpan el panel principal (BorderPane) para cambiar el contenido
     * @param altoCabecera altura de la cabecera
     */

    public VistaCabecera(Stage esce, BorderPane bpan, double altoCabecera) {
        miEscenario = esce;
        miPanelPrincipal = bpan;
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(menuEspacio);
        setPadding(new Insets(0, 20, 0, 20));
        setPrefHeight(altoCabecera);
        setStyle(Configuracion.CABECERA_ESTILO_FONDO);

        crearMenus();

    }

    private void agregarBotonMenu(MenuButton miMenu) {
        miMenu.setCursor(Cursor.HAND);
        miMenu.setPrefWidth(menuAncho);
        miMenu.setPrefHeight(menuAlto);
        getChildren().add(miMenu);
    }

 private void crearMenus() {
        menuEditorial();
        menuAutor();
        menuLibro();

    }

 private void menuEditorial() {
    MenuItem opcion1 = new MenuItem("Listar Editoriales");
    MenuItem opcion2 = new MenuItem("Administrar Editoriales");

    opcion1.setOnAction((e) -> {
        miPanelPrincipal.setCenter(
                EditorialVistaControlador.listarEditorial(
                        miEscenario,
                        Configuracion.ANCHO_APP,
                        Configuracion.ALTO_CABECERA)
        );
    });

    opcion2.setOnAction((e) -> {
        miPanelPrincipal.setCenter(
                EditorialVistaControlador.AdministrarEditorial(
                        miEscenario,
                        Configuracion.ANCHO_APP,
                        Configuracion.ALTO_CABECERA)
        );
    });

    MenuButton miBoton = new MenuButton("Editoriales");
    miBoton.getItems().addAll(opcion1, opcion2);
    agregarBotonMenu(miBoton);
}


    private void menuAutor() {
    MenuItem opcion1 = new MenuItem("Listar Autores");
    MenuItem opcion2 = new MenuItem("Administrar Autores");

    opcion1.setOnAction((e) -> {
        miPanelPrincipal.setCenter(
                AutorVistaControlador.listarAutor(
                        miEscenario,
                        Configuracion.ANCHO_APP,
                        Configuracion.ALTO_CABECERA)
        );
    });

    opcion2.setOnAction((e) -> {
        miPanelPrincipal.setCenter(
                AutorVistaControlador.AdministrarAutor(
                        miEscenario,
                        Configuracion.ANCHO_APP,
                        Configuracion.ALTO_CABECERA)
        );
    });

    MenuButton miBoton = new MenuButton("Autores");
    miBoton.getItems().addAll(opcion1, opcion2);
    agregarBotonMenu(miBoton);
}


     private void menuLibro() {
        MenuItem opcion1 = new MenuItem("Crear Libro");
        MenuItem opcion2 = new MenuItem("Listar Libros");
        MenuItem opcion3 = new MenuItem("Administrar Libros");

        opcion1.setOnAction((e) -> {
            miPanelPrincipal.setCenter(
                LibroVistaControlador.crearLibro(
                    miEscenario,
                    Configuracion.ANCHO_APP,
                    Configuracion.ALTO_CABECERA
                )
            );
        });

        opcion2.setOnAction((e) -> {
            miPanelPrincipal.setCenter(
                LibroVistaControlador.listarLibros(
                    miEscenario,
                    Configuracion.ANCHO_APP,
                    Configuracion.ALTO_CABECERA
                )
            );
        });

        opcion3.setOnAction((e) -> {
            miPanelPrincipal.setCenter(
                LibroVistaControlador.AdministrarLibro(
                    miEscenario,
                    Configuracion.ANCHO_APP,
                    Configuracion.ALTO_CABECERA
                )
            );
        });

        MenuButton miBoton = new MenuButton("Libros");
        miBoton.getItems().addAll(opcion1, opcion2, opcion3);
        agregarBotonMenu(miBoton);
    }

   }