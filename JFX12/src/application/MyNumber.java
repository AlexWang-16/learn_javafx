package application;
import javafx.beans.property.*;

/* Attn 1: To use any JavaFX properties, we must define a class that has those properties */
public class MyNumber {
	private DoubleProperty number;

	public final double getNumber() {
		if (number != null) {
			return number.get();	//Attn 2: Read/Write properties has a get()
		}
		return 0;
	}

	public void setNumber(double number) {
		/* Attn 3: This is where JFX property comes in handy
		 * 		   We are overriding a double to set its value
		 */
		this.numberProperty().set(number);	
	}
	
	/* Attn 4: We will need a way to return JavaFX property */
	public final DoubleProperty numberProperty(){
		if (number == null) {
			number = new SimpleDoubleProperty(0);
		}
		return number;
	}
}
