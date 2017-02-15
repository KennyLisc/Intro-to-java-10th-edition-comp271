import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Temp extends Application {
//convert cal to fah
	TextField txtFah = new TextField();
	Slider celtofah = new Slider(-10, 65, 20);
	Label lblFah = new Label("Fah");
	Label lblCel = new Label("Cel");
	RadioButton btnfah = new RadioButton("fah to cel");
	RadioButton btncel = new RadioButton("cel to fah");
	
	public void start(Stage pStage) {
		
		ToggleGroup group = new ToggleGroup();
		btnfah.setToggleGroup(group);
		btncel.setToggleGroup(group);
		btncel.setSelected(true);
		
		HBox choices = new HBox(5);
		choices.setAlignment(Pos.CENTER);
		choices.getChildren().addAll(btncel, btnfah);
		
		HBox fahHBox = new HBox(5);
		fahHBox.setAlignment(Pos.CENTER);
		fahHBox.getChildren().addAll(lblFah, txtFah);
		txtFah.setEditable(false);
		
		VBox celVBox = new VBox(10);
		celtofah.setShowTickLabels(true);
		celtofah.setShowTickMarks(true);
		celVBox.getChildren().addAll(lblCel, celtofah);
		
		BorderPane pane = new BorderPane();
		pane.setTop(choices);
		pane.setCenter(fahHBox);
		pane.setBottom(celVBox);
		
		Scene scene = new Scene(pane, 450, 100);
		pStage.setTitle("Temp conversion");
		pStage.setScene(scene);
		pStage.show();
		
		btncel.setOnAction(e -> {
			lblFah.setText("Fah");
			lblCel.setText("Cel");
			celtofah.setMin(-10);
			celtofah.setMax(65);
			celtofah.adjustValue(0); // 32 degrees
		});
		
		btnfah.setOnAction(e -> {
			lblFah.setText("Cel");
			lblCel.setText("Fah");
			celtofah.setMin(15);
			celtofah.setMax(150);
			celtofah.adjustValue(32); // 0 degree
		});
		
		celtofah.valueProperty().addListener(event -> {
			if (btncel.isSelected()) {
			double cel = celtofah.getValue();
			double fah = cel * (9/5.0) + 32;
			String ans = String.format("%.1fF", fah);
			txtFah.setText(ans);
			}
			else {
				double fah = celtofah.getValue();
				double cel = (fah - 32) * (5/9.0);
				String ans = String.format("%.1fC", fah);
				txtFah.setText(ans);
			}
		});
		
		btnfah.fire(); // launch with some value in the button
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
