package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

// Attn 1: new imports
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class MainController {
	
	// Attn 2: Declaring a variable that maps to the pie chart in Scene Builder
	@FXML
	private PieChart pieChart;
	
	/* Attn 3: Generate pie chart data in memory and storing it in an Observable List */
	public void btn(ActionEvent event){
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java",  50),
				new PieChart.Data("c++", 20),
				new  PieChart.Data("python",  30),
				new PieChart.Data("c#",  10),
				new PieChart.Data("c",  15)
				);
		// Attn 4: Add data to pie chart
		pieChart.setData(list);
	}
}
