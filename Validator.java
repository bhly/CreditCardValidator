import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

/** 
A GUI based application that accepts a credit card number and uses a checksum
to determine if the number is a valid credit card number.
*/
public class Validator extends Application{
	
	/**
	Represents the user's credit card.
	*/
	private Card c;
	/**
	The user enters their credit card number via this text field.
	*/
	private TextField tf;
	/**
	This text displays the results of the validation to the user.
	*/
	private Text txt;
	
	public void start(Stage stage){
		
		stage.setTitle("CC Validator");
		
		
		Label label = new Label("Enter your 16-digit card number (no spaces)");
		
		tf = new TextField();
			tf.setPrefWidth(150);
		
		Button b = new Button("Validate");
			b.setOnAction(this::handle);
		
		txt = new Text("");

		
		FlowPane pane = new FlowPane(label, tf, b, txt);
			pane.setVgap(20);
			pane.setHgap(43);
			pane.setAlignment(Pos.CENTER);
			
		Scene scene = new Scene(pane, 270, 180);
		
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	This method handles the ActionEvent created when the "Validate" button is pressed.
	@param e The ActionEvent that occurs when the "Validate" button is pressed.
	*/
	public void handle(ActionEvent e){
		
		try{
		c = new Card(tf.getText());
		c.addNums(c.getNum());
		c.validate(c.getArray());
		}catch(StringIndexOutOfBoundsException exception){
			tf.setText("");
		}
		if(c.isValid() == true)
			txt.setText("The card number you entered is valid.");
		else if(c.isValid() == false)
			txt.setText("The card number you entered is invalid.");
			
	}
}
