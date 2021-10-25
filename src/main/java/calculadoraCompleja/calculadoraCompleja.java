package calculadoraCompleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
	private ComboBox<String>operacionCombo;
	private TextField realText;
	private TextField imaginarioText;
	private TextField realText2;
	private TextField imaginarioText2;
	private TextField resultadoText;
	private TextField resultadoText2;
	Complejo complejo=new Complejo();
	Complejo complejo2=new Complejo();
	Complejo complejoRes=new Complejo();

	@Override
	public void start(Stage primaryStage) throws Exception {
		operacionCombo=new ComboBox<String>();
		operacionCombo.getItems().addAll("+","-","*","/");

		
		realText=new TextField();
		realText.setPrefWidth(75);
		realText.setAlignment(Pos.CENTER);
		
		
		
		
		imaginarioText=new TextField();
		imaginarioText.setPrefWidth(75);
		imaginarioText.setAlignment(Pos.CENTER);
		
		
		realText2=new TextField();
		realText2.setPrefWidth(75);
		realText2.setAlignment(Pos.CENTER);
		
		imaginarioText2=new TextField();
		imaginarioText2.setPrefWidth(75);
		imaginarioText2.setAlignment(Pos.CENTER);
		
		
		Separator separator=new Separator();
		resultadoText=new TextField();
		resultadoText.setPrefWidth(75);
		resultadoText.setAlignment(Pos.CENTER);
		resultadoText2=new TextField();
		resultadoText2.setPrefWidth(75);
		resultadoText2.setAlignment(Pos.CENTER);
		
		
		
		
		VBox comboboxBox=new VBox(5,operacionCombo);
		comboboxBox.setAlignment(Pos.CENTER);
		
		HBox operacionBox=new HBox(5,realText,new Label("+"),imaginarioText,new Label("i"));
		operacionBox.setAlignment(Pos.CENTER);
	
		HBox operacionBox2=new HBox(5,realText2,new Label("+"),imaginarioText2,new Label("i"));
		operacionBox2.setAlignment(Pos.CENTER);
		
		HBox resultadoBox=new HBox(5,resultadoText,new Label("+"),resultadoText2,new Label("i"));
		operacionBox2.setAlignment(Pos.CENTER);
	

		VBox calculadoraBox=new VBox(operacionBox,operacionBox2,separator,resultadoBox);
		calculadoraBox.setSpacing(5);
		calculadoraBox.setAlignment(Pos.CENTER);
		comboboxBox.setAlignment(Pos.CENTER);
		HBox root=new HBox(5,comboboxBox,calculadoraBox);
		root.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(root, 480, 320);

		primaryStage.setTitle("Calculadora compleja");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Bindings.bindBidirectional(realText.textProperty(), complejo.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(imaginarioText.textProperty(), complejo.imaginarioProperty(), new NumberStringConverter());
		
		
		Bindings.bindBidirectional(realText2.textProperty(), complejo2.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(imaginarioText2.textProperty(), complejo2.imaginarioProperty(), new NumberStringConverter());

		operacionCombo.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
			if (operacionCombo.getSelectionModel().getSelectedItem().equals("+")) {
				complejoRes = complejo.sumar(complejo2);
				resultadoText.textProperty().bind(complejoRes.realProperty().asString("%.2f"));
				resultadoText2.textProperty().bind(complejoRes.imaginarioProperty().asString("%.2f"));
			}
			if (operacionCombo.getSelectionModel().getSelectedItem().equals("-")) {
				complejoRes = complejo.restar(complejo2);
				resultadoText.textProperty().bind(complejoRes.realProperty().asString("%.2f"));
				resultadoText2.textProperty().bind(complejoRes.imaginarioProperty().asString("%.2f"));
			}	
			if (operacionCombo.getSelectionModel().getSelectedItem().equals("*")) {
				complejoRes = complejo.multiplicar(complejo2);
				resultadoText.textProperty().bind(complejoRes.realProperty().asString("%.2f"));
				resultadoText2.textProperty().bind(complejoRes.imaginarioProperty().asString("%.2f"));
			}	
			if (operacionCombo.getSelectionModel().getSelectedItem().equals("/")) {
				complejoRes = complejo.dividir(complejo2);
				resultadoText.textProperty().bind(complejoRes.realProperty().asString("%.2f"));
				resultadoText2.textProperty().bind(complejoRes.imaginarioProperty().asString("%.2f"));
			}
		});

	}

	public static void main(String[] args) {
		launch(args);

	}

}
