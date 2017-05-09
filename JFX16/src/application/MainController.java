package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;

public class MainController {
	/* Attn 1: declaring CheckBox variables that map to FXML. 
	 * Name must be identical to fx:id of checkbox in FXML.
	 */
	@FXML
	private CheckBox dogCheckbox;
	
	@FXML
	private CheckBox catCheckbox;
	
	@FXML
	private CheckBox cowCheckbox;
	
	@FXML
	private CheckBox ratCheckbox;
	
	@FXML
	private Label lblCount;
	
	@FXML 
	private Label lblList;
	
	/*Attn 2: a method that will count number of items selected and report back
	 * 		  the number of items selected and the names of the items selected.*/
	public void boxChecked(ActionEvent event){
		int count = 0;
		String msg = "";
		
		if (dogCheckbox.isSelected()){
			count++;
			msg += dogCheckbox.getText() + '\n';
		}
		if (catCheckbox.isSelected()){
			count++;
			msg += catCheckbox.getText() + '\n';
		}
		if (cowCheckbox.isSelected()){
			count++;
			msg += cowCheckbox.getText() + '\n';
		}
		if (ratCheckbox.isSelected()){
			count++;
			msg += ratCheckbox.getText() + '\n';
		}
		lblList.setText(msg);
		lblCount.setText("Items selected: " + count);
	}
}
