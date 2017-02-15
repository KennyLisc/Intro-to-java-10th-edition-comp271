import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class IceCream2 extends Application{
	private ComboBox<String> flavors;
	private ListView<String> toppings;
	private TextField order;
	private Button orderit, clearit;
	private Label lb_flavor, lb_tops, lb_order;
	private ObservableList<String> flavor =
			FXCollections.observableArrayList (
					"Vanilla", "Chocolate",
					"Strawberry", "Coffee",
					"Swiss Almond", "Choc&Vanilla");
	private ObservableList<String> tps =
			FXCollections.observableArrayList(
					"Whipped Cream", "Peanuts",
					"Walnuts", "Cherry", "M&Ms",
					"Raisins");
	public void start(Stage primaryStage) {
		// areas to place the various components
		VBox pane = new VBox(15);
		HBox flavor_pane = new HBox(10);
		HBox topping_pane = new HBox(10);
		HBox order_pane = new HBox(10);
		
		lb_flavor = new Label("Flavors");
		flavors = new ComboBox(flavor);
		flavors.setVisibleRowCount(4);
		flavors.setValue("Vanilla"); // display the first one
		
		flavor_pane.getChildren().addAll(lb_flavor, flavors);
		
		lb_tops = new Label("Toppings");
		toppings = new ListView(tps);
		toppings.setPrefSize(100,80);


		topping_pane.getChildren().addAll(lb_tops, toppings);
		
		lb_order = new Label("Order Summary");
		order = new TextField();
		order.setEditable(false);
		order.setPrefColumnCount(25);
		
		order_pane.getChildren().addAll(lb_order, order);
		
		orderit = new Button("Place Order");
		clearit = new Button("Clear Order");
		
		// Subscribe for when the user clicks the buttons
		
		
		pane.getChildren().addAll(flavor_pane,
				topping_pane, order_pane, orderit, clearit);
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("IceCream");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
}