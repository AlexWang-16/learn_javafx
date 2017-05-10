package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;

// Attn 1: new imports
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
public class MainController {
	
	@FXML
	private PieChart pieChart;
	
	@FXML
	private Label status;
	
	public void btn(ActionEvent event){
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java",  50),
				new PieChart.Data("c++", 20),
				new  PieChart.Data("python",  30),
				new PieChart.Data("c#",  10),
				new PieChart.Data("c",  15)
				);
		pieChart.setData(list);
		
		/* Attn 2: It is possible to iterate through a PieChart. The enhanced for loop
		 * interprets the data as "PieChart.data" type.
		 * 
		 * The code then adds an event handler that listens for a mouse click to each
		 * piece on the PieChart. When it is pressed, it will set the label with its
		 * own percentage value.
		 */
		for (final PieChart.Data data : pieChart.getData()){
			
			/* Attn 3: addEventHandler takes 2 arguments: 1) The type of event that
			 * 		   acts as the trigger to look for 2) the implementation of the event handler
			 * 		   which includes the implemented handle() method.
			 */
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event){
					status.setText(String.valueOf(data.getPieValue()) + " %");
				}
			});
		}
	}
}
