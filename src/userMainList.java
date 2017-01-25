
/**
 * 
 */

/**
 * @ClassName userMainList
 * @author Matthew Tse
 *
 */
public class userMainList {

	//Main method
    public static void main (String [] args)
    {
    	
    	//initialize and declare global vars
    	int checkoutFlag	= 0;
    	String optionOne	= "(1) Add a customer";
    	String optionTwo	= "(2) Remove a customer";
    	String optionThree	= "(3) Update age";
    	String optionFour	= "(4) Update income";
    	String optionFive	= "(5) Update credit score";
    	String optionSix	= "(6) Display all customers";
    	String optionZero	= "(0) Exit the program";
    	String option		= "";
    	String name			= "";
    	String cust_id		= "";
    	int nameLength		= 0;
    	String itemIdxs		= "";
    	float age;;
    	float runTotal		= 0.0f;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //instantiate the session cart
        custSessionList admList = new custSessionList();
        
       	//Prompt the user for first input 
        cust_id = processInput.getString("Enter customer id: ");
        
        //check against blank entries
        if (cust_id.length() == 0) {
        	
        	System.out.println("You did not enter anything. Please Try again.");
        	name = processInput.getString("Enter customer id: ");
        	
        } else {
        	
            
            System.out.println(name);
            
            name += " ";
            nameLength = name.length();

            //Prompt the user for second input
            while (nameLength == name.length()){

    	        name += processInput.getString("Enter first name (i.e. Matthew): ");
    	        
    	        if (nameLength == name.length()) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	
    	        }
    	        
            }
            
            System.out.println(name);
            
            name += " ";
            nameLength = name.length();

            //Prompt the user for third input
            while (nameLength == name.length()){

    	        name += processInput.getString("Enter last name (i.e. Tse): ");
    	        
    	        if (nameLength == name.length()) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	
    	        }
    	        
            }
            System.out.println(name);
        }
        
       	//Prompt the user for first input 
        age = Float.parseFloat(processInput.getNum("Enter age (i.e. 30): ", 1));
        
        //check against blank entries
        if (age == 0) {
        	
        	System.out.println("You did not enter anything. Please Try again.");
        	age = Float.parseFloat(processInput.getNum("Enter age (i.e. 30):  ", 1));
        	
        } else {
            
            System.out.println("Your age is ".concat(String.valueOf(age)));
            
        }
     
        
    	while (checkoutFlag == 0) {
    		
    		System.out.println("Please select an option.");
    		
    		option = processInput.getNum(
    					(optionOne.concat("\t")
    						.concat(optionTwo).concat("\n")
    						.concat(optionThree).concat("\t")
    						.concat(optionFour).concat("\n")
    						.concat(optionFive).concat("\n")
    						.concat(optionSix).concat("\n")
    						.concat(optionZero).concat("\n"))
    						, 0);
    		
    		int select = Integer.parseInt(option);
    		
    		//Valid options
    		if (select > 6 || select < 0) {
    			
    			System.out.print("Please select a valid option");
    		
    		//Checkout option
    		} else if (select == 3) {
    			
//    			String displayPurchases = "";
    			
    			if (admList.mappedItems.isEmpty() == true) {
    				
    				System.out.println("You do not have any customers stored.");
    				
    			} else {
        	        
//    				displayPurchases = admList.completePurchase(itemIdxs, runTotal);
    				admList.completePurchase(itemIdxs, age);
    				
//    				System.out.println(displayPurchases);
    				
    			}
    			
    			
    			
    			//exit menu flag
    			checkoutFlag = 1;
    		
    		//Process options
    		} else {
    			
    	        if (select == 0) {
    	        	
    	        	System.out.println("Thank you and goodbye");
    	        	exit(0);
    	        	
		
    			}//end if processing options
    		
    		}//end if valid options
    		
    	}//end while order checkout
    	
    	System.out.println("Thank you for your order");
    	exit(0);
       
        
    }//end main method
        
    //standard system exit.
	public static void exit(int status) {
		System.exit(status);
		return;
	}

}

