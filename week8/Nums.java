// A simple user interface used to add two numbers
// No error checking is done!!!!

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;

public class Nums extends Application
  
{
	TextField tfNumber1, tfNumber2, tfResult;
	
	public void start(Stage primaryStage) 
	{
		// Set up an area to work on
		
	FlowPane pane = new FlowPane();
    pane.setHgap(2);

	// Create some text fields for user input
     tfNumber1 = new TextField();
     tfNumber2 = new TextField();
     tfResult = new TextField();
    tfNumber1.setPrefColumnCount(3);
    tfNumber2.setPrefColumnCount(3);
    tfResult.setPrefColumnCount(3);
	tfResult.setEditable(false); // So the user can not type the answer
    
    pane.getChildren().addAll(new Label("Number 1: "), tfNumber1,
      new Label("Number 2: "), tfNumber2, new Label("Result: "), tfResult);
    
    // Create four buttons
    HBox hBox = new HBox(5);
    Button btAdd = new Button("Add");
    Button btSubtract = new Button("Subtract");
    Button btMultiply = new Button("Multiply");
    Button btDivide = new Button("Divide");
    
    // create classes
    AddListener add_it = new AddListener();
    // register the button to an event
    btAdd.setOnAction(add_it);
    
    // Subtract as a Lambda expression
  /*  btSubtract.setOnAction(e -> {		
    	;
	
});
       */ 
    
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 350, 150);
    primaryStage.setTitle("Calculate"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
		
	}

	public static void main( String args[])
	{
		launch(args);
	}	
	
	
	class AddListener implements EventHandler<ActionEvent> {
		  public void handle(ActionEvent e) {
			  // add the two numbers
			  
			  String strnum1 = tfNumber1.getText();
			  double num1 = Double.parseDouble(strnum1);
			  String strnum2 = tfNumber2.getText();
			  double num2 = Double.parseDouble(strnum2);
			  double answer = num1 + num2;
			  tfResult.setText(""+ answer);
	
			}
	}
}