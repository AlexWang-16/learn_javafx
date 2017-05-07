package application;

/* Model is where data processing occurs. In this case, the logic of math calculations */
public class Model {
	public float calculate(long number1, long number2, String operator){
		switch(operator){
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			if (number2 == 0){
				return 0;
			}
			return number1 / number2;
		default:
			return 0;
		}
	}
}
