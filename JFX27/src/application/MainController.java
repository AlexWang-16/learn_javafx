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
import javafx.event.ActionEvent;
public class MainController implements Initializable{
	
	@FXML
	private MediaView mediaView;
	
	@FXML
	private MediaPlayer player;
	
	@FXML
	private Media media;
	
	@Override
	public void initialize(URL locate, ResourceBundle resources){
	
		String path = new File("src/media/dance.mp4").getAbsolutePath();
		media = new Media (new File (path).toURI().toString());
		player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		
		
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	}
	
	/* Attn 1: The following methods are used by the control buttons to manipulate
	 * 		   the way the videos are presented */
	 
	public void play(ActionEvent event){
		player.play();
	}
	
	public void pause(ActionEvent event){
		player.pause();
	}
	
	public void fast_motion(ActionEvent event){
		/* Attn 2: setRate() takes a double value. Default is 1. Here, we are incrementing
		 * 			The current speed of the video by 2x each time the 2x button is pressed.*/
		
		player.setRate(player.rateProperty().get() * 2);
	}

	public void slow_motion(ActionEvent event){
		/* Attn 3: This command will slow down the video by 50% every time the 0.5x button
		 * 		   is clicked
		 */
		player.setRate(player.rateProperty().get() * 0.5);
	}
	
	public void normal_motion(ActionEvent event){
		/* Attn 4: This command will immedately reset the playing speed to 1x via
		 * 		   the 1x button.
		 */
		player.setRate(1);
	}

	public void reload(ActionEvent event){
		player.seek(player.getStartTime());
		player.play();
	}

	public void start(ActionEvent event){
		player.seek(player.getStartTime());
		player.stop();
	}

	public void last(ActionEvent event){
		player.seek(player.getTotalDuration());
		player.stop();
	}

}
