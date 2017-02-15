import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import javafx.event.*;

public class FontDemo extends Application {
 private Circle circle = new Circle();
 private Label label = new Label("JavaFX");
 private double fontsize = 20;
 private double radius = 50;
 private final double ADJUST = 0.5;
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    
    // Create a pane to hold the circle 
    Pane pane = new StackPane();
    
    // Create a circle and set its properties
   
    circle.setRadius(radius);
    circle.setStroke(Color.BLACK); 
    circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
    pane.getChildren().add(circle); // Add circle to the pane

    // Create a label and set its properties
    
    label.setFont(Font.font("Times New Roman", 
      FontWeight.BOLD, FontPosture.ITALIC, fontsize));
    pane.getChildren().add(label);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("FontDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

scene.widthProperty().addListener(new ChangeListener<Number>() {
    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
        if (newSceneWidth.intValue() > oldSceneWidth.intValue()) // growing
			grow();		
		else  // shrinking
			shrink();
		label.setFont(Font.font("Times New Roman", 
      FontWeight.BOLD, FontPosture.ITALIC, fontsize));
		circle.setRadius(radius);
    }
});

scene.heightProperty().addListener(new ChangeListener<Number>() {
    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
        if (newSceneHeight.intValue() > oldSceneHeight.intValue())// growing
			grow();		
		else  // shrinking
			shrink();		
		label.setFont(Font.font("Times New Roman", 
      FontWeight.BOLD, FontPosture.ITALIC, fontsize));
		circle.setRadius(radius);
    }
});

  } // end of start
  public void grow() {
	 // if (fontsize < 65)
	  	fontsize += ADJUST;
	 // if (radius < 200)
	  	radius += ADJUST;
	 
  }
  public void shrink() {
	  if (fontsize > 1)
	   	fontsize -= ADJUST;
	  if (radius > 1)
		radius -= ADJUST;
		
		
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}