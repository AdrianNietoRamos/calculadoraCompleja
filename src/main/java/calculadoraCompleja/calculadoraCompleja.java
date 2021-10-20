package calculadoraCompleja;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class calculadoraCompleja extends Application {
	private ComboBox<String>operacionCombo;
	private TextField realText;
	private TextField imaginarioText;
	private TextField realText2;
	private TextField imaginarioText2;
	private TextField resultadoText;
	private TextField resultadoText2;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		operacionCombo=new ComboBox<String>();
		operacionCombo.getItems().addAll("+","-","*","/");
		operacionCombo.getSelectionModel().select(0);
		
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

		primaryStage.setTitle("CambioDivisa");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);

	}

}
