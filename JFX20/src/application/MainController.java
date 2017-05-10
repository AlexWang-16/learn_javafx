package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

// Attn 1: new imports
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML
	private WebView webView;
	
	@FXML
	private WebEngine webEngine;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		/* Attn 2: Extracting the web engine for our webview. This engine will perform
		 * 		   rendering of all webpages.
		 */
		webEngine = webView.getEngine();
	}
	
	public void btn1(ActionEvent event){
		//Attn 3: have the web engine render a web page
		webEngine.load("https://www.google.ca");
	}
	
	public void btn2(ActionEvent event){
		// Attn 4: Have web engine render JavaScript
		webEngine.executeScript("window.location = \"Http://easyonlineconverter.com//\";");
	}
	
	public void btn3(ActionEvent event){
		// Attn 5: Have web engine to load HTML content
		webEngine.loadContent("<html><body><h1>Hello World</h1></body></html>");
	}
	
	public void btn4(ActionEvent event){
		// Attn 6: Have web engine reload the page
		webEngine.reload();
	}
}
