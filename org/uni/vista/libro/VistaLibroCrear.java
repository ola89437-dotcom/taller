package org.uni.vista.libro;

import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.uni.controlador.AutorControladorLista;
import org.uni.controlador.EditorialControladorListar;
import org.uni.controlador.LibroControladorGrabar;
import org.uni.dto.AutorDto;
import org.uni.dto.EditorialDto;
import org.uni.dto.LibroDto;
import org.uni.recurso.constante.Configuracion;
import org.uni.recurso.utilidad.Marco;
import org.uni.recurso.utilidad.Mensaje;


public class VistaLibroCrear extends StackPane {

    private static final int H_GAP = 10;
    private static final int V_GAP = 20;
    private static final int ALTO_FILA = 40;
    private static final int ANCHO_FILA = 35;
    private static final int TAMANIO_FUENTE = 20;
    private static final int ALTO_CAJA = 35;
    private static final double ANCHO = 0.8;

    private static final double AJUSTE_TITULO = 0.1;

    private final GridPane miGrilla;
    private final Rectangle miMarco;

    private TextField txtNombreLibro;
    private TextField txtPrecioLibro;
    private TextField txtAnioLibro;
    private ComboBox<EditorialDto> cbmEditorialPelicula;
    private ComboBox<AutorDto> cbmAutorPelicula;

    public VistaLibroCrear(Stage esce, double ancho, double alto) {
        setAlignment(Pos.CENTER);
        miGrilla = new GridPane();
        miMarco = Marco.crear(esce, Configuracion.MARCO_ANCHO_PORCENTAJE, Configuracion.MARCO_ALTO_PORCENTAJE,
                Configuracion.DEGRADE_ARREGLO, Configuracion.DEGRADDE_BORDE);
        getChildren().add(miMarco);
        configurarMiGrilla(ancho, alto);
        crearTitulo();
        crearFormulario();

        colocarFrmElegante();
        getChildren().add(miGrilla);

    }

    private void configurarMiGrilla(double ancho, double alto) {
        miGrilla.setAlignment(Pos.TOP_CENTER);
        miGrilla.prefWidthProperty().bind(miMarco.widthProperty().multiply(0.9));
        miGrilla.prefHeightProperty().bind(miMarco.heightProperty().multiply(0.8));
        miGrilla.setHgap(H_GAP);
        miGrilla.setVgap(V_GAP);
        miGrilla.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();

        col0.setPrefWidth(250);
        col1.setPrefWidth(400);
        col1.setHgrow(Priority.ALWAYS);

        miGrilla.getColumnConstraints().addAll(col0, col1);

        for (int i = 0; i < 9; i++) {
            RowConstraints fila = new RowConstraints();
            fila.setMinHeight(ALTO_FILA);
            fila.setMaxHeight(ALTO_FILA);
            miGrilla.getRowConstraints().add(fila);

        }
    }

    private void crearTitulo() {
        Text miTitulo = new Text("Formulario crear Libro");
        miTitulo.setFill(Color.web("#000000"));
        miTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
        GridPane.setHalignment(miTitulo, HPos.CENTER);
        GridPane.setMargin(miTitulo, new Insets(30, 0, 0, 0));
        // columna, fila, colSpan,RowSpan
        miGrilla.add(miTitulo, 0, 0, 2, 1);

    }

    private void crearFormulario() {
        Label lblNombre = new Label("Nombre libro:");
        lblNombre.setFont(Font.font("Arial", FontPosture.ITALIC,
                TAMANIO_FUENTE));
        miGrilla.add(lblNombre, 0, 2);

        txtNombreLibro = new TextField();
        txtNombreLibro.setPromptText("Digita el libro");
        GridPane.setHgrow(txtNombreLibro, Priority.ALWAYS);
        txtNombreLibro.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtNombreLibro, 1, 2);

        Label lblPrecioLibro = new Label("Presupuesto:");
        lblPrecioLibro.setFont(Font.font("Arial", FontPosture.ITALIC,
                TAMANIO_FUENTE));
        miGrilla.add(lblPrecioLibro, 0, 3);

        txtPrecioLibro = new TextField();
        txtPrecioLibro.setPromptText("Digita el precio");
        GridPane.setHgrow(txtPrecioLibro, Priority.ALWAYS);
        txtPrecioLibro.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtPrecioLibro, 1, 3);

        Label lblAnioLibro = new Label("Año del libro:");
        lblAnioLibro.setFont(Font.font("Arial", FontPosture.ITALIC,
                TAMANIO_FUENTE));
        miGrilla.add(lblAnioLibro, 0, 4);

        txtAnioLibro = new TextField();
        txtAnioLibro.setPromptText("Digita el año");
        GridPane.setHgrow(txtAnioLibro, Priority.ALWAYS);
        txtAnioLibro.setPrefHeight(ALTO_CAJA);
        miGrilla.add(txtAnioLibro, 1, 4);

        Label lblEditorial = new Label("Editorial:");
        lblEditorial.setFont(Font.font("Arial", FontPosture.ITALIC,
                TAMANIO_FUENTE));
        miGrilla.add(lblEditorial, 0, 5);

        cbmEditorialPelicula = new ComboBox<>();
        cbmEditorialPelicula.setMaxWidth(Double.MAX_VALUE);
        cbmEditorialPelicula.setPrefHeight(ALTO_CAJA);
        cbmEditorialPelicula.setPromptText("Selecciona una editorial");

        List<EditorialDto> arrEditoriales = EditorialControladorListar.obtenerEditorail();
        EditorialDto opcionInicialEditorial = new EditorialDto();
        opcionInicialEditorial.setIdEditorial(0);
        opcionInicialEditorial.setNombreEditorial("Seleccione editorial");
        arrEditoriales.add(0, opcionInicialEditorial);

        ObservableList<EditorialDto> itemsEditoriales = FXCollections.observableArrayList(arrEditoriales);
        cbmEditorialPelicula.setItems(itemsEditoriales);
        cbmEditorialPelicula.getSelectionModel().select(0);
        miGrilla.add(cbmEditorialPelicula, 1, 5);

        Label lblAutor = new Label("Autor:");
        lblAutor.setFont(Font.font("Arial", FontPosture.ITALIC,
                TAMANIO_FUENTE));
        miGrilla.add(lblAutor, 0, 6);

        List<AutorDto> arrAutores = AutorControladorLista.obtenerAutores();
        AutorDto opcionInicialAutor = new AutorDto();
        opcionInicialAutor.setIdAutor(0);
        opcionInicialAutor.setNombreAutor("Seleccione autor");
        arrAutores.add(0, opcionInicialAutor);

        cbmAutorPelicula = new ComboBox<>();
        cbmAutorPelicula.setMaxWidth(Double.MAX_VALUE);
        cbmAutorPelicula.setPrefHeight(ALTO_CAJA);
        cbmAutorPelicula.setPromptText("Selecciona un autor");

        ObservableList<AutorDto> itemsAutores
                = FXCollections.observableArrayList(arrAutores);
        cbmAutorPelicula.setItems(itemsAutores);
        cbmAutorPelicula.getSelectionModel().select(0);
        miGrilla.add(cbmAutorPelicula, 1, 6);

        Button btnGrabar = new Button("Grabar Libro");
        btnGrabar.setTextFill(Color.RED);
        btnGrabar.setMaxWidth(Double.MAX_VALUE);
        btnGrabar.setFont(Font.font("Verdana", TAMANIO_FUENTE));
        btnGrabar.setOnAction((e) -> {
            guardarElLibro();
        });

        miGrilla.add(btnGrabar, 1, 7);

    }

    private EditorialDto obtenerEditorial() {
        EditorialDto seleccionado = cbmEditorialPelicula.
                getSelectionModel().getSelectedItem();
        if (seleccionado != null && seleccionado.getIdEditorial() != 0) {
            return seleccionado;
        }
        return null;
    }

    private AutorDto obtenerAutor() {
        AutorDto seleccionado = cbmAutorPelicula.
                getSelectionModel().getSelectedItem();
        if (seleccionado != null && seleccionado.getIdAutor() != 0) {
            return seleccionado;
        }
        return null;
    }

    private void limpiarFormulario() {
        txtNombreLibro.setText("");
        txtPrecioLibro.setText("");
        txtAnioLibro.setText("");
        if (cbmEditorialPelicula != null) {
            cbmEditorialPelicula.getSelectionModel().select(0);
        }
        if (cbmAutorPelicula != null) {
            cbmAutorPelicula.getSelectionModel().select(0);
        }
        txtNombreLibro.requestFocus();
    }

    private Boolean formularioCompleto() {
        if (txtNombreLibro.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "Por favor ingresa el nombre del libro");
            txtNombreLibro.requestFocus();
            return false;
        }

        if (txtPrecioLibro.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "Por favor ingresa el precio del libro");
            txtPrecioLibro.requestFocus();
            return false;
        }
        try {
            Double.valueOf(txtPrecioLibro.getText().trim());
        } catch (NumberFormatException ex) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "El precio debe ser numérico (usa punto como separador decimal)");
            txtPrecioLibro.requestFocus();
            return false;
        }

        if (txtAnioLibro.getText().isBlank()) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "Por favor ingresa el año del libro");
            txtAnioLibro.requestFocus();
            return false;
        }
        try {
            Short.valueOf(txtAnioLibro.getText().trim());
        } catch (NumberFormatException ex) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "El año debe ser un número entero válido");
            txtAnioLibro.requestFocus();
            return false;
        }

        if (cbmEditorialPelicula.getSelectionModel().getSelectedIndex() <= 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "Por favor selecciona una editorial");
            cbmEditorialPelicula.requestFocus();
            return false;
        }

        if (cbmAutorPelicula.getSelectionModel().getSelectedIndex() <= 0) {
            Mensaje.mostrar(Alert.AlertType.WARNING, this.getScene().getWindow(),
                    "Validación", "Por favor selecciona un autor");
            cbmAutorPelicula.requestFocus();
            return false;
        }

        return true;
    }

    private void guardarElLibro() {
        if (formularioCompleto()) {
            LibroDto dto = new LibroDto();
            dto.setNombreLibro(txtNombreLibro.getText());
            dto.setPrecioLibro(Double.valueOf(txtPrecioLibro.getText()));
            dto.setAnioLibro(Short.valueOf(txtAnioLibro.getText()));
            dto.setIdEditorial(obtenerEditorial());
            dto.setIdAutor(obtenerAutor());

            if (LibroControladorGrabar.crearLibro(dto)) {
                Mensaje.mostrar(Alert.AlertType.INFORMATION, null,
                        "Exito", "Dios mio sirve");
                txtNombreLibro.requestFocus();

            } else {
                Mensaje.mostrar(Alert.AlertType.ERROR, null,
                        "Error", "Esto no sirve");
                txtNombreLibro.requestFocus();

            }
            limpiarFormulario();

        }
    }

    private void colocarFrmElegante() {
        StackPane.setAlignment(miGrilla, Pos.CENTER);

        miGrilla.prefWidthProperty().bind(miMarco.widthProperty().multiply(0.85));
        miGrilla.prefHeightProperty().bind(miMarco.heightProperty().multiply(0.75));

        miGrilla.translateYProperty().bind(miMarco.heightProperty().multiply(-0.02));

    }
}
