import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane and set its properties
    Pane pane = new Pane();
    Text text = new Text(20, 20, "A");
    text.setFocusTraversable(true);
    pane.getChildren().add(text);

    text.setOnKeyPressed(e -> {          
      switch (e.getCode()) {
		case SHIFT: break; // throw away the shift key
		// use the letter d for down as well
        case DOWN: case D: text.setY(text.getY() + 10); break;
        case UP:  text.setY(text.getY() - 10); break;
        case LEFT: text.setX(text.getX() - 10); break;
        case RIGHT: text.setX(text.getX() + 10); break;
        default: 
			String input = e.getText();
			if (!input.isEmpty())
			{			
				if (Character.isLetterOrDigit(e.getText().charAt(0))){
					char ch = e.getText().charAt(0);
					if (e.isShiftDown()) // if the shift key is pressed then convert to upper case
					{
						ch = Character.toUpperCase(ch);
					}
					text.setText(ch+"");
					System.out.println(e.getText());
				}
			}
      }
  });
    
    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("KeyEventDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
} 

