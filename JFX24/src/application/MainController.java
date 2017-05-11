package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

// Attn 1: new imports
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class MainController {
	@FXML
	private LineChart<String, Number> lineChart;
	
	public void loadChart(ActionEvent event){
		
		lineChart.getData().clear();

		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Feb", 500));
		series.getData().add(new XYChart.Data<String, Number>("Mar", 300));
		series.getData().add(new XYChart.Data<String, Number>("Apr", 600));
		
		series.setName("Month Pay");
		
		/* Attn 1: Adding another series, which will create a secondary line in
		 * 		   a multi-line graph. To add more lines, just add more "series".
		 */
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.getData().add(new XYChart.Data<String, Number>("Jan", 400));
		series2.getData().add(new XYChart.Data<String, Number>("Feb", 200));
		series2.getData().add(new XYChart.Data<String, Number>("Mar", 500));
		series2.getData().add(new XYChart.Data<String, Number>("Apr", 100));
		
		series2.setName("Month Pay 2");

		lineChart.getData().addAll(series, series2);

	}
}
