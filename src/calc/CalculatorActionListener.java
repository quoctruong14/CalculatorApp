/*
 * Given the User Interface provided, complete the functionality of the Calculator
to be able to perform these operations:
+ addition
- subtraction
x multiplication
/ division
% modulo (reminder)
+/- changing sign (from plus to minus and minus to plus)
C clear entry

The program will append to the first operand while entering numeric keys (0-9),
get the first operand when and operator key (+, -, x ,/ ) is pressed ,
get the second operand when the = key is pressed,
then compute the operation and display.

To get the value of a JTextField, use: textField.getText(),
to set its value, use: textField.setText()
 */
package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalculatorActionListener implements ActionListener{
	String value1, value2;
	String operator;

	private JTextField textField;

	public CalculatorActionListener(JTextField textField) {
		this.textField = textField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent: " + e.getActionCommand());
		
		switch (e.getActionCommand()) {
		
			case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":

				// Set Value1 from null
				if((value1 == null) && (value2 == null)) {
					value1 = "" + e.getActionCommand();
					textField.setText(value1);
				}
				
				// Set Value2 from null
				else if((value2 == null) && (operator != null)) {
					value2 = "" + e.getActionCommand();
					textField.setText(value2);
				}
				
				else if((value1 != null) && (operator == null)) {
					value1 += e.getActionCommand();
					textField.setText(value1);
				}
				
				else {
					value2 += e.getActionCommand();
					textField.setText(value2);
				}
				break;
				
			case "+": case "-":	case "x": case "/": case "%":
				operator = e.getActionCommand();
				textField.setText(operator);
				break;
				
			case "U":
				
				if(value1 == null && value2 == null) {
					textField.setText("");
					break;
				}
				
				// Update first value
				if(value1 != null && value2 == null) {
					if(value1.contains("-")) {
						value1 = value1.substring(1);
						textField.setText(value1);
					}
					else {
						value1 = "-" + value1;
						textField.setText(value1);
					}
				}
				
				// Update second value
				else {
					if(value2.contains("-")) {
						value2 = value2.substring(1);
						textField.setText(value2);
					}
					else {
						value2 = "-" + value2;
						textField.setText(value2);
					}
				}
				
				break;
				
			case "C":
				textField.setText("");
				value1 = null;
				value2 = null;
				operator = null;
				break;
				
			case "=":
				String solution;
				
				switch(operator) {
				case "+":
					solution = Integer.toString(Integer.parseInt(value1) + Integer.parseInt(value2));
					textField.setText(solution);
					value1 = solution;
					value2 = null;
					operator = null;
					break;
				case "-":
					solution = Integer.toString(Integer.parseInt(value1) - Integer.parseInt(value2));
					textField.setText(solution);
					value1 = solution;
					value2 = null;
					operator = null;
					break;
				case "x":
					solution = Integer.toString(Integer.parseInt(value1) * Integer.parseInt(value2));
					textField.setText(solution);
					value1 = solution;
					value2 = null;
					operator = null;
					break;
				case "/":
					
					if(value2.equals("0")) {
						textField.setText("Error: Not a number");
						value1 = null;
						value2 = null;
						operator = null;
					}
					else {
						solution = Integer.toString(Integer.parseInt(value1) / Integer.parseInt(value2));
						textField.setText(solution);
						value1 = solution;
						value2 = null;
						operator = null;
					}
					
					break;
				case "%":
					if(value2.equals("0")) {
						textField.setText("Error: Modding by 0");
						value1 = null;
						value2 = null;
						operator = null;
					}
					else {
					solution = Integer.toString(Integer.parseInt(value1) % Integer.parseInt(value2));
					textField.setText(solution);
					value1 = solution;
					value2 = null;
					operator = null;
					break;
					}
				}
				break;
		}
		
	}
	
}