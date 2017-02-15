import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class circleGame extends Application {

	private Color nextColor;
	private int counter=1;
	private long startTime,endTime;
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
	
		Scene scene = new Scene(pane,200,200);
		primaryStage.setTitle("Get the Circle");
		primaryStage.setScene( scene );
		primaryStage.show();
	
		Circle mycircle = new Circle(40,40,10);
		nextColor = new Color(Math.random(), Math.random(),Math.random(),1);
		nextColor = new Color(Math.random(), Math.random(),Math.random(),1);
		mycircle.setFill(nextColor);
		mycircle.setStroke(nextColor);
		
		pane.getChildren().add(mycircle);
		startTime=System.currentTimeMillis();
		
		//event handler
		mycircle.setOnMouseEntered(e ->{
		
			if(counter<10){
				double newX = Math.random()*scene.getWidth();
				double newY = Math.random()*scene.getHeight();
			nextColor = new Color(Math.random(), Math.random(),Math.random(),1);
			mycircle.setFill(nextColor);
			mycircle.setCenterX(newX);
			mycircle.setCenterY(newY);
			counter++;
			}
			
			else {
				endTime = System.currentTimeMillis();
				pane.getChildren().clear();
				Text display= new Text(30,30,"Time spent "+(endTime-startTime)+" in millis");
				pane.getChildren().add(display);
			}
		});
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
