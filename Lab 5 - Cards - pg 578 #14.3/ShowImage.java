import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowImage extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane to hold the image views
    Pane pane = new VBox(10);
    pane.setPadding(new Insets(5, 5, 5, 5));
    int card1 = (int)(Math.random() * 52) + 1;
    int card2 = (int)(Math.random() * 52) + 1;
    Image image1 = new Image("image/card/" + card1 + ".png");
    pane.getChildren().add(new ImageView(image1));
    
    Image image2 = new Image("image/card/" + card2 + ".png");
    ImageView imageView2 = new ImageView(image2);
    //imageView2.setFitHeight(100);
   // imageView2.setFitWidth(100);
    pane.getChildren().add(imageView2);   

    //ImageView imageView3 = new ImageView(image);
   // imageView3.setRotate(90);
  //  pane.getChildren().add(imageView3);     
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowImage"); // Set the stage title
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
