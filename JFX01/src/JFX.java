import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

/* This is a demo of a basic JavaFX interface scripted without use of additional development tools.*/
public class JFX extends Application {
	public static void main(String[] args){
		//launch() will call start() for the JavaFX application
		launch(args);
	}
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		// This is where you add scenes, layouts, and widgets

		Button btn = new Button("Click me");
		//Demo of coding event handler using anonymous inner class
		btn.setOnAction(new EventHandler<ActionEvent>(){ 
			
			@Override
			public void handle(ActionEvent event){
				System.out.println("Hello World");
			}
		});
		
		/*setTranslateX() and setTranslateY() are used for alignment layout types (i.e.StackPane).
		  Translation is based on distance from the center of the StackPane, where the GUI element
		  begins.
		  
		  Use setLayoutX() and setLayoutY() for coordinate style layout type (i.e. Pane). Using
		  this system will set the exact location on the layout*/
		btn.setTranslateX(-214);
		btn.setTranslateY(-85);
		
		Button btn1 = new Button("click me 2");
		//Demo of coding event handler using lambda expression (single line statement)
		btn1.setOnAction( e -> System.out.println("Click me 2 pressed"));
		
		
		//Demo of multiple statements in lambda expression
		Button btn2 = new Button("exit");
		btn2.setOnAction( e -> {
				System.out.println("App will now exit");
				System.exit(0);
			});
	
		btn2.setTranslateX(228);
		btn2.setTranslateY(85);
		
		StackPane layout1 = new StackPane();
		
		//Adding 1 element use .add(arg)
		//layout1.getChildren().add(btn1);
		
		//Adding multiple elements use .addAll(arg1, arg2, argN)
		layout1.getChildren().addAll(btn, btn1, btn2);
		
		Scene scene1 = new Scene(layout1, 500, 200); //500 is width, 200 is height of window
		primaryStage.setTitle("App Title bar text here");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
}
