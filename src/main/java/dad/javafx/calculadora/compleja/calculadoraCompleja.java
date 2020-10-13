package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class calculadoraCompleja extends Application {

    private ComboBox<String> cbOperadores;
    private TextField tfNumeradorA;
    private TextField tfNumeradorB;
    private TextField tfDenominadorA;
    private TextField tfDenominadorB;
    private TextField tfResA;
    private TextField tfResB;

    private String[] operadores = { "+", "-", "*", "/" } ;

    public void start(Stage primaryStage) throws Exception {
        cbOperadores = new ComboBox<String>();
        cbOperadores.getItems().addAll(operadores);
        cbOperadores.getSelectionModel().selectFirst();

        VBox vbOperaciones = new VBox();
        vbOperaciones.getChildren().add(cbOperadores);
        vbOperaciones.setAlignment(Pos.CENTER);

        tfNumeradorA = new TextField("0");
        tfNumeradorA.setPrefColumnCount(2);
        tfNumeradorA.setMaxWidth(100);
        tfNumeradorA.setAlignment(Pos.CENTER);

        tfNumeradorB = new TextField("0");
        tfNumeradorB.setPrefColumnCount(2);
        tfNumeradorB.setMaxWidth(100);
        tfNumeradorB.setAlignment(Pos.CENTER);
}}