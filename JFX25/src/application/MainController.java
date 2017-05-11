package application;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

//Attn 1: new imports
import javafx.scene.control.Tooltip;

public class MainController {

	@FXML
	private LineChart<String, Number> lineChart;
	
	@FXML
	private Label label;
	
	public void loadChart(ActionEvent event){
		
		lineChart.getData().clear();
		
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Feb", 500));
		series.getData().add(new XYChart.Data<String, Number>("Mar", 300));
		series.getData().add(new XYChart.Data<String, Number>("Apr", 600));
		
		series.setName("Month Pay");
		
		lineChart.getData().add(series);
		
		/* Attn 2: Add event handler to each node for action events */
		for (final XYChart.Data<String, Number> data : series.getData()){
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				
				/* Attn 3: EventHandler is an interface, which requires handle() to be
				 * 		   implemented.
				 * 
				 * 		  To see this in action, start the app and click "Load Chart".
				 * 		  Once the chart generates, click on a data point (node) on the
				 * 		  line chart. The data values will be printed in the app.
				 */
				@Override
				public void handle(MouseEvent event){
					label.setText("X : " + data.getXValue() + "\n Y: " 
							+ String.valueOf(data.getYValue()));
					
					/* Attn 4: Code to change the tool tip when hovering over a data
					 * 		   point on the line chart.
					 * 			
					 * 		   It ToolTip.install() takes 2 arguments: 1) The node 
					 * 		   associated with the ToolTip. 2) The contents that will print
					 * 		   as description bubble that appears next to the Tooltip when the 
					 * 		   user hovers over the node.
					 * 
					 * 			Note: Bubble will only appear after the node has been clicked.
					 * 				  Due to MouseEvent looking for MOUSE_CLICKED attribute.
					 * 			      Bubble will take a few seconds to appear, be patient.
					 */
					Tooltip.install(data.getNode(), new Tooltip("X : " + data.getXValue() + "\n Y: " 
							+ String.valueOf(data.getYValue())));
				}
			});
		}
	}
}
