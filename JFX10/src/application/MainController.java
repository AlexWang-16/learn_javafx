package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

/* Attn1: new import to support mouse events */
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable{
	
	@FXML
	TreeView<String> treeView;
	
	Image icon = new Image(getClass().getResourceAsStream("/img/folder.png"), 15, 15, true, true);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> root = new TreeItem<>("Root", new ImageView(icon));
		
		/* Attn2: To have a node expanded by default use the following setting */
		root.setExpanded(true);

		TreeItem<String> nodeA = new TreeItem<>("nodeA", new ImageView(icon));
		TreeItem<String> nodeB = new TreeItem<>("nodeB", new ImageView(icon));
		TreeItem<String> nodeC = new TreeItem<>("nodeC", new ImageView(icon));
		TreeItem<String> nodeD = new TreeItem<>("nodeD", new ImageView(icon));
		TreeItem<String> nodeE = new TreeItem<>("nodeE", new ImageView(icon));
		TreeItem<String> nodeF = new TreeItem<>("nodeF", new ImageView(icon));
		
		TreeItem<String> subnode1 = new TreeItem<>("subnode1", new ImageView(icon));
		TreeItem<String> subnode2 = new TreeItem<>("subnode2", new ImageView(icon));
		TreeItem<String> subnode3 = new TreeItem<>("subnode3", new ImageView(icon));
		
		root.getChildren().add(nodeA);
		
		nodeD.getChildren().add(subnode1);
		nodeE.getChildren().add(subnode2);
		nodeF.getChildren().add(subnode3);
		
		root.getChildren().addAll(nodeB, nodeC, nodeD, nodeE, nodeF);
		
		treeView.setRoot(root);
	}
	
	/* Attn3: This method will print the name of the node that is clicked by the user
	 * In Scene Builder, you must select the TreeView and add this method 
	 * "On Mouse Clicked" for it to work*/
	public void mouseClick(MouseEvent mouseEvent){
		// Attn4: Only perform logic below when a double click is registered
		if (mouseEvent.getClickCount() == 2){ 
			TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
			System.out.println(item.getValue());
		}
	}

}
