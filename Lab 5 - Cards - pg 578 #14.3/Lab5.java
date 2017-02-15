// Lab 5 - Cards - pg 578 #14.3
// Gustavo Assis Cardoso
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab5 extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        boolean[] usedCards = new boolean[52];
        int count = 0;
        while (count < 3) {
            int card = (int) (Math.random() * 52);
            if (!usedCards[card]) {
                usedCards[card] = true;
                pane.add(new ImageView(new Image("image/card/"+(++card)+".png")), count, 0);
                count++;
            }
        }
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}