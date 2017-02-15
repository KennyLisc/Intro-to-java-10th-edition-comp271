import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.beans.value.*;
import javafx.scene.paint.*;

// Using a slider, convert cel to fah 

public class celtofah extends Application {

	Text display_text;
		
	public void start(Stage primaryStage) 
	{
		display_text = new Text(20, 20, "Cel to Fah");
				
		Slider slide = new Slider(-20, 60, 10);
		slide.setShowTickLabels(true);
		slide.setShowTickMarks(true);
		slide.setMajorTickUnit(10);
		slide.setMinorTickCount(5);

		//Create a pane
		Pane paneForText = new Pane();
		paneForText.getChildren().add(display_text);

		//Create a border
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(slide);

		slide.valueProperty().addListener( new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
				double cel = slide.getValue();
				double fah = 9.0/5 * cel + 32;
				Color paneColor;
				if (fah < 40)
				{
					paneColor = Color.BLUE;
				}
				else if (fah > 90)
				{
					paneColor = Color.RED;
				}
				else
					paneColor = Color.BLACK;

				display_text.setFill( paneColor );
				display_text.setText( String.format("Cel %.1fC is %.1fF fah",cel,fah));
			}
		});
			


		Scene scene = new Scene(pane, 550, 170);
		primaryStage.setTitle("Cel to Fah");
		primaryStage.setScene( scene );
		primaryStage.show();
	
			
	
}


	public static void main( String args[])
	{
		launch(args);
	}

}