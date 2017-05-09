package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sun.util.ResourceBundleEnumeration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

// Attn 1: New import
import javafx.application.Platform;

public class MainController implements Initializable {
	
	@Override
	public void initialize (URL location, ResourceBundle resources){
		
	}
	
	/* Attn 2: The method which shuts down the window and the app by using the close button
	 * 			in the menu bar.*/
	public void closeApp(ActionEvent event){
		Platform.exit();
		System.exit(0);
	}

}
