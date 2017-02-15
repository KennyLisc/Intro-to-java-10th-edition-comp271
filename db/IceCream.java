
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import java.sql.*;
import java.util.Date;


public class IceCream extends Application 
implements EventHandler<ActionEvent>{

	private RadioButton vanilla, choc, straw;
	private TextField order;
	private Label tops, flavors;
	private CheckBox whip, cherry, mms;
	private TextField phone;
	private Button submit;
	private String icecream_picked = "Vanilla";
	private String toppings_picked = "";

	// take care the flavors
	public void handle(ActionEvent e) {
		if (vanilla.isSelected())
			icecream_picked = "Vanilla";
		else if (choc.isSelected())
			icecream_picked = "Chocolate";
		else
			icecream_picked = "Strawberry";
		// display the icecream selected
		order.setText(icecream_picked + toppings_picked);
				
	}
	public void start(Stage primaryStage) {
	
			VBox pane = new VBox(10);
			HBox fpane = new HBox(10); // for flavors
			HBox tpane = new HBox(10); // for toppings
			HBox opane = new HBox(10); // for ordering
			
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
			vanilla.setSelected(true); // turn Vanilla on
			
			// register each flavor
			vanilla.setOnAction(this);
			choc.setOnAction(this);
			straw.setOnAction(this);
			
			// do the toppings
			tops = new Label("Toppings");
			whip = new CheckBox("Whipped Cream");
			cherry = new CheckBox("Cherry");
			mms = new CheckBox("M&Ms");
			
			// take care of registering the toppings
			ToppingHandler top_handler = new ToppingHandler();
			whip.setOnAction(top_handler);
			cherry.setOnAction(top_handler);
			mms.setOnAction(top_handler);

			// phone number of order and submit button
			phone = new TextField();
			// set column
			submit = new Button("Place Order");

			OrderHandler order_handler = new OrderHandler();
			submit.setOnAction(order_handler);
			
			// place stuff on screen
			fpane.getChildren().addAll(flavors, vanilla, choc, straw);
			
			tpane.getChildren().addAll(tops, whip, cherry, mms);
			opane.getChildren().addAll( new Label("Phone"), phone, submit);

			pane.getChildren().addAll(fpane, order, tpane, opane);
			
			Scene scene = new Scene( pane, 300, 200);
			primaryStage.setTitle("Ice Cream");
			primaryStage.setScene( scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
class ToppingHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent e){
		toppings_picked = "";
		if (whip.isSelected())
			toppings_picked += " whipped cream";
		if (cherry.isSelected())
			toppings_picked += " cherry";
		if (mms.isSelected())
			toppings_picked += " M&Ms";
		order.setText(icecream_picked + toppings_picked);
	}
}
class OrderHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent e){
		// validate phone number
		String phone_number = phone.getText();
		if (!phone_number.matches("[0-9]{10}") )
		{
			// invalid phone number
			phone.setText("Invalid phone number");
			return;
		}
		Date now = new Date();	
		try
		{
		// insert into db
		 Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loaded");

		// Establish a connection

		Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost/project", "root", "");

		System.out.println("Database connected");

		// Create a statement
		Statement stmt = connection.createStatement();
		// Build a SQL INSERT statement
		String insertStmt =
		 "INSERT INTO iceorder(ordertime, flavor, toppings, phone) VALUES('" +
			now.toString() + "','" +
			icecream_picked + "','" +
			toppings_picked + "','" +  		
			phone_number + "');";    

		stmt.executeUpdate(insertStmt);
		// Close the connection
		 connection.close();

	// display confirmation box
		message_time( "Ice Cream order received", "Ice Cream", AlertType.INFORMATION);
				

	}
	catch (ClassNotFoundException ex)
	{
		message_time("Class not found", "Error inserting order", AlertType.ERROR);
		
	}
	catch (SQLException ex)
	{
		message_time( "SQL exception", "Error inserting order", AlertType.ERROR);
				
	}
	}
	public void message_time(String message, String title, Alert.AlertType tp) {
		// Handle the errors

		Alert alert = new Alert(tp);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();

		
	}
}

}
