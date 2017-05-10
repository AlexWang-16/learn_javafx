package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;

//Attn 3: New imports
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable{
	
	/* Attn 4: TableView describes the table itself. It takes the data type as generic argument.
	 * 		   
	 * 		   TableColumn describes each column in the table. It takes 2 arguments, the class name as 
	 * 		   first argument and the data type as the second argument.
	 * 
	 * 		   
	 */
	@FXML
	private TableView<Student> table;
	
	@FXML
	private TableColumn<Student, Integer> id;
	
	@FXML
	private TableColumn<Student, Integer> age;
	
	@FXML
	private TableColumn<Student, String> name;
	
	@FXML
	private TableColumn<Student, String> surname;
	
	/* Attn 5: Generate a list of data in memory */
	public ObservableList<Student> list = FXCollections.observableArrayList(
			new Student (1, "Mark", "Surname1", 22),
			new Student(2, "Tom", "Surname1", 23),
			new Student(2, "Ben", "Surname1", 23),
			new Student(2, "John", "Surname1", 23),
			new Student(2, "Jack", "Surname1", 23)
			);
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		/*Attn 6: A "Factory" in Java is a class that contains methods that help
		 * 		  mass generate instances of an object. Its benefit is that it can be
		 * 		  reused.
		 * 		
		 * 		  setCellValueFactory() takes an argument that describes the "rules" for how to
		 * 		  populate the data in the cells of each TableColumn, which comes in the
		 * 		  form of PropertyValueFactory.
		 * 
		 * 		  PropertyValueFactory() takes 2 generic arguments: The class of the TableView and
		 * 		  the class of the cell. The argument it takes is the name of the field in the TableView class.
		 * 		  It should return a Property instance. If it is found, it will populate all data in memory
		 * 		  based on the field specified from each instance. 
		 * 
		 * 		  In simple terms, the ValueFactory looks at each object and searches for specific field to 
		 * 		  gather data into a list. The CellValueFactory is looking for a list of items to populate under
		 *		  its specified column to generate the table.
		 */
		id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
		age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
		
		
		/* Attn 7: setItems() takes an ObservableList argument */
		table.setItems(list);
	}
}
