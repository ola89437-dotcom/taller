/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uni.vista.autor;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uni.controlador.AutorControladorLista;
import org.uni.controlador.AutorControladorEliminar;
import org.uni.controlador.EditorialControladorListar;
import org.uni.dto.AutorDto;
import org.uni.recurso.constante.Configuracion;
import org.uni.recurso.utilidad.Icono;
import org.uni.recurso.utilidad.Marco;
import org.uni.recurso.utilidad.Mensaje;

/**
 *
 * @author ruizr
 */
public class VistaAutorAdministrar extends StackPane {

    private final Rectangle marco;
    private final Stage miEscenario;
    private final VBox cajaVertical;
    private final TableView<AutorDto> miTabla;

    private static final String ESTILO_CENTRAR = "-fx-alignment: CENTER;";
    private static final String ESTILO_DERECHA = "-fx-alignment: CENTER-RIGHT;";
    private static final String ESTILO_IZQUIERDA = "-fx-alignment: CENTER-LEFT;";
    private static final String ESTILO_ROJO = "-fx-text-fill: red;" + ESTILO_CENTRAR;
    private static final String ESTILO_VERDE = "-fx-text-fill: green;" + ESTILO_CENTRAR;

    private Text titulo;
    private HBox cajaBotones;

    public VistaAutorAdministrar(Stage ventanaPadre, double ancho, double alto) {
        setAlignment(Pos.CENTER);
        miEscenario = ventanaPadre;
        marco = Marco.crear(miEscenario,
                Configuracion.MARCO_ALTO_PORCENTAJE,
                Configuracion.MARCO_ANCHO_PORCENTAJE,
                Configuracion.DEGRADE_ARREGLO,
                Configuracion.DEGRADDE_BORDE
        );

        miTabla = new TableView<>();
        cajaVertical = new VBox(20);
        getChildren().add(marco);

        configurarCajaVertical();
        crearTitulo();
        crearTabla();
        losIconosAdmin();
    }

    private void configurarCajaVertical() {
        cajaVertical.setAlignment(Pos.TOP_CENTER);
        cajaVertical.prefWidthProperty().bind(miEscenario.widthProperty());
        cajaVertical.prefHeightProperty().bind(miEscenario.heightProperty());
    }

    private void crearTitulo() {
        Region bloqueSeparador = new Region();
        bloqueSeparador.prefHeightProperty().bind(
                miEscenario.heightProperty().multiply(0.05));

              int cant = EditorialControladorListar.obtenerCantidadEditoriales();
        titulo = new Text("ADMINISTRAR EDITORIALES (" + cant + ")");
        titulo.setFill(Color.web(Configuracion.AZUL_MEDIO));
        titulo.setFont(Font.font("Rockwell", FontWeight.BOLD, 28));

        cajaVertical.getChildren().addAll(bloqueSeparador, titulo);
    }

    private TableColumn<AutorDto, Integer> crearColumnaCodigo() {
        TableColumn<AutorDto, Integer> columna = new TableColumn<>("Código");
        columna.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.2));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<AutorDto, String> crearColumnaNombre() {
        TableColumn<AutorDto, String> columna = new TableColumn<>("Nombre");
        columna.setCellValueFactory(new PropertyValueFactory<>("nombreAutor"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.3));
        columna.setStyle(ESTILO_IZQUIERDA);
        return columna;
    }

    private TableColumn<AutorDto, String> crearColumnaGenero() {
        TableColumn<AutorDto, String> columna = new TableColumn<>("Género");
        columna.setCellValueFactory(obj -> {
            String genero = obj.getValue().getGeneroAutor() ? "Masculino" : "Femenino";
            return new SimpleStringProperty(genero);
        });
        columna.setStyle(ESTILO_CENTRAR);
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.25));
        return columna;
    }

    private TableColumn<AutorDto, String> crearColumnaCantidad() {
        TableColumn<AutorDto, String> columna = new TableColumn<>("Cantidad Libros");
        columna.setCellValueFactory(obj ->
                new SimpleStringProperty(String.valueOf(obj.getValue().getCanitdadLibrosAutor()))
        );
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.25));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private void configurarColumnas() {
        miTabla.getColumns().addAll(
                crearColumnaCodigo(),
                crearColumnaNombre(),
                crearColumnaGenero(),
                crearColumnaCantidad()
        );
    }

    private void crearTabla() {
        configurarColumnas();

        List<AutorDto> listaAutores = AutorControladorLista.obtenerAutores();
        ObservableList<AutorDto> datosTabla = FXCollections.observableArrayList(listaAutores);

        miTabla.setItems(datosTabla);
        miTabla.setPlaceholder(new Text("No hay autores registrados"));
        miTabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        miTabla.maxWidthProperty().bind(miEscenario.widthProperty().multiply(0.60));
        miTabla.maxHeightProperty().bind(miEscenario.heightProperty().multiply(0.50));

        miEscenario.heightProperty().addListener((o, oldVal, newVal)
                -> miTabla.setPrefHeight(newVal.doubleValue()));
        VBox.setVgrow(miTabla, Priority.ALWAYS);

        cajaVertical.getChildren().add(miTabla);
        getChildren().add(cajaVertical);
    }

    private void losIconosAdmin() {
        int ancho = 40;
        int tamanioIconito = 16;

        // Botón eliminar
        Button btnEliminar = new Button();
        btnEliminar.setPrefWidth(ancho);
        btnEliminar.setCursor(Cursor.HAND);
        btnEliminar.setGraphic(Icono.obtenerIcono(
                Configuracion.ICONO_BORRAR, tamanioIconito));
        btnEliminar.setOnAction((e) -> {
            if (miTabla.getSelectionModel().getSelectedItem() == null) {
                Mensaje.mostrar(Alert.AlertType.WARNING,
                        miEscenario, "Atención", "Selecciona un autor primero");
            } else {
                AutorDto autorSel = miTabla.getSelectionModel().getSelectedItem();

                // Validar si tiene libros
                if (autorSel.getCanitdadLibrosAutor() == null || autorSel.getCanitdadLibrosAutor() == 0) {
                    Alert msg = new Alert(Alert.AlertType.CONFIRMATION);
                    msg.setTitle("Confirmar eliminación");
                    msg.setHeaderText(null);
                    msg.setContentText("¿Seguro que deseas eliminar este autor?\n\nCódigo: "
                            + autorSel.getIdAutor()
                            + "\nNombre: " + autorSel.getNombreAutor());
                    msg.initOwner(miEscenario);
                    if (msg.showAndWait().get() == ButtonType.OK) {
                        int pos = miTabla.getSelectionModel().getSelectedIndex();
                        if (AutorControladorEliminar.borrar(pos)) {
                            List<AutorDto> listaAutores = AutorControladorLista.obtenerAutores();
                            ObservableList<AutorDto> datosTabla = FXCollections.observableArrayList(listaAutores);
                            miTabla.setItems(datosTabla);
                            miTabla.refresh();
                            Mensaje.mostrar(Alert.AlertType.INFORMATION,
                                    miEscenario, "Éxito", "Autor eliminado correctamente");
                        } else {
                            Mensaje.mostrar(Alert.AlertType.ERROR,
                                    miEscenario, "Error", "No se pudo eliminar el autor");
                        }
                    }
                } else {
                    Mensaje.mostrar(Alert.AlertType.ERROR,
                            miEscenario, "Operación no permitida",
                            "No puedes eliminar un autor con libros asociados");
                }
            }
        });

        // Botón actualizar
        Button btnActualizar = new Button();
        btnActualizar.setPrefWidth(ancho);
        btnActualizar.setCursor(Cursor.HAND);
        btnActualizar.setGraphic(Icono.obtenerIcono(
                Configuracion.ICONO_EDITAR, tamanioIconito));
        btnActualizar.setOnAction((e) -> {
            System.out.println("Actualizar autor seleccionado");
        });

        // Botón cancelar
        Button btnCancelar = new Button();
        btnCancelar.setPrefWidth(ancho);
        btnCancelar.setCursor(Cursor.HAND);
        btnCancelar.setGraphic(Icono.obtenerIcono(
                Configuracion.ICONO_CANCELAR, tamanioIconito));
        btnCancelar.setOnAction((e) -> {
            miTabla.getSelectionModel().clearSelection();
        });

        cajaBotones = new HBox(5);
        cajaBotones.setAlignment(Pos.CENTER);
        cajaBotones.getChildren().addAll(btnEliminar, btnActualizar, btnCancelar);
        cajaVertical.getChildren().add(cajaBotones);
    }
}
