// Lab 9 - Loan table - pg 671 # 16.13
// Gustavo Assis Cardoso
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Excercise16_13 extends Application {

	protected TextField amount = new TextField();
	protected TextField years = new TextField();
	protected Button show = new Button("Show Table");
	protected TextArea table = new TextArea();

	public void start(Stage primaryStage) {
		
		HBox hBox = new HBox(10);
		years.setPrefColumnCount(2);
		hBox.getChildren().addAll(new Label("Loan Amount"), amount, new Label("Number of Years"), years, show);
			
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(11,12,13,14));
		pane.setTop(hBox);
		pane.setCenter(new ScrollPane(table));
		table.setText("Amount must be greater than 0.\nYears must be between 0 - 99.");
		
		show.setOnAction(e -> calc());
		
		Scene scene = new Scene(pane,500,230);
		primaryStage.setTitle("Compare Loans");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void calc(){
		String output = "Interest Rate\t\t\tMonthly Payment\t\t\tTotalPayment\n" ;
		output += "----------------------------------------------------------------------------\n" ;
		double monthlyInterestRate;
		double monthlyPayment;
		double totalPayment;
		
		try {
			if (Double.parseDouble(years.getText()) <= 0 || Double.parseDouble(years.getText()) > 99) {
				JOptionPane.showMessageDialog(null, "You must enter a valid year (1-99)");
			} else if (Double.parseDouble(amount.getText()) <= 0) {
				JOptionPane.showMessageDialog(null, "You must enter a valid amount (greater then 0)");
			} else {

				for (double i = 5.0; i <= 8.0; i += .125) {
					monthlyInterestRate = i / 1200;
					monthlyPayment = Double.parseDouble(amount.getText()) * monthlyInterestRate
							/ (1 - 1 / Math.pow(1 + monthlyInterestRate, Double.parseDouble(years.getText()) * 12));
					totalPayment = monthlyPayment * 12 * Double.parseDouble(years.getText());
					output += String.format("%-36.3f%-41.2f%-8.2f\n", i, monthlyPayment, totalPayment);
				}

				table.setText(output);
			}
		} catch (NumberFormatException ex) {
			table.setText("You must enter valid year (1-99)\nYou must enter valid amount (greater then 0)");
		}

	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}