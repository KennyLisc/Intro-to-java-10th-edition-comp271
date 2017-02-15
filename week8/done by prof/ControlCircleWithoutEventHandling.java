import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithoutEventHandling extends Application {
	private CirclePane cp = new CirclePane();
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    
    pane.getChildren().add(cp);
    
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btEnlarge = new Button("Enlarge");
    
    Button btShrink = new Button("Shrink");
    hBox.getChildren().add(btEnlarge);
    hBox.getChildren().add(btShrink);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    btEnlarge.setOnAction(e -> {		
		cp.enlarge();	
});
    btShrink.setOnAction(e -> {		
		cp.shrink();	
});
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 150);
    primaryStage.setTitle("ControlCircle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
class CirclePane extends StackPane {
	private Circle mycircle = new Circle(50);

	public CirclePane() {
		getChildren().add(mycircle);
		mycircle.setStroke(Color.BLACK);
		mycircle.setFill(Color.BLUE);
	}
	
	public void enlarge() {
		mycircle.setRadius( mycircle.getRadius() + 2);
	}
	public void shrink() {
		if (mycircle.getRadius() > 3)
			mycircle.setRadius( mycircle.getRadius() - 2);
	}
}
