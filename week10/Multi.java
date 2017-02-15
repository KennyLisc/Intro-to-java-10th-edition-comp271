// Copy items from one List to a TextArea

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.paint.*;

public class Multi extends Application
  implements  EventHandler<ActionEvent>
{
	private TextArea copyArea ;
	
	private Button copyit;
	private ObservableList<String> colornames = 
		FXCollections.observableArrayList( "Black", "Blue", "Dark Gray", "Gray", 
			"Green", "Orange", "Pink", "Red", "White");
	private ListView<String> colorList; 

	public void start(Stage primaryStage) 
	{
		// Set up an area to work on
		FlowPane pane = new FlowPane(); // One component after another from left to right

		// Now create some items to display to the user		
		colorList = new ListView<>(colornames);
		colorList.setPrefSize(120,100);
		
		colorList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		pane.getChildren().add( colorList );

		copyit = new Button(">");
		pane.getChildren().add(copyit);
	
	    // Subscribe for when the user clicks this
		copyit.setOnAction(this);

		copyArea = new TextArea();
		copyArea.setPrefColumnCount(20);
		copyArea.setPrefRowCount(5);
		copyArea.setEditable(false);
		pane.getChildren().add( new ScrollPane (copyArea) ); // place a scroll pane around the textarea

	Scene scene = new Scene(pane, 400, 300);
	primaryStage.setTitle("List Example");
	primaryStage.setScene( scene );
	primaryStage.show();
		
		
	}

	// Listen for when the user presses the button	
	
	public void handle(ActionEvent e)
	{
		
		if (e.getSource() == copyit)
		{	
			// clear out the old selection
			copyArea.clear(); // or copyArea.setText("");

			// Get the list of selected items			
			ObservableList<String> selections = colorList.getSelectionModel().getSelectedItems();
			Object[] selected = selections.toArray(); // convert the list to an array
			for (int k = 0; k < selected.length ; k++)
			{
				copyArea.setText(copyArea.getText() + "\n" + selected[k].toString());
			}
		}
	}
	
	public static void main( String args[])
	{
		launch(args);
	}	
}