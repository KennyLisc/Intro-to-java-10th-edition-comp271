import java.io.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class AddressBook extends Application  {
  // Specify the size of five string fields in the record
  final static int NAME_SIZE = 32;
  final static int STREET_SIZE = 32;
  final static int CITY_SIZE = 20;
  final static int STATE_SIZE = 2;
  final static int ZIP_SIZE = 5;
  final static int RECORD_SIZE =
    (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

  // Access address.dat using RandomAccessFile
  private RandomAccessFile raf;

  // Text fields
  private TextField tfName = new TextField();
  private TextField tfStreet = new TextField();
  private TextField tfCity = new TextField();
  private TextField tfState = new TextField();
  private TextField tfZip = new TextField();

  // Buttons
  private Button btAdd = new Button("Add");
  private Button btFirst = new Button("First");
  private Button btNext = new Button("Next");
  private Button btPrevious = new Button("Previous");
  private Button btLast = new Button("Last");

  public void start(Stage primaryStage) {
    // Open or create a random access file
    try {
      raf = new RandomAccessFile("address.dat", "rw");
    }
    catch(IOException ex) {
      System.out.print("Error: " + ex);
      System.exit(0);
    }
	BorderPane pane = new BorderPane(); 
    // Panel paddress for name, street, city
    VBox paddress = new VBox(10);
	HBox pname = new HBox(5); // name
	HBox pstreet = new HBox(5); // street
	HBox pcity = new HBox(5); // city, state, zip

	tfName.setPrefColumnCount(NAME_SIZE);
	tfStreet.setPrefColumnCount(STREET_SIZE);
	tfCity.setPrefColumnCount(CITY_SIZE);
	tfState.setPrefColumnCount(STATE_SIZE);
	tfZip.setPrefColumnCount(ZIP_SIZE);	


	pname.getChildren().addAll(new Label("Name"), tfName);
	pstreet.getChildren().addAll(new Label("Street"), tfStreet);
	pcity.getChildren().addAll(new Label("City"), tfCity,
		new Label("State"), tfState, new Label("Zip"), tfZip );    
  
	paddress.getChildren().addAll( pname, pstreet, pcity );
    // Add buttons to a panel
    HBox pbutton = new HBox(5);
    pbutton.getChildren().addAll(btAdd,
			btFirst, btNext,
			btPrevious, btLast);

    // Add jpAddress and jpButton 
    pane.setCenter(paddress);
    pane.setBottom(pbutton);

	Scene scene = new Scene( pane, 400, 150);
	primaryStage.setTitle("Address Book");
	primaryStage.setScene( scene);
	primaryStage.show();

    btAdd.setOnAction(e -> writeAddress());
      
    btFirst.setOnAction(e -> {
      
        try {
          if (raf.length() > 0) readAddress(0);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      
    });

    btNext.setOnAction(e -> {
        try {
          long currentPosition = raf.getFilePointer();
          if (currentPosition < raf.length())
            readAddress(currentPosition);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      
    });
    btPrevious.setOnAction(e -> {
        try {
          long currentPosition = raf.getFilePointer();
		  if (currentPosition == 0)	// at first record	  
			  return;
		  
          if (currentPosition - 2 * RECORD_SIZE > 0)            
            readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
          else
            readAddress(0);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      
    });
    btLast.setOnAction(e -> {
        try {
          long lastPosition = raf.length();
          if (lastPosition > 0)            
            readAddress(lastPosition - 2 * RECORD_SIZE);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      
    });

    // Display the first record if exists
    try {
      if (raf.length() > 0) readAddress(0);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /** Write a record at the end of the file */
  public void writeAddress() {
    try {
      raf.seek(raf.length());
      FixedLengthStringIO.writeFixedLengthString(
        tfName.getText(), NAME_SIZE, raf);
      FixedLengthStringIO.writeFixedLengthString(
        tfStreet.getText(), STREET_SIZE, raf);
      FixedLengthStringIO.writeFixedLengthString(
        tfCity.getText(), CITY_SIZE, raf);
      FixedLengthStringIO.writeFixedLengthString(
        tfState.getText(), STATE_SIZE, raf);
      FixedLengthStringIO.writeFixedLengthString(
        tfZip.getText(), ZIP_SIZE, raf);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /** Read a record at the specified position */
  public void readAddress(long position) throws IOException {
    raf.seek(position);
    String name = FixedLengthStringIO.readFixedLengthString(
      NAME_SIZE, raf);
    String street = FixedLengthStringIO.readFixedLengthString(
      STREET_SIZE, raf);
    String city = FixedLengthStringIO.readFixedLengthString(
      CITY_SIZE, raf);
    String state = FixedLengthStringIO.readFixedLengthString(
      STATE_SIZE, raf);
    String zip = FixedLengthStringIO.readFixedLengthString(
      ZIP_SIZE, raf);

    tfName.setText(name);
    tfStreet.setText(street);
    tfCity.setText(city);
    tfState.setText(state);
    tfZip.setText(zip);
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
