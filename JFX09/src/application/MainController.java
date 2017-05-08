package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/* Attn1: New imports to work with TreeView and TreeItem */
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

public class MainController implements Initializable{
	
	@FXML
	TreeView<String> treeView;
	
	/* Attn5: Loading an image asset to the project
	 * Thee last 4 parameters: 15, 15, true, true represent: width, height, preserveRatio, Smoothing. */
	Image icon = new Image(getClass().getResourceAsStream("/img/folder.png"), 15, 15, true, true);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* Attn1: TreeView is the root directory while TreeItems are analogus to sub-directories
		 * 		  It also takes an ImageView (JavaFX image container) as an argument. This allows
		 * 		  inserting an image to the node. The image referenced is the one pointed to by Attn5. */
		TreeItem<String> root = new TreeItem<>("Root", new ImageView(icon));
		
		/* Attn2: Creating nodes that fall under the tree view */
		

		TreeItem<String> nodeA = new TreeItem<>("nodeA", new ImageView(icon));
		TreeItem<String> nodeB = new TreeItem<>("nodeB", new ImageView(icon));
		TreeItem<String> nodeC = new TreeItem<>("nodeC", new ImageView(icon));
		TreeItem<String> nodeD = new TreeItem<>("nodeD", new ImageView(icon));
		TreeItem<String> nodeE = new TreeItem<>("nodeE", new ImageView(icon));
		TreeItem<String> nodeF = new TreeItem<>("nodeF", new ImageView(icon));
		
		TreeItem<String> subnode1 = new TreeItem<>("subnode1", new ImageView(icon));
		TreeItem<String> subnode2 = new TreeItem<>("subnode2", new ImageView(icon));
		TreeItem<String> subnode3 = new TreeItem<>("subnode3", new ImageView(icon));
		
		/* Attn3: Adding the nodes to the root */
		
		//Add a single item
		root.getChildren().add(nodeA);
		
		//Adding subnodes
		nodeD.getChildren().add(subnode1);
		nodeE.getChildren().add(subnode2);
		nodeF.getChildren().add(subnode3);
		
		//Add multiple items
		root.getChildren().addAll(nodeB, nodeC, nodeD, nodeE, nodeF);
		
		/*Attn4: Adding the root and its nodes to the tree view */
		treeView.setRoot(root);
	}

}
