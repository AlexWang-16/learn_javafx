package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

//Attn 1: New imports
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class MainController implements Initializable{
	final MyNumber myNum = new MyNumber();
	
	@FXML
	private Label lblStatus;
	
	//Attn 2: New properties declared
	@FXML
	private ProgressBar pb;
	
	@FXML 
	private ProgressIndicator pi;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		myNum.setNumber(0);
		myNum.numberProperty().addListener(new ChangeListener<Object>(){
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				lblStatus.setText(new Double(myNum.getNumber()).toString());
			}
		});
		
		/*Attn 3: binding property of progress bar to myNum property. 
		 * 		  This is uni-directional binding. When myNum increases, only progress
		 * 		  bar will increase.*/
		pb.progressProperty().bind(myNum.numberProperty());

		
		/* Attn 4: Binding the progress indicator to myNum */
		pi.progressProperty().bind(myNum.numberProperty());
	}
	
	public void btnClick(ActionEvent event){
		myNum.setNumber(myNum.getNumber() + 0.1);
	}
	
	public void btn2Click(ActionEvent event){
		myNum.setNumber(myNum.getNumber() - 0.1);
	}
}
