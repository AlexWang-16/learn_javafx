package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

/* Purpose: The purpose of this excercise is to implement a combobox (select box) inside
 * a java application.
 */

/* Attn1: We will be need to implement Initializable and its method initialize) for
 *  the combobox */
public class MainController implements Initializable{
	
	@FXML
	public ComboBox<String> combobox;
	public Label selectedName;
	
	/* Attn2: ObservableList is a JavaFX Collections container that detects events occurring specifically for interface like our combobox scenario. 
	 * 		  We can add the list programatically here or directly in the FXML file (see Main.FXML).
	 * 			
	 *		  Even if we do not want to programatically add the list of names, we still need an Observable list,
	 *		  such that the FXML code for the observable list can be mapped back to this variable
	 * */
	//ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");
	ObservableList<String> list;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* Attn3: When programatically adding items to the Combobox via ObservableList, run the line below to set the items */
		//combobox.setItems(list);
	}
	
	/* Attn3: When a selection has been made in the combo box, this method will determine what
	 * happens */
	public void comboChange(ActionEvent event){
		/* Attn 4: The code performs 2 operations
		 * 1) The Label setup right under the combo box changes to the selection
		 * 2) Additional names "Ram", "Ben", "Sam" and "Ken" get added to the combobox
		 */
		//combobox.getItems().addAll("Ram", "Ben", "Sam", "Ken");
		selectedName.setText(combobox.getValue());
	}
}
