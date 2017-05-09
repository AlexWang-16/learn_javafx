package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
	final MyNumber myNum = new MyNumber();
	
	@FXML
	private Label lblStatus;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		myNum.setNumber(0);
		
		/* Attn 5: Adding a listener that is looking for changes in myNum. When it detects it
		 * it will update the label to reflect the changes.*/
		myNum.numberProperty().addListener(new ChangeListener<Object>(){

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				/* Attn 6: setText() takes a String, so we are obtaining the double value from 
				 * 		   the DoubleProperty, then converting it to a String using toString() */
				lblStatus.setText(new Double(myNum.getNumber()).toString());
				
			}
			
		});
	}
	
	public void btnClick(ActionEvent event){
		myNum.setNumber(myNum.getNumber() + 1);
	}
}
