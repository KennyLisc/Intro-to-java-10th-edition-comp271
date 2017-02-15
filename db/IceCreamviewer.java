
import javax.swing.border.*;
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

//
// A simple user interface to display ice cream orders from a database
//
public class IceCreamviewer extends Application 
{
  
  private TextArea orders;  
  private Button submit, clear;
 
public void start(Stage primaryStage) {
 
       
    BorderPane pane = new BorderPane();   

	VBox mid_panel = new VBox(10);
	orders = new TextArea();
	orders.setPrefColumnCount(50);
	orders.setPrefRowCount(8);
	orders.setEditable(false);
	mid_panel.getChildren().addAll( new Label("List of orders"), new ScrollPane (orders) );
	  
	
	pane.setCenter( mid_panel );
	
	HBox bot_panel = new HBox(10);
	submit = new Button("View Orders");
	clear = new Button("Clear Orders");
	bot_panel.getChildren().addAll( submit , clear);
	
	pane.setBottom(bot_panel);

	OrderHandler oh = new OrderHandler();
	ClearHandler ch = new ClearHandler();
	submit.setOnAction(oh);
	clear.setOnAction(ch);

	Scene scene = new Scene( pane, 300, 200);
	primaryStage.setTitle("Ice Cream Viewer");
	primaryStage.setScene( scene);
	primaryStage.show();
	
    
  }


  public static void main(String args[])
  {
    Application.launch(args);
   }
 

// To view the orders on the data base
class OrderHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent e){
				
	try
	{
		// query db
		 Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loaded");

		// Establish a connection

		Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost/project", "root", "");

		System.out.println("Database connected");

		// Create a statement
		Statement stmt = connection.createStatement();
		  // Execute a statement
    ResultSet resultSet = stmt.executeQuery
      ("select ordertime, flavor, toppings, phone from iceorder ");

    // Iterate through the result and display the orders
    while (resultSet.next())
		{
      orders.appendText(resultSet.getString(1) + " " +
        resultSet.getString(2) + " " + resultSet.getString(3) +
		" " + resultSet.getString(4) + "\n");
		}

		// Close the connection
		 connection.close();
	

	}
	catch (ClassNotFoundException ex)
	{
		message_time( "Class not found", "Error viewing order");
				
	}
	catch (SQLException ex)
	{
		message_time( "SQL exception", "Error viewing order");				
	}
				
	 
	}
}
	public void message_time(String message, String title) {
		// Handle the errors
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}


class ClearHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent e){
	{
				
		orders.setText("");				
	 
	}
	} 


}
}