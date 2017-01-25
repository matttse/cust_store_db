

/**
 * @ClassName errorGettor
 * @author Matthew Tse
 * @param null
 * @return {vc} hardcoded message + badInput
 *
 */
public class errorGetter {
	
	public String getErrors(String badInput) {
		String partialInput = "You have typed invalid character(s): ";

		partialInput += badInput;
		return partialInput;
		
	}//end method
	
}//end class