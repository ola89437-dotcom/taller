package org.uni.vista.editorial;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import org.uni.controlador.EditorialControladorListar;
import org.uni.dto.EditorialDto;
import org.uni.recurso.constante.Configuracion;
import org.uni.recurso.utilidad.Marco;

public class VistaEditorialListar extends StackPane {

    private final Rectangle marco;
    private final Stage miEscenario;
    private final VBox cajaVertical;
    private final TableView<EditorialDto> miTabla;

    private static final String ESTILO_CENTRAR
            = "-fx-alignment: CENTER;";
    private static final String ESTILO_DERECHA
            = "-fx-alignment: CENTER-RIGHT;";
    private static final String ESTILO_IZQUIERDA
            = "-fx-alignment: CENTER-LEFT;";
    private static final String ESTILO_ROJO
            = "-fx-text-fill: red; " + ESTILO_CENTRAR;
    private static final String ESTILO_VERDE
            = "-fx-text-fill: green; " + ESTILO_CENTRAR;

    public VistaEditorialListar(
            Stage ventanaPadre, double ancho, double alto
    ) {
        setAlignment(Pos.CENTER);
        miEscenario = ventanaPadre;
        marco = Marco.crear(
                miEscenario,
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
    }

    private void configurarCajaVertical() {
        cajaVertical.setAlignment(Pos.TOP_CENTER);
        cajaVertical.prefWidthProperty()
                .bind(miEscenario.widthProperty());
        cajaVertical.prefHeightProperty()
                .bind(miEscenario.heightProperty());
    }

    private void crearTitulo() {
        Region bloqueSeparador = new Region();
        bloqueSeparador.prefHeightProperty().bind(
                miEscenario.heightProperty().multiply(0.05));
        
        // Obtener la cantidad de editoriales para mostrar en el título
        List<EditorialDto> arrEditoriales = EditorialControladorListar.obtenerEditorail();
        int cantidadEditoriales = arrEditoriales != null ? arrEditoriales.size() : 0;
        
        Text titulo = new Text("★ Lista de Editoriales ━━ (" + cantidadEditoriales + ")");
        titulo.setFill(Color.web("#de3d37"));
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, 24));

        cajaVertical.getChildren().addAll(bloqueSeparador, titulo);
    }

    private TableColumn<EditorialDto, Integer> crearColumnaCodigo() {
        TableColumn<EditorialDto, Integer> columna = new TableColumn<>("Código");
        columna.setCellValueFactory(new PropertyValueFactory<>("idEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.15));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, String> crearColumnaNombre() {
        TableColumn<EditorialDto, String> columna = new TableColumn<>("Nombre");
        columna.setCellValueFactory(new PropertyValueFactory<>("nombreEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.25));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, String> crearColumnaPais() {
        TableColumn<EditorialDto, String> columna = new TableColumn<>("País");
        columna.setCellValueFactory(new PropertyValueFactory<>("paisEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.20));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, Short> crearColumnaFormato() {
        TableColumn<EditorialDto, Short> columna = new TableColumn<>("Formato");
        columna.setCellValueFactory(new PropertyValueFactory<>("formatoEditorial"));
        columna.setCellFactory(col -> new TableCell<EditorialDto, Short>() {
            @Override
            protected void updateItem(Short item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    switch (item) {
                        case 1:
                            setText("Impreso");
                            break;
                        case 2:
                            setText("Digital");
                            break;
                        case 3:
                            setText("Impreso y Digital");
                            break;
                        default:
                            setText("Desconocido");
                            break;
                    }
                }
            }
        });
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.20));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private TableColumn<EditorialDto, Short> crearColumnaCantidadLibros() {
        TableColumn<EditorialDto, Short> columna = new TableColumn<>("Cantidad de Libros");
        columna.setCellValueFactory(new PropertyValueFactory<>("canitdadLibrosEditorial"));
        columna.prefWidthProperty().bind(miTabla.widthProperty().multiply(0.20));
        columna.setStyle(ESTILO_CENTRAR);
        return columna;
    }

    private void configurarColumnas() {
        miTabla.getColumns().addAll(List.of(
                crearColumnaCodigo(),
                crearColumnaNombre(),
                crearColumnaPais(),
                crearColumnaFormato(),
                crearColumnaCantidadLibros()
        ));
    }

    private void crearTabla() {
        configurarColumnas();

        List<EditorialDto> arrEditoriales = EditorialControladorListar.obtenerEditorail();
        ObservableList<EditorialDto> datosTabla = FXCollections.observableArrayList(arrEditoriales);

        miTabla.setItems(datosTabla);
        miTabla.setPlaceholder(new Text("No hay editoriales registradas."));

        // Evita scroll horizontal
        miTabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        // Responsividad
        miTabla.maxWidthProperty().bind(miEscenario.widthProperty().multiply(0.60));
        miTabla.maxHeightProperty().bind(miEscenario.heightProperty().multiply(0.50));

        miEscenario.heightProperty().addListener((o, oldVal, newVal)
                -> miTabla.setPrefHeight(newVal.doubleValue())
        );

        VBox.setVgrow(miTabla, Priority.ALWAYS);

        cajaVertical.getChildren().add(miTabla);
        getChildren().add(cajaVertical);
    }
}

