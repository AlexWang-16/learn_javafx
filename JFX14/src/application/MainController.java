package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//Attn 1: new imports
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.Slider;

public class MainController implements Initializable{
	@FXML
	private Slider slider;
	
	@FXML
	private TextField textField;
	
	//Attn 2: The initial value of the slider
	private static final double INIT_VALUE = 50;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.setValue(INIT_VALUE);
		textField.setText(new Double(INIT_VALUE).toString());
		
		/* Attn 3: Bi-directional binding. the textfield has a built in method 
		 * 		   textProperty() so we don't need to add our own listener
		 *		   and implement the changed() method.
		 *
		 * bindBidirection() takes 2 arguments: 
		 * 1) The JavaFX property, retrieved in this case via valueProperty()
		 * 2) The formatting for the other property, in this case it will be printing doubles
		 * 							
		 */
		
		// Attn 4: Create a converter that converts Numbers to String format for bi-directional binding
		StringConverter<Number> converter = new NumberStringConverter();
		textField.textProperty().bindBidirectional(slider.valueProperty(), converter);
		
	}
	
	
}
