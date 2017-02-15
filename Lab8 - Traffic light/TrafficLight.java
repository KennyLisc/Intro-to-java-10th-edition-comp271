/* Gustavo Assis Cardoso
 * Lab 8 - Traffic light - pg 668 # 16.3 
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
	private double paneWidth = 300;
	private double paneHeight = 300;
	
	public void start(Stage pStage) {
		Pane pane = new Pane();
		
		Circle circleRed = new Circle( paneWidth/2, 20, 10);
		Circle circleYellow = new Circle( paneWidth/2, 50, 10);
		Circle circleGreen = new Circle( paneWidth/2, 80, 10);
		
		circleRed.setStroke(Color.BLACK);
		circleYellow.setStroke(Color.BLACK);
		circleGreen.setStroke(Color.BLACK);
		
		circleRed.setFill(Color.RED);
		circleYellow.setFill(Color.WHITE);
		circleGreen.setFill(Color.WHITE);
		
		Rectangle rect = new Rectangle(paneWidth/2 - 15, 5, 30, 90);
		rect.setStroke(Color.BLACK);
		rect.setFill(Color.DARKGOLDENROD);
		
		pane.getChildren().addAll(rect, 
				circleRed, circleYellow, circleGreen);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		
		HBox hBox = new HBox(5);
		hBox.setPadding(new Insets(11,12,13,14));
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border-color:green;");
		
		RadioButton rRed = new RadioButton("RED");
		RadioButton rYellow = new RadioButton("YELLOW");
		RadioButton rGreen = new RadioButton("GREEN");
		
		hBox.getChildren().addAll(rRed,rYellow,rGreen);
		borderPane.setBottom(hBox);
		
		ToggleGroup group = new ToggleGroup();
		rRed.setToggleGroup(group);
		rYellow.setToggleGroup(group);
		rGreen.setToggleGroup(group);
		
		rRed.setOnAction(e -> {
			if(rRed.isSelected()){
				circleRed.setFill(Color.RED);
				circleYellow.setFill(Color.WHITE);
				circleGreen.setFill(Color.WHITE);
			}
		});
		rYellow.setOnAction(e -> {
			if(rYellow.isSelected()){
				circleRed.setFill(Color.WHITE);
				circleYellow.setFill(Color.YELLOW);
				circleGreen.setFill(Color.WHITE);
			}
		});
		rGreen.setOnAction(e -> {
			if(rGreen.isSelected()){
				circleRed.setFill(Color.WHITE);
				circleYellow.setFill(Color.WHITE);
				circleGreen.setFill(Color.GREEN);
			}
		});
		
		Scene scene = new Scene(borderPane, paneWidth + 5, paneHeight + 75);
		pStage.setTitle("Traffic Light");
		pStage.setScene(scene);
		pStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
