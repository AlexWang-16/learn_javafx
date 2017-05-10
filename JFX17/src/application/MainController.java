package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

// Attn 2: new import
import javafx.scene.control.RadioButton;

public class MainController {
	
	/* Attn 3: Declaring radio buttons. 
	 * Names of these buttons must match their respective fx:id in Scene Builder.
	 */
	@FXML
	private RadioButton male;
	
	@FXML
	private RadioButton female;
	
	@FXML
	private Label label;
	
	public void radioSelected(ActionEvent event){
		String msg = "";
		if (male.isSelected()){
			msg += male.getText() + '\n';
		}
		if (female.isSelected()){
			msg += female.getText() + '\n';
		}
		label.setText(msg);
	}
}
