package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

//Attn 1: new import
import java.time.LocalDate;

public class MainController {
	
	/* Attn 2: Configurations of the date picker can be customized under Scene Builder
	 * 		   "properties" pane.
	 */
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private Label dateLabel;
	
	public void showDate(ActionEvent event){
		
		/* Attn 2: DatePicker is a JavaFX Property. Using getValue(), we can get the 
		 * 		   date that the user selected in the form of LocalDate
		 */
		LocalDate date = datePicker.getValue();
		dateLabel.setText(date.toString());
	}
}
