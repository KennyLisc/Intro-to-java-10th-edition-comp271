//Lab12 Pizza User Interface
//Gustavo Assis Cardoso
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Pizza extends Application{
	
	double cost = 0;
	String toppings, pizzaSize, pizzaType, deliveryFee = "";
	
	TextArea text = new TextArea();
	
	CheckBox beef = new CheckBox("Beef");
	CheckBox pepperoni = new CheckBox("Pepperoni");
	CheckBox chicken = new CheckBox("Chicken");
	CheckBox salami = new CheckBox("Salami");
	CheckBox mushrooms = new CheckBox("Mushrooms");
	CheckBox spinach = new CheckBox("Spinach");
	CheckBox olives = new CheckBox("Olives");
	CheckBox peppers = new CheckBox("Green Peppers");
	
	RadioButton hand = new RadioButton("Hand Tossed");
	RadioButton pan = new RadioButton("Handmade Pan");
	RadioButton thin = new RadioButton("Crunchy Thin Crust");
	
	RadioButton delivery = new RadioButton("Delivery ($3.0)");
	RadioButton pickup = new RadioButton("Pick up");
	
	RadioButton small = new RadioButton("Small (10\")");
	RadioButton medium = new RadioButton("Medium (12\")");
	RadioButton large = new RadioButton("Large (14\")");
	
	public void start(Stage pStage){
		
		VBox type = new VBox(10);
		type.setPadding(new Insets(10));
		type.setStyle("-fx-border-color:orange;");

		Label lb1 = new Label("Pizza Type");
		lb1.setStyle("-fx-text-fill:orange;-fx-font-size:15px;-fx-font-weight:bold;");
		type.getChildren().addAll(lb1,hand, pan, thin);
		
		ToggleGroup toggleForType = new ToggleGroup();
		hand.setToggleGroup(toggleForType);
		pan.setToggleGroup(toggleForType);
		thin.setToggleGroup(toggleForType);
		
		VBox deliveryPane = new VBox(10);
		deliveryPane.setPadding(new Insets(10));
		deliveryPane.setStyle("-fx-border-color:orange;");
		deliveryPane.getChildren().addAll(delivery,pickup);
		
		ToggleGroup toggleForDelivery = new ToggleGroup();
		delivery.setToggleGroup(toggleForDelivery);
		pickup.setToggleGroup(toggleForDelivery);
		
		VBox column1 = new VBox(25);
		column1.setAlignment(Pos.TOP_CENTER);
		column1.getChildren().addAll(type,deliveryPane);
		
		VBox size = new VBox(10);
		size.setPadding(new Insets(10));
		size.setStyle("-fx-border-color:orange;");
		
		ToggleGroup toggleForSize = new ToggleGroup();
		small.setToggleGroup(toggleForSize);
		medium.setToggleGroup(toggleForSize);
		large.setToggleGroup(toggleForSize);
		Label lb2 = new Label("Pizza Size");
		lb2.setStyle("-fx-text-fill:orange;-fx-font-size:15px;-fx-font-weight:bold;");
		size.getChildren().addAll(lb2,small, medium, large);
		
		Button process = new Button("Process");
		process.setFont(Font.font("Arial",20));
		Button clear = new Button("Clear");
		clear.setFont(Font.font("Arial",20));
		
		VBox column2 = new VBox(30);
		column2.setAlignment(Pos.TOP_CENTER);
		column2.getChildren().addAll(size,process,clear);
		
		VBox topping = new VBox(10);
		topping.setPadding(new Insets(10));
		topping.setStyle("-fx-border-color:orange;");
		Label lb3 = new Label("Pizza Topping");
		Label each = new Label("(each topping is $0.50)");
		lb3.setStyle("-fx-text-fill:orange;-fx-font-size:15px;-fx-font-weight:bold;");
		each.setStyle("-fx-text-fill:gray;-fx-font-size:12px;");
		topping.getChildren().addAll(lb3,each,beef,pepperoni,chicken,salami,mushrooms,spinach,olives,peppers);
		
		HBox hBox = new HBox(50);
		hBox .setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(column1, column2, topping);
		
		text.setEditable(false);
		text.setStyle("-fx-background-color:orange;");
		Label label = new Label("Pizza App");
		label.setFont(Font.font("Arial",FontWeight.BOLD,30));
		label.setStyle("-fx-text-fill:orange;");
		
		process.setOnAction(e ->{
			cost = 0;
			pizzaType();
			pizzaSize();
			toppings();
			delivery();
			text.setText(pizzaType + pizzaSize + toppings  + "\n" + deliveryFee +"\t\t\t\t\t\tORDER TOTAL:      $" + cost);
			text.setStyle("-fx-font-weight:bold;");
		});
		clear.setOnAction(e ->{
			clearSelection();
		});
		
		VBox pane = new VBox(20);
		pane.setPadding(new Insets(11));
		pane.setAlignment(Pos.CENTER);
		Label lb4 = new Label("YOUR ORDER");
		lb4.setStyle("-fx-text-fill:orange;-fx-font-size:15px;-fx-font-weight:bold;");
		pane.getChildren().addAll(label, hBox, lb4, text);
		
		Scene scene = new Scene(pane);
		pStage.setScene(scene);
		pStage.setResizable(false);
		pStage.setTitle("Pizza App");
		pStage.show();
		
	}
	public void pizzaType(){
			if(hand.isSelected()){
				pizzaType = "Pizza Type: \n\t\tHand Tossed\n";
			}
			else if(pan.isSelected()){
				pizzaType = "Pizza Type: \n\t\tHandmade Pan\n";
			}
			else if(thin.isSelected()){
				pizzaType = "Pizza Type: \n\t\tCrunchy Thin Crust\n";
			}
	}
	public void pizzaSize(){
		if(small.isSelected()){
			pizzaSize = "Pizza Size: \n\t\tSmall Pizza\n"; 
			cost += 8;
			}
		else if(medium.isSelected()){
			pizzaSize= "Pizza Size: \n\t\tMedium Pizza\n";
			cost += 10;
			}
		else if(large.isSelected()){
			pizzaSize= "Pizza Size: \n\t\tLarge Pizza\n";
			cost += 12;
			}
	}
	public void toppings() {
		toppings = "Toppings: \n\t\t";
		if(beef.isSelected()){
			toppings += "Beef, ";
			cost += .5;
		}
		if(pepperoni.isSelected()){
			toppings += "Pepperoni, ";
			cost += .5;
		}
		if(chicken.isSelected()){
			toppings += "Chicken, ";
			cost += .5;
		}
		if(salami.isSelected()){
			toppings += "Salami, ";
			cost += .5;
		}
		if(mushrooms.isSelected()){
			toppings += "Mushrooms, ";
			cost += .5;
		}
		if(spinach.isSelected()){
			toppings += "Spinach, ";
			cost += .5;
		}
		if(olives.isSelected()){
			toppings += "Olives, ";
			cost += .5;
		}
		if(peppers.isSelected()){
			toppings += "Green Peppers, ";
			cost += .5;
		}
		
	}
	public void delivery(){
		if(delivery.isSelected()){
			cost += 3;
			deliveryFee = "Delivery Fee: $3 \n\t\t";
		}
		if(pickup.isSelected()){
			deliveryFee = "For Pickup  \n\t\t";
		}
	}

	public void clearSelection() {
		text.clear();
		cost = 0;
		toppings = pizzaSize = pizzaType = deliveryFee = "";
		delivery.setSelected(false);
		pickup.setSelected(false);
		hand.setSelected(false);
		pan.setSelected(false);
		thin.setSelected(false);
		small.setSelected(false);
		medium.setSelected(false);
		large.setSelected(false);
		beef.setSelected(false);
		pepperoni.setSelected(false);
		chicken.setSelected(false);
		salami.setSelected(false);
		mushrooms.setSelected(false);
		spinach.setSelected(false);
		olives.setSelected(false);
		peppers.setSelected(false);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}