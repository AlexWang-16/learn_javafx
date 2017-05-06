package application;

import javafx.event.*;
import javafx.fxml.FXML;	//New Import for FXML data annotation

import javafx.scene.control.Label; //New Import for our label. Do not confuse with awt version for swing
import java.util.Random;

/* This is a controller class for our app */
public class MainController {
	
	@FXML //This annotation allows the code below to be accessible to FXML and Scene Builder
	private Label randomNumberResult;
	
	public void generateRandom(ActionEvent event) {
			Random seed = new Random();
			int randomNumber = seed.nextInt(50) + 1;
			randomNumberResult.setText(Integer.toString(randomNumber));
	}
}
