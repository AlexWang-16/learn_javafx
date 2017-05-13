import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	public static void display(String title, String msg){
		Stage window = new Stage();
		
		/* Attn 1:  Modality sets the behavior of events when a window is open
		 * 			When APPLICATION_MODAL is active, the user must close the window
		 * 			before other windows on the app respond to user's actions.
		 * 
		 * 			It is a blocking method call .
		 */
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(250);
		window.setHeight(150);
		
		Label label = new Label();
		label.setText(msg);
		
		Button button = new Button("Close the window");
		button.setOnAction(e -> window.close());
		
		/* Attn 2: The parameter 10 is the spacing between each element */
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		/* Attn 3: Blocks further code execution until the window has closed
		 */
		window.showAndWait();
	}
}
