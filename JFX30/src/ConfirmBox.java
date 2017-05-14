import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ConfirmBox {
	/* Attn 1: A field that stores the state of the box */
	static boolean result = false;
	
	/* Attn 2: Notice how the declaration of display() returns a boolean */
	public static boolean display(String title, String msg){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(250);
		window.setHeight(150);
		
		Label label = new Label();
		label.setText(msg);
		
		Button yes = new Button("Yes");
		//Attn 3: What happens when user clicks yes
		yes.setOnAction(e -> {
			result = true;
			window.close();
		});
		
		Button no = new Button("No");
		// Attn 4: What happens when user clicks no
		no.setOnAction(e -> {
			result = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yes, no);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene (layout);
		window.setScene(scene);
		window.showAndWait();
		
		//Attn 5: Return the result once the window closes and response given
		return result;
	}
}