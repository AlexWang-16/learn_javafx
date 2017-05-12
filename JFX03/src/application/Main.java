package application;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.*;
import javafx.fxml.FXMLLoader;

/*Demo showing how to build layout using FXML file and Scene Builder to reduce
development time*/

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
	
		/* Attn 1: Parent is the base class for all nodes in a scene.
		 * FXMLLoader.load() will locate the FXML file to load the layout 
		 * 
		 * FXML file path convention: The first slash is the root of the project. Then, the
		 * package name is specified and finally, the name of the file.*/			
		
		Parent root = FXMLLoader.load(Main.class.getResource("/application/Main.fxml"));
		
		Scene scene = new Scene(root);
		
		/* Attn 2: Links CSS file to the scene. 
		 * Notice the path is just the file name because it is under the same package.*/
		scene.getStylesheets().add(getClass().getResource("appstyle.css").toExternalForm());

		primaryStage.setTitle("App Title bar text here");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
