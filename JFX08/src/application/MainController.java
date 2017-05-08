package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class MainController implements Initializable{
	@FXML
	private Label myLabel;
	public ComboBox<String> combobox;
	public ListView<String> listView; //Attn1: List view is the same as a multiselect list that shows X rows of selectable items
	
	ObservableList<String> list = FXCollections.observableArrayList("Tom", "Jerry", "John", "Jack");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* Attn2: setItem() takes an ObserableList. If the line below is enabled, it will
		 * override the default items in the listview in the fxml. Run it once with and iwthout
		 * commenting the line below to see the difference. */
		//listView.setItems(list); 
		
		/* Attn3: By setting selection mode to multiple, we can create a multiselect box
		 * Without it, it will be just a listbox that allows one selection */
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
	}
	
	public void comboChanged(ActionEvent event){
		myLabel.setText(combobox.getValue());
		
		/* Attn4: Adding additional elements to listview after selection has been made
		 * to combo box */
		listView.getItems().addAll("Jennifer", "Anna", "Olena");
	}
	
	public void buttonAction(ActionEvent event){
		/* Attn5: Getting the selected names when the "select" button is pressed */
		ObservableList<String> names = listView.getSelectionModel().getSelectedItems();
		
		for(String name : names){
			System.out.println(name);
		}
	}
	
	

}
