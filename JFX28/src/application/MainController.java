package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.beans.Observable;
import java.util.ResourceBundle;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import java.io.File;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

// Attn 1: new imports
import javafx.scene.control.Slider;
import javafx.beans.InvalidationListener;

public class MainController implements Initializable{
	
	@FXML
	private MediaView mediaView;
	
	@FXML
	private MediaPlayer player;
	
	@FXML
	private Media media;
	
	@FXML
	private Slider volumeSlider;
	
	@Override
	public void initialize(URL locate, ResourceBundle resources){
	
		String path = new File("src/media/dance.mp4").getAbsolutePath();
		media = new Media (new File (path).toURI().toString());
		player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width").subtract(64.0));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
		
		volumeSlider.setValue(player.getVolume() * 100);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				player.setVolume(volumeSlider.getValue() / 100);
			}

		});
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

	public void stop(ActionEvent event){
		player.seek(player.getStartTime());
		player.stop();
		
		/* To seek to the end of the video, use the following code
		 * player.seek(player.getTotalDuration());
		 */	
	}
	
	/* Attn 5: This method will allow the user to load any video via File Chooser */
	public void loadVideo(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("MP4", "*.mp4"));
		File video = fc.showOpenDialog(null);
		
		if (video != null){
			
			player.dispose();
			
			media = new Media (new File(video.getAbsolutePath()).toURI().toString());
			player = new MediaPlayer (media);
			mediaView.setMediaPlayer(player);
			
			//Start playing the video immediately after it has been loaded
			player.play();
		}
	}
}
