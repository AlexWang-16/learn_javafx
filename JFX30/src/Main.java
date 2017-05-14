import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class Main extends Application{
	Stage window;
	Button button;
	boolean response = false;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		window = primaryStage;
	
		
		button = new Button ("Click me");
		button.setOnAction(e -> {
			//Attn 6: The boolean "response" captures the response returned by ConfirmBox
			response = ConfirmBox.display("Alert", "Are you sure?");
			if (response){
				System.out.println("User says yes.");
			}else{
				System.out.println("User says no.");
			}
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene (layout, 300, 150);
		window.setScene(scene);
		window.show();
		
		
	}
}
