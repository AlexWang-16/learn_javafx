package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;

/* Attn1: new imports */
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.util.List; //Handles a list of files in multi file selection


public class MainController {
	@FXML
	private Button oneFile;
	
	@FXML
	private Button multiFile;
	
	@FXML
	private ListView<String> listView; //Generics necessary to handle displaying file names and absolute paths
	
	public void selectOneFile(ActionEvent event) {
		FileChooser fc = new FileChooser();
		/* Attn2: Setting initial directory. Note that the path must be the absolute path from root
		 * or it will not work. *
		 */
		fc.setInitialDirectory(new File("/Users/awang05/Desktop"));
		
		//Attn3: Enforces file type restriction in file chooser
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF", "*.pdf"));
		
		/* Attn4: showOpenDialog() takes the stage as an argument. If provided, all actions
				  on the window will be blocked until the file chooser appears. If this behavior
				  is not desired, set it to null as shown below. 
				  
				  It returns the file the user selects or NULL if no file is selected.*/
		File selectedFile = fc.showOpenDialog(null);
		
		if (selectedFile != null){
			/* Attn5: Adding the name of the file to the ListView. We can change getName()
			 * to something else, depending on the type of information you wish to retrieve
			 * from the file chooser.
			 */
			listView.getItems().add(selectedFile.getName());
		}else{
			System.out.println("No file selected");
		}
	}
	
	public void selectMultiFile(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("/Users/awang05/Desktop"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF", "*.pdf"));
		
		/* Attn6: For multiple file select, you need to use showOpenMultipleDialog().
		 * 		  It also returns a List<File> */
		List<File> selectedFile = fc.showOpenMultipleDialog(null);
		
		if(selectedFile != null){
			for (File file : selectedFile){
				listView.getItems().addAll(file.getAbsolutePath());
			}
		}else{
			System.out.println("No file(s) selected");
		}
	}
}
