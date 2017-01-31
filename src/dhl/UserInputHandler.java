package dhl;

/**
 * @ClassName UserInputHandler
 * @author Matthew Tse
 * @Method confirmInput
 * @Method exit
 * @Method getMatchedItems
 * @Method getString
 * @Method getNum
 * @Method processOutput
 *
 */

import java.util.Scanner;

public class UserInputHandler {

	// Declare and initialize global variables
	private Scanner keyboardInput;
	private String outputText;

	public UserInputHandler() {

		keyboardInput = new Scanner(System.in);

	}
	
	/*
	 * @Name: getAlphaNum
	 * 
	 * @Function/Purpose: gets an alphanumeric value
	 * 
	 * @Parameters: {vc} input
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: {vc} output text
	 * 
	 */
	public String getAlphaNum(String inputString) {
		boolean valid = false;
		int tryCnt = 0;
		InputValidator validateInput = new InputValidator();
		System.out.println(inputString);

		while (valid != true && tryCnt < 3) {

			String input = keyboardInput.nextLine();

			// iterate over input checking to make sure each char is Aa-Zz-0-9
			valid = validateInput.validate(input, 2, 0);

			if (valid == true) {

				outputText = processOutput(input);

			} else {

				System.out.println("Please try again.");
				tryCnt++;

			}

		} // end while

		if (valid != true) {
			// fail case
			outputText = "You have tried too many times. Please start over.";
		}

		return outputText;

	}// end method

	/*
	 * @Name: getString
	 * 
	 * @Function/Purpose: gets a string value
	 * 
	 * @Parameters: {vc} string of number
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: {vc} output text
	 * 
	 */
	public String getString(String inputString) {
		boolean valid = false;
		int tryCnt = 0;
		InputValidator validateInput = new InputValidator();
		System.out.println(inputString);

		while (valid != true && tryCnt < 3) {

			String input = keyboardInput.nextLine();

			// iterate over input checking to make sure each char is Aa-Zz
			valid = validateInput.validate(input, 0, 0);

			if (valid == true) {

				outputText = processOutput(input);

			} else {

				System.out.println("Please try again.");
				tryCnt++;

			}

		} // end while

		if (valid != true) {
			// fail case
			outputText = "You have tried too many times. Please start over.";
		}

		return outputText;

	}// end method

	/*
	 * @Name: getNum
	 * 
	 * @Function/Purpose: gets a numerical value
	 * 
	 * @Parameters: string of number, flex the type flag
	 * 
	 * @Additional Comments: flags are defined in inputValidator (0 = integer, 1
	 * = float, 2 = double)
	 * 
	 * @Return: string
	 * 
	 */
	public String getNum(String inputString, int typeFlag) {
		boolean valid = false;
		int tryCnt = 0;
		InputValidator validateInput = new InputValidator();
		System.out.println(inputString);

		while (valid != true && tryCnt < 3) {

			String input = keyboardInput.nextLine();

			// iterate over input checking to make sure each position is 0-9
			valid = validateInput.validate(input, 1, typeFlag);

			if (valid == true) {

				outputText = processOutput(input);

			} else {

				System.out.println("Please try again.");
				tryCnt++;

			}

		} // end while

		if (valid != true) {
			// fail case
			outputText = "You have tried too many times. Please restart.";
		}

		return outputText;

	}// end method

	/*
	 * @Name: processOutput
	 * 
	 * @Function/Purpose: removes whitespace from a string
	 * 
	 * @Parameters: string
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: string
	 * 
	 */
	public String processOutput(String processInput) {
		String processOuput;

		processOuput = processInput.replaceAll("\\s", "");

		return processOuput;
	}

	/*
	 * @Name: getMatchedItems
	 * 
	 * @Function/Purpose: cloned equals method
	 * 
	 * @Parameters: Float[] and a pre-defined number of numbers
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: boolean
	 * 
	 */
	public boolean getMatchedItems(String list, String compareValue) {
		// default to return match
		boolean validVal = false;
		String custDetails[] = list.split(",");

		for (int idx = 0; idx < custDetails.length; idx++) {

			if (custDetails[idx].equals(compareValue)) {
				validVal = true;
				break;
			} else {
				validVal = false;

			}

		}

		return validVal;
	}// end method

	/*
	 * @Name: confirmInput
	 * 
	 * @Function/Purpose: asks the user to confirm input
	 * 
	 * @Parameters: null
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: boolean
	 * 
	 */
	public boolean confirmInput() {
		int confirmCntTry = 0;
		boolean valid = false;
		String confirmMsg = "Is this correct (yes/no): ";

		while (confirmCntTry < 3) {

			System.out.println(confirmMsg);
			String confirmInput = keyboardInput.nextLine();

			if ("yes".equalsIgnoreCase(confirmInput) || "y".equalsIgnoreCase(confirmInput)) {

				confirmCntTry = 3;
				valid = true;

			} else if ("no".equalsIgnoreCase(confirmInput) || "n".equalsIgnoreCase(confirmInput)) {

				confirmCntTry = 3;
				valid = false;

			} else {

				String outputMsg = "Please type in yes or no. (Number of tries left: ";
				System.out.print(outputMsg);
				System.out.print(2 - confirmCntTry);
				System.out.println(")");

			}
			confirmCntTry++;

			if (confirmCntTry == 3) {
				exit(0);
			}

		}

		return valid;

	}// end method

	// standard system exit.
	public void exit(int status) {
		System.exit(status);
		return;
	}
}// end class
