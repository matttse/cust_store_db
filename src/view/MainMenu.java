package view;
import model.CustomerList;
import dhl.UserInputHandler;



/**
 * @ClassName MainList
 * @author Matthew Tse
 *
 */
public class MainMenu {

	//Main method
    public static void main (String [] args) {
    	
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
    	
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //instantiate the session cart
        CustomerList admList = new CustomerList(null);
        
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
    	    	String custId		= "";
    			String custDetail	= ""; 
    	    	String Lname		= "";
    	    	String Fname		= "";
    	    	int age				= 0;
    	    	double income		= 0;
    	    	int cScore			= 0;
    	    	int fNameLength		= 0;
    	    	int lNameLength		= 0;
    			
    	      	//Prompt the user for customer id input 
    	        custId = String.valueOf(processInput.getNum("Enter customer id: ", 1));
    	        
    	        //check against blank entries
    	        while (custId.length() == 0) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	custId = String.valueOf(processInput.getNum("Enter customer id: ", 1));
    	        	
    	        }//end while custID length check
    	        //append result
    	        custDetail += custId + ",";
    	        	
	            //Prompt the user for first name input
	            while (Fname.length() == 0){

	            	Fname += processInput.getString("Enter first name (i.e. Matthew): ");
	    	        
	    	        if (fNameLength == Fname.length()) {
	    	        	
	    	        	System.out.println("You did not enter anything. Please Try again.");
	    	        	
	    	        }
	    	        
	            }//end while first name length check
	            //append result        
	            custDetail += Fname + ",";

	            //Prompt the user for last name input
	            while (Lname.length() == 0){

	            	Lname += processInput.getString("Enter last name (i.e. Tse): ");
	    	        
	    	        if (lNameLength == Lname.length()) {
	    	        	
	    	        	System.out.println("You did not enter anything. Please Try again.");
	    	        	
	    	        }
	    	        
	            }//end while last name length check
	            //append result
	            custDetail += Lname + ",";
	            //display input
	            System.out.println(Fname + " " + Lname);
	            
    	       	//Prompt the user for age input 
    	        age = Integer.parseInt(processInput.getNum("Enter age (i.e. 30): ", 1));
    	        
    	        //check against blank entries
    	        while (age <= 0) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	age = Integer.parseInt(processInput.getNum("Enter age (i.e. 30):  ", 1));
    	        	
    	        } //end while age check

	            //append result
	            custDetail += age + ",";
    	        //display result    
	            System.out.println("Customer age is ".concat(String.valueOf(age)));   	            
    	      
    	       	//Prompt the user for income input 
    	        income = Double.parseDouble(processInput.getNum("Enter income (i.e. 30000): ", 1));
    	        
    	        //check against blank entries
    	        while (income == 0) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	income = Double.parseDouble(processInput.getNum("Enter income (i.e. 30000):  ", 1));
    	        	
    	        }//end while income check 

	            //update temp input
    	        custDetail += income + ",";
    	        //display result
	            System.out.println("Customer income is ".concat(String.valueOf(income)));    

    	       	//Prompt the user for credit score input 
    	        cScore = Integer.parseInt(processInput.getNum("Enter credit score (i.e. 800): ", 1));
    	        
    	        //check against blank entries
    	        while (cScore == 0) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	cScore = Integer.parseInt(processInput.getNum("Enter credit score (i.e. 750):  ", 1));
    	        	
    	        }//end credit score check  
    	        
	            //update temp input
	            custDetail += cScore;
    	        //display result
	            System.out.println("Customer credit score is ".concat(String.valueOf(cScore)));   

	            //add customer
    	        if (admList.addCustomer(custDetail) == true) {
    	        	System.out.println("Success");

    	        } else {
    	        	System.out.println("Could not add customer.");
    	        	
    	        }
    	     
    		//Display all customers
    		} else if (select == 6) {
    			    			
    			if (admList.showCustomers() == false) {
    				
    				System.out.println("You do not have any customers stored.");
    				
    			} else {
        	        //show customer list
    				//TODO add customer array
//    				admList.showCustomers(custDetail.split(","));
    				admList.showCustomers();
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

