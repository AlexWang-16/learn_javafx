package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

// Attn 1: new imports
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class MainController {
	/* Attn 2: LineChart is a generic type that takes the data type of the X-axis
	 * 		   and the data type of the Y-axis. In the case below, the X-axis is String
	 * 		   and Y-axis is Number.
	 */
	@FXML
	private LineChart<String, Number> lineChart;
	
	public void loadChart(ActionEvent event){
		
		/* Attn 3: Clear the chart first to avoid line overlaps when user clicks on button
				   multiple times */
		lineChart.getData().clear();
		
		/* Attn 4: XYChart is the base class for all 2 axis charts.
		 * 		   XYChart.Series means a list of data items for an XYChart stored 
		 * 		   in tandem, like a 1-D array.
		 * 
		 * 		   We use getData() on the series because it will return an observable list.
		 * 		   This allows us to add data to the series. We cannot use series.getData().addAll()
		 * 		   because the data type we are adding is generics that takes 2 generic type arguments.
		 * 		   Type safety cannot be ensured and will result in warnings.
		 */
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Feb", 500));
		series.getData().add(new XYChart.Data<String, Number>("Mar", 300));
		series.getData().add(new XYChart.Data<String, Number>("Apr", 600));
		
		series.setName("Month Pay");
		
		// Attn 5: Adding data in memory to the line chart
		lineChart.getData().add(series);
		
		/* Attn 6: See "CategoryAxis" (X-axis) and "NumberAxis" (Y-axis) tag in FXML file for 
		 * 		   how to set labels for each axis. */
	}
}
