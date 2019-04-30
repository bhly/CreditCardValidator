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

public class Validator extends Application{
	
	private Card c;
	private TextField tf;
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
