package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/* Controllers are decision makers. They redirect traffic from the view (user) to the model 
 * and sends the results back out to the view for presentation to the user.
 */
public class MainController {
	
	@FXML
	private Label result;
	private long number1;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model(); //Create an instance of model to invoke its method for data processing
	
	@FXML
	public void processNumbers(ActionEvent event){
		if (start){
			result.setText("");
			start = false;
		}
		
		/* Getting the value of the button pressed.
		 * getSource() will return the object that triggered the event.
		 * We will then type cast it as a button and retrieve its text value */
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
	}
	
	@FXML
	public void processOperators(ActionEvent event){
		String value = ((Button)event.getSource()).getText();
		
		if (!value.equals("=")){
			if(!operator.isEmpty()){
				return;
			}
			
			operator = value;
			number1 = Long.parseLong(result.getText());
			result.setText("");
		}
		else{
			if(operator.isEmpty()){
				return;
			}
			long number2 = Long.parseLong(result.getText());
			float output = model.calculate(number1, number2, operator);
			result.setText(String.valueOf(output));
			operator = "";
			start = true;
		}
	}	
	
	@FXML
	public void allClear(){
		operator = "";
		number1 = 0;
		result.setText("");
	}
}
