
package org.uni.vista.editorial;

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
import org.uni.controlador.EditorialControladorEliminar;
import org.uni.controlador.EditorialControladorListar;
import org.uni.dto.EditorialDto;
import org.uni.recurso.constante.Configuracion;
import org.uni.recurso.utilidad.Icono;
import org.uni.recurso.utilidad.Marco;
import org.uni.recurso.utilidad.Mensaje;

/**
 *
 * @author ruizr
 */
public class VistaEditorialAdministrar extends StackPane {

    private final Rectangle marco;
    private final Stage miEscenario;
    private final VBox cajaVertical;
    private final TableView<EditorialDto> miTabla;

    private static final String ESTILO_CENTRAR = "-fx-alignment: CENTER;";
    private static final String ESTILO_DERECHA = "-fx-alignment: CENTER-RIGHT;";
    private static final String ESTILO_IZQUIERDA = "-fx-alignment: CENTER-LEFT;";
    private static final String ESTILO_ROJO = "-fx-text-fill: red;" + ESTILO_CENTRAR;
    private static final String ESTILO_VERDE = "-fx-text-fill: green;" + ESTILO_CENTRAR;

    private Text titulo;
    private HBox cajaBotones;

    public VistaEditorialAdministrar(Stage ventanaPadre, double ancho, double alto) {
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
        titulo.setFill(Color.web(Configuracion.AZUL_BRILLANTE));
        titulo.setFont(Font.font("Rockwell", FontWeight.BOLD, 28));

        cajaVertical.getChildren().addAll(bloqueSeparador, titulo);
    }

    private TableColumn<EditorialDto, Integer> crearColumnaCodigo() {
        TableColumn<EditorialDto, Integer> columna = new TableColumn<>("Código");
        columna.setCellValueFactory(new PropertyValueFactory<>("idEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.2));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, String> crearColumnaNombre() {
        TableColumn<EditorialDto, String> columna = new TableColumn<>("Nombre");
        columna.setCellValueFactory(new PropertyValueFactory<>("nombreEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.3));
        columna.setStyle(ESTILO_IZQUIERDA);
        return columna;
    }

    private TableColumn<EditorialDto, String> crearColumnaPais() {
        TableColumn<EditorialDto, String> columna = new TableColumn<>("País");
        columna.setCellValueFactory(new PropertyValueFactory<>("paisEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.25));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, String> crearColumnaCantidad() {
        TableColumn<EditorialDto, String> columna = new TableColumn<>("Cantidad Libros");
        columna.setCellValueFactory(obj ->
                new SimpleStringProperty(String.valueOf(obj.getValue().getCanitdadLibrosEditorial()))
        );
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.25));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private void configurarColumnas() {
        miTabla.getColumns().addAll(
                crearColumnaCodigo(),
                crearColumnaNombre(),
                crearColumnaPais(),
                crearColumnaCantidad()
        );
    }

    private void crearTabla() {
        configurarColumnas();

        List<EditorialDto> listaEditoriales =  EditorialControladorListar.obtenerEditorail();
        ObservableList<EditorialDto> datosTabla = FXCollections.observableArrayList(listaEditoriales);

        miTabla.setItems(datosTabla);
        miTabla.setPlaceholder(new Text("No hay editoriales registradas"));
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
                        miEscenario, "Atención", "Selecciona una editorial primero");
            } else {
                EditorialDto editorialSel = miTabla.getSelectionModel().getSelectedItem();

                // Validar si tiene libros
                if (editorialSel.getCanitdadLibrosEditorial() == null || editorialSel.getCanitdadLibrosEditorial() == 0) {
                    Alert msg = new Alert(Alert.AlertType.CONFIRMATION);
                    msg.setTitle("Confirmar eliminación");
                    msg.setHeaderText(null);
                    msg.setContentText("¿Seguro que deseas eliminar esta editorial?\n\nCódigo: "
                            + editorialSel.getIdEditorial()
                            + "\nNombre: " + editorialSel.getNombreEditorial());
                    msg.initOwner(miEscenario);
                    if (msg.showAndWait().get() == ButtonType.OK) {
                        int pos = miTabla.getSelectionModel().getSelectedIndex();
                        if (EditorialControladorEliminar.borrar(pos)) {
                            List<EditorialDto> listaEditoriales = EditorialControladorListar.obtenerEditorail();
                            ObservableList<EditorialDto> datosTabla = FXCollections.observableArrayList(listaEditoriales);
                            miTabla.setItems(datosTabla);
                            miTabla.refresh();
                            Mensaje.mostrar(Alert.AlertType.INFORMATION,
                                    miEscenario, "Éxito", "Editorial eliminada correctamente");
                        } else {
                            Mensaje.mostrar(Alert.AlertType.ERROR,
                                    miEscenario, "Error", "No se pudo eliminar la editorial");
                        }
                    }
                } else {
                    Mensaje.mostrar(Alert.AlertType.ERROR,
                            miEscenario, "Operación no permitida",
                            "No puedes eliminar una editorial con libros asociados");
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
            System.out.println("Actualizar editorial seleccionada");
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
