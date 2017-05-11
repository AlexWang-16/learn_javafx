package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

// Attn 1: new imports
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import java.io.File;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;

public class MainController implements Initializable{
	
	@FXML
	private MediaView mediaView;
	
	@FXML
	private MediaPlayer player;
	
	@FXML
	private Media media;
	
	@Override
	public void initialize(URL locate, ResourceBundle resources){
		/* Attn 2: set the path, map the path to the media, map media to player
		 * 		 and map media player to Media view.
		 */
		String path = new File("src/media/dance.mp4").getAbsolutePath();
		media = new Media (new File (path).toURI().toString());
		player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		player.setAutoPlay(true);
		
		/* Attn 3: Find the height and width of the window. 
		 * 		   fitWidthProperty() and fitHeightProperty() returns DoubleProperty
		 * 		   type.
		 */
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		
		/* Attn 4: Preserving aspect ratio while adjusting size of video to window.
		 * 		   This is done by binding the media view's width and height
		 * 			to the scene (video's) width and height.
		 * 
		 * 			Note: sceneProperty() is a final ReadOnlyObjectProperty. So no 
		 * 				  modifications can be made.
		 * 
		 *  		The selectDouble() is a select filter method that zeros into
		 *  		the media view's width and height and mapping it to the scene's
		 *  		width and height.
		 *  
		 *  		Inight takes 2 arguments, the root bean (object to map to) and the 
		 *  		"steps" (property names to reach the property). */
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	}
}
