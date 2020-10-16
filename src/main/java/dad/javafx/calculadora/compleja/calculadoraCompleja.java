package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class calculadoraCompleja extends Application {
	
	private ComboBox<String> cbOperar;
	private TextField tfNumeroA;
	private TextField tfNumeroB;
	private TextField tfDenominadoresA;
	private TextField tfDenominadoresB;
	private TextField tfResultA;
	private TextField tfResultB;
	
	private Complejo complejoA;
	private Complejo complejoB;
	private Complejo result;
	
	private String[] _operador = {"+", "-", "*", "/"};
	
	private void onCambiarAction(ActionEvent e) {
		String operacion = cbOperar.getSelectionModel().getSelectedItem();
		switch (operacion) {
			case "+":
				result.realProperty().bind(complejoA.realProperty().add(complejoB.realProperty()));
				result.imaginarioProperty().bind(complejoA.imaginarioProperty().add(complejoB.imaginarioProperty()));
			break;
			case "-":
				result.realProperty().bind(complejoA.realProperty().subtract(complejoB.realProperty()));
				result.imaginarioProperty().bind(complejoA.imaginarioProperty().subtract(complejoB.imaginarioProperty()));
			break;
			case "*":
				result.realProperty().bind(
						complejoA.realProperty().multiply(complejoB.realProperty())
						.subtract(
						complejoA.imaginarioProperty().multiply(complejoB.imaginarioProperty()))
						);
				result.imaginarioProperty().bind(
						complejoA.realProperty().multiply(complejoB.imaginarioProperty())
						.add(
						complejoA.imaginarioProperty().multiply(complejoB.realProperty()))
						);
			break;
			case "/":
				result.realProperty().bind(
						(complejoA.realProperty().multiply(complejoB.realProperty()).add(complejoA.imaginarioProperty().multiply(complejoB.imaginarioProperty())))
						.divide(
						(complejoB.realProperty().multiply(complejoB.realProperty())
								.add(complejoB.imaginarioProperty().multiply(complejoB.imaginarioProperty()))))
				);
				
				result.imaginarioProperty().bind(
						(complejoA.imaginarioProperty().multiply(complejoB.realProperty()).subtract(complejoA.realProperty().multiply(complejoB.imaginarioProperty())))
						.divide(
						(complejoB.realProperty().multiply(complejoB.realProperty())
								.add(complejoB.imaginarioProperty().multiply(complejoB.imaginarioProperty()))))
				);
			break;
		}
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Selector de operación
		
		cbOperar = new ComboBox<String>();
		cbOperar.getItems().addAll(_operador);
		cbOperar.getSelectionModel().selectFirst();
		cbOperar.setOnAction(e -> onCambiarAction(e));
		
		VBox vbOperacion = new VBox();
		vbOperacion.getChildren().add(cbOperar);
		vbOperacion.setAlignment(Pos.CENTER);
		
		// Campos para números complejos
		
		// Primer número
		
		tfNumeroA = new TextField("0");
		tfNumeroA.setPrefColumnCount(4);
		tfNumeroA.setMaxWidth(100);
		tfNumeroA.setAlignment(Pos.CENTER);
		
		tfNumeroB = new TextField("0");
		tfNumeroB.setPrefColumnCount(4);
		tfNumeroB.setMaxWidth(100);
		tfNumeroB.setAlignment(Pos.CENTER);
		
		HBox hbNumerador = new HBox();
		hbNumerador.setSpacing(5);
		hbNumerador.getChildren().addAll(tfNumeroA, new Label("+"), tfNumeroB, new Label("i"));
		
		complejoA = new Complejo();
		
		Bindings.bindBidirectional(tfNumeroA.textProperty(), complejoA.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfNumeroB.textProperty(), complejoA.imaginarioProperty(), new NumberStringConverter());
		
		// Segundo número
		
		tfDenominadoresA = new TextField("0");
		tfDenominadoresA.setPrefColumnCount(4);
		tfDenominadoresA.setMaxWidth(100);
		tfDenominadoresA.setAlignment(Pos.CENTER);
		
		tfDenominadoresB = new TextField("0");
		tfDenominadoresB.setPrefColumnCount(4);
		tfDenominadoresB.setMaxWidth(100);
		tfDenominadoresB.setAlignment(Pos.CENTER);
		
		HBox hbDenominador = new HBox();
		hbDenominador.setSpacing(5);
		hbDenominador.getChildren().addAll(tfDenominadoresA, new Label("+"), tfDenominadoresB, new Label("i"));
		
		complejoB = new Complejo();
		
		Bindings.bindBidirectional(tfDenominadoresA.textProperty(), complejoB.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfDenominadoresB.textProperty(), complejoB.imaginarioProperty(), new NumberStringConverter());
		
		// Número resultante
		
		tfResultA = new TextField("0");
		tfResultA.setPrefColumnCount(4);
		tfResultA.setMaxWidth(100);
		tfResultA.setAlignment(Pos.CENTER);
		tfResultA.setDisable(true);
		
		tfResultB = new TextField("0");
		tfResultB.setPrefColumnCount(4);
		tfResultB.setMaxWidth(100);
		tfResultB.setAlignment(Pos.CENTER);
		tfResultB.setDisable(true);
		
		result = new Complejo();
		
		Bindings.bindBidirectional(tfResultA.textProperty(), result.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(tfResultB.textProperty(), result.imaginarioProperty(), new NumberStringConverter());
		
		HBox hbResultado = new HBox();
		hbResultado.setSpacing(5);
		hbResultado.getChildren().addAll(tfResultA, new Label("+"), tfResultB, new Label("i"));
		
		VBox vbNumeros = new VBox();
		vbNumeros.setAlignment(Pos.CENTER);
		vbNumeros.getChildren().addAll(hbNumerador, hbDenominador, new Separator(), hbResultado);
		
		// Root
		
		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(vbOperacion, vbNumeros);
		
		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}