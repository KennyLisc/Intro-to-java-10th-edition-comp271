
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

// User interface to allow a user to place an order for IceCream
// Only three flavors are being offered - Vanilla, Chocolate, and Strawberry
// Three toppings are being offered - Whipped Cream, Cherry, and M&Ms
// Need to add event handling to display the user's selections (ice cream and toppings) in the order TextField

public class IceCream extends Application {

	private RadioButton vanilla, choc, straw;
	private TextField order;
	private Label tops, flavors;
	private CheckBox whip, cherry, mms;
	
	private String icecream_picked = "Vanilla";
	private String toppings = " ";
	
	public void start(Stage primaryStage) {
	
			BorderPane pane = new BorderPane();
			HBox fpane = new HBox(10); // for flavors
			HBox tpane = new HBox(10); // for toppings
			
			order = new TextField(icecream_picked);
			order.setEditable(false);
			
			// do the flavors
			flavors = new Label("Flavors");
			vanilla = new RadioButton("Vanilla");
			choc = new RadioButton("Chocolate");
			straw = new RadioButton("Strawberry");
			
			ToggleGroup flavorsgroup = new ToggleGroup();
			vanilla.setToggleGroup(flavorsgroup);
			choc.setToggleGroup(flavorsgroup);
			straw.setToggleGroup(flavorsgroup);
			vanilla.setSelected(true);
			
			
			
			// do the toppings
			tops = new Label("Toppings");
			whip = new CheckBox("Whipped Cream");
			cherry = new CheckBox("Cherry");
			mms = new CheckBox("M&Ms");
			
			
			
			// place stuff on screen
			fpane.getChildren().addAll(flavors, vanilla, choc, straw);
			
			tpane.getChildren().addAll(tops, whip, cherry, mms);
			
			pane.setTop(fpane); // radio buttons for the flavors on the top
			pane.setCenter(order); // what is being ordered in the center
			pane.setBottom(tpane); // check boxes for the toppings on the bottom
			
			Scene scene = new Scene( pane, 300, 200);
			primaryStage.setTitle("Ice Cream");
			primaryStage.setScene( scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
