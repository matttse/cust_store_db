package dhl;

/**
 * @ClassName InputValidator
 * @Author Matthew Tse
 * @SubClass ErrorGettor
 * @Method validate
 * @Method validateNum
 * @Method validateString
 *
 */
public class InputValidator {

	// Global var declarations
	private String validationErrors = "";

	/*
	 * @Name: validate
	 * 
	 * @Function/Purpose: Validates any user input based on type, checks for
	 * invalid characters and informs them of errors. Also calls method
	 * confirm()
	 * 
	 * @Parameters:
	 * 		{vc} input
	 * 		{i4} flag
	 * 		{i4} typeFlag (i.e. 0 = String)
	 * 
	 * @Additionl Comments: All input must be passed as a string. Flags: 0 =
	 * String 1 = int 2 = double
	 * 
	 * @Return true/false based on valid and confirmed entry of userInput
	 */
	public boolean validate(String userInput, int flag, int typeFlag) {
		boolean validInput = false;

		switch (flag) {

		case 0:
			validInput = validateString(userInput);
			break;

		case 1:
			validInput = validateNum(userInput, typeFlag);
			break;
		
		case 2:
			validInput = validAlphaNum(userInput);
			break;
			
		default:

			validInput = false;
			break;

		}

		return validInput;

	}// end method

	/*
	 * @Name: validateString
	 * 
	 * @Function/Purpose: Validates string input
	 * 
	 * @Parameters: {vc} String input
	 * 
	 * @Additionl Comments: called from validate method
	 * 
	 * @Return true/false based on valid 
	 */
	public boolean validAlphaNum(String userInput) {
		boolean validInput = false;
		String badChars = "";
		String processInput = "";

		for (int charCnt = 0; userInput.length() > charCnt; charCnt++) {

			// iterate over each char in input
			char charac = userInput.charAt(charCnt);

			// look for valid alphabetical values (a-z/A-Z/0-9)
			if ((charac > 64 && charac < 91) || (charac > 96 && charac < 123) || (charac > 47 && charac < 58)) {

				processInput += userInput.substring(charCnt, charCnt + 1);
				// Valid case
				validInput = true;

			} else if (charac == 32) {

				processInput = userInput.replaceAll("\\s", "");

			} else {

				// Invalid char a-z/A-Z
				badChars += userInput.substring(charCnt, charCnt + 1);
				validInput = false;

			}

		} // end for loop

		if (badChars != "") {

			// instantiate getErrors to get bad string if necessary
			ErrorGetter getErrors = new ErrorGetter();

			validationErrors = getErrors.getErrors(badChars);

			System.out.println(validationErrors);

			validInput = false;

		} else {

			// return true
			validInput = true;

		}

		return validInput;

	}// end method
	
	/*
	 * @Name: validateString
	 * 
	 * @Function/Purpose: Validates string input
	 * 
	 * @Parameters: {vc} String input
	 * 
	 * @Additionl Comments: called from validate method
	 * 
	 * @Return true/false based on valid 
	 */
	public boolean validateString(String userInput) {
		boolean validInput = false;
		String badChars = "";
		String processInput = "";

		for (int charCnt = 0; userInput.length() > charCnt; charCnt++) {

			// iterate over each char in input
			int charac = (int) userInput.charAt(charCnt);

			// look for valid alphabetical values (a-z/A-Z)
			if ((charac > 64 && charac < 91) || (charac > 96 && charac < 123)) {

				processInput += userInput.substring(charCnt, charCnt + 1);
				// Valid case
				validInput = true;

			} else if (charac == 32) {

				processInput = userInput.replaceAll("\\s", "");

			} else {

				// Invalid char a-z/A-Z
				badChars += userInput.substring(charCnt, charCnt + 1);
				validInput = false;

			}

		} // end for loop

		if (badChars != "") {

			// instantiate getErrors to get bad string if necessary
			ErrorGetter getErrors = new ErrorGetter();

			validationErrors = getErrors.getErrors(badChars);

			System.out.println(validationErrors);

			validInput = false;

		} else {

			// return true
			validInput = true;

		}

		return validInput;

	}// end method
	
	/*
	 * @Name: validateNum
	 * 
	 * @Function/Purpose: Validates number input
	 * 
	 * @Parameters:
	 * 		{vc} String input
	 * 		{i4} flag
	 * @Additionl Comments: called from validate method
	 * 
	 * @Return true/false based on valid 
	 */
	public boolean validateNum(String userInput, int flag) {
		boolean validInput = false;

		switch (flag) {
		case 0:
			try {

				int chkInt = Integer.parseInt(userInput);
				validInput = true;

			} catch (NumberFormatException nfe) {

				System.out.println("You typed an invalid character, please try again.");
				validInput = false;

			}
			break;

		case 1:

			try {

				Float chkFloat = Float.parseFloat(userInput);
				validInput = true;

			} catch (NumberFormatException nfe) {

				System.out.println("You typed an invalid character, please try again.");
				validInput = false;

			}
			break;

		case 2:

			try {

				Double chkDouble = Double.parseDouble(userInput);
				validInput = true;

			} catch (NumberFormatException nfe) {

				System.out.println("You typed an invalid character, please try again.");
				validInput = false;

			}
			break;

		default:
			validInput = false;
			break;
		}

		return validInput;

	}// end method

	/**
	 * @ClassName errorGettor
	 * @author Matthew Tse
	 * @param null
	 * @return {vc} hardcoded message + badInput
	 *
	 */
	public class ErrorGetter {

		public String getErrors(String badInput) {
			String partialInput = "You have typed invalid character(s): ";

			partialInput += badInput;
			return partialInput;

		}// end method

	}// end class

}// end class
