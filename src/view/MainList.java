package view;
import model.SessionList;
import dhl.UserInputHandler;



/**
 * @ClassName MainList
 * @author Matthew Tse
 *
 */
public class MainList {

	//Main method
    public static void main (String [] args)
    {
    	
    	//initialize and declare global vars
    	int completeFlag	= 0;
    	String optionOne	= "(1) Add a customer";
    	String optionTwo	= "(2) Remove a customer";
    	String optionThree	= "(3) Update age";
    	String optionFour	= "(4) Update income";
    	String optionFive	= "(5) Update credit score";
    	String optionSix	= "(6) Display all customers";
    	String optionZero	= "(0) Exit the program";
    	String option		= "";
    	String name			= "";
    	String custId		= "";
    	int nameLength		= 0;
    	String itemIdxs		= "";
    	String custDetail	= "";    	
    	int age				= 0;
    	double income		= 0;
    	int cScore			= 0;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //instantiate the session cart
        SessionList admList = new SessionList();
        
        //Option selector
    	while (completeFlag == 0) {
    		
    		System.out.println("Please select an option.");
    		
    		option = processInput.getNum(
    					(optionOne.concat("\t")
    						.concat(optionTwo).concat("\n")
    						.concat(optionThree).concat("\t")
    						.concat(optionFour).concat("\n")
    						.concat(optionFive).concat("\t")
    						.concat(optionSix).concat("\n")
    						.concat(optionZero).concat("\t"))
    						, 0);
    		
    		int select = Integer.parseInt(option);
    		
    		//Valid options
    		if (select > 6 || select < 0) {
    			
    			System.out.print("Please select a valid option");
    		//Add customer
    		} else if (select == 1) {
    	      	//Prompt the user for customer id input 
    	        custId = String.valueOf(processInput.getNum("Enter customer id: ", 1));
    	        
    	        //check against blank entries
    	        if (custId.length() == 0) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	custId = String.valueOf(processInput.getNum("Enter customer id: ", 1));
    	        	
    	        } else {
    	        	
    	            //Prompt the user for first name input
    	            while (nameLength == name.length()){

    	    	        name += processInput.getString("Enter first name (i.e. Matthew): ");
    	    	        
    	    	        if (nameLength == name.length()) {
    	    	        	
    	    	        	System.out.println("You did not enter anything. Please Try again.");
    	    	        	
    	    	        }
    	    	        
    	            }
    	                    
    	            name += " ";
    	            nameLength = name.length();

    	            //Prompt the user for last name input
    	            while (nameLength == name.length()){

    	    	        name += processInput.getString("Enter last name (i.e. Tse): ");
    	    	        
    	    	        if (nameLength == name.length()) {
    	    	        	
    	    	        	System.out.println("You did not enter anything. Please Try again.");
    	    	        	
    	    	        }
    	    	        
    	            }
    	            
    	            custDetail += name + ",";
    	            System.out.println(name);
    	            
        	       	//Prompt the user for age input 
        	        age = Integer.parseInt(processInput.getNum("Enter age (i.e. 30): ", 1));
        	        
        	        //check against blank entries
        	        if (age == 0) {
        	        	
        	        	System.out.println("You did not enter anything. Please Try again.");
        	        	age = Integer.parseInt(processInput.getNum("Enter age (i.e. 30):  ", 1));
        	        	
        	        } else {
        	            
        	            System.out.println("Customer age is ".concat(String.valueOf(age)));
        	            
        	        }
        	        
        	        custDetail += age + ",";
        	        
        	       	//Prompt the user for income input 
        	        income = Double.parseDouble(processInput.getNum("Enter income (i.e. 30000): ", 1));
        	        
        	        //check against blank entries
        	        if (age == 0) {
        	        	
        	        	System.out.println("You did not enter anything. Please Try again.");
        	        	income = Double.parseDouble(processInput.getNum("Enter income (i.e. 30000):  ", 1));
        	        	
        	        } else {
        	            
        	            System.out.println("Customer income is ".concat(String.valueOf(income)));
        	            
        	        }
        	        
        	        custDetail += income + ",";
        	        
        	       	//Prompt the user for credit score input 
        	        cScore = Integer.parseInt(processInput.getNum("Enter credit score (i.e. 800): ", 1));
        	        
        	        //check against blank entries
        	        if (cScore == 0) {
        	        	
        	        	System.out.println("You did not enter anything. Please Try again.");
        	        	cScore = Integer.parseInt(processInput.getNum("Enter credit score (i.e. 750):  ", 1));
        	        	
        	        } else {
        	            
        	            System.out.println("Customer credit score is ".concat(String.valueOf(cScore)));
        	            
        	        }
        	        
        	        custDetail += cScore;
        	        
        	        if (admList.addCustomer(custDetail) == true) {
        	        	System.out.println("Success");
        	        } else {
        	        	System.out.println("Could not add customer.");
        	        	
        	        }
        	        
        	        
        	                	        
    	        }
    	     
    		//Display all customers
    		} else if (select == 6) {
    			    			
    			if (admList.showCustomers() == null) {
    				
    				System.out.println("You do not have any customers stored.");
    				
    			} else {
        	        //show customer list
    				//TODO add customer array
//    				admList.showCustomers(custDetail.split(","));
    				
    			}
    			
    			
    			
    			//exit menu flag
//    			completeFlag = 1;
    		
    		//Process options
    		} else {
    			
    	        if (select == 0) {
    	        	
    	        	System.out.println("Thank you and goodbye");
    	        	exit(0);
    	        	
		
    			}//end if processing options
    		
    		}//end if valid menu options
    		
    	}//end Option menu
    	
    	System.out.println("Thank you, Goodbye.");
    	exit(0);
       
        
    }//end main method
        
    //standard system exit.
	public static void exit(int status) {
		System.exit(status);
		return;
	}

}

