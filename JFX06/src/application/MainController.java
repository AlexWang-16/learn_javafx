package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import com.sun.corba.se.impl.orbutil.graph.Node;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField; //New import for text field objects
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtPassword;
	
	public void Login(ActionEvent event) throws Exception{
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
				lblStatus.setText("Login success");
				 
				/* Attn 3: Opens another window (stage) and displays contents after logining in */
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
				/* Attn 4: 
				 * The following is for proof of concept.
				 * 
				 * Close the login window to make transition appear seamless.
				 * The code below will latch onto a GUI element in the login screen and use getScene()
				 * to grab its Scene information and then traverse into its Window (aka. Stage)
				 * We can then call close to close that stage from within a controller method.
				 */
				Stage stage = (Stage) lblStatus.getScene().getWindow();
				stage.close();
		}
		else {
			lblStatus.setText("Login Failed");
		}
	}
}
