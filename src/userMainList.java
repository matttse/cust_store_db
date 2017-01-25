//import cust_store_db.MySessionCart;
//import cust_store_db.UserInputHandler;

/**
 * 
 */

/**
 * @author think-Matt
 *
 */
public class userMainList {

	//Main method
    public static void main (String [] args)
    {
    	
    	//initialize and declare global vars
    	int checkoutFlag	= 0;
    	String optionOne	= "(1) View Items in Cart";
    	String optionTwo	= "(2) Add Items to Cart";
    	String optionThree	= "(3) Purchase/Checkout";
    	String optionFour	= "(4) Show Menu Items";
    	String optionFive	= "(5) Show Current Total and amount left in budget";
    	String optionZero	= "(0) Exit the program";
    	String option		= "";
    	String name			= "";
    	int nameLength		= 0;
    	String itemIdxs		= "";
    	Float budget		= 0.0f;
    	Float runTotal		= 0.0f;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //instantiate the session cart
        MySessionCart userCart = new MySessionCart();
        
       	//Prompt the user for first input 
        name = processInput.getString("Please enter first name (i.e. Matthew): ");
        
        //check against blank entries
        if (name.length() == 0) {
        	
        	System.out.println("You did not enter anything. Please Try again.");
        	name = processInput.getString("Please enter first name (i.e. Matthew): ");
        	
        } else {
        	
            
            System.out.println(name);
            
            name += " ";
            nameLength = name.length();

            //Prompt the user for second input
            while (nameLength == name.length()){

    	        name += processInput.getString("Please enter last name (i.e. Tse): ");
    	        
    	        if (nameLength == name.length()) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	
    	        }
    	        
            }
            System.out.println(name);
        }
        
       	//Prompt the user for first input 
        budget = Float.parseFloat(processInput.getNum("Enter your budget (i.e. $59): ", 1));
        
        //check against blank entries
        if (budget.SIZE == 0) {
        	
        	System.out.println("You did not enter anything. Please Try again.");
        	budget = Float.parseFloat(processInput.getNum("Enter your budget (i.e. $59): ", 1));
        	
        } else {
            
            System.out.println("Your budget is $".concat(String.format("%.2f", budget, args)));
            
        }
     
        
    	while (checkoutFlag == 0) {
    		
    		System.out.println("Please select an option.");
    		
    		option = processInput.getNum(
    					(optionOne.concat("\t")
    						.concat(optionTwo).concat("\n")
    						.concat(optionThree).concat("\t")
    						.concat(optionFour).concat("\n")
    						.concat(optionFive).concat("\n")
    						.concat(optionZero).concat("\n"))
    						, 0);
    		
    		int select = Integer.parseInt(option);
    		
    		//Valid options
    		if (select > 5 || select < 0) {
    			
    			System.out.print("Please select a valid option");
    		
    		//Checkout option
    		} else if (select == 3) {
    			
//    			String displayPurchases = "";
    			
    			if (userCart.mappedItems.isEmpty() == true) {
    				
    				System.out.println("You do not have any items in your cart to purchase/checkout.");
    				
    			} else {
        	        
//    				displayPurchases = userCart.completePurchase(itemIdxs, runTotal);
    				userCart.completePurchase(itemIdxs, budget);
    				
//    				System.out.println(displayPurchases);
    				
    			}
    			
    			
    			
    			//exit menu flag
    			checkoutFlag = 1;
    		
    		//Process options
    		} else {
    			
    	        if (select == 0) {
    	        	
    	        	System.out.println("Thank you and goodbye");
    	        	exit(0);
    	        	
    	        //show menu
    			} else if (select == 4) {
    				
        	        userCart.myStore.showCatalog();
    				
        	    //add items to cart
    			} else if (select == 2){
    				
					String itemNum = "-1";
					String priority = "-1";
					
					
					while (Integer.parseInt(itemNum) == -1 || 
							(Integer.parseInt(itemNum) > Integer.parseInt(userCart.myStore.Qty)) ){
						
						itemNum = processInput.getNum("Enter Item Number(#) to add to cart: ", 0);	
						
						if (Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) {
						
							System.out.println("Please enter a valid item number");
					
						}
						
					}//end while check for valid item numbers
					
					while (Integer.parseInt(priority) == -1 || 
							(Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) ){
						priority = processInput.getNum("Enter the priority for this item (1-7) ", 0);
						
						if (Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) {
							
							System.out.println("Please enter a valid priority");
							
						}
						
					}//end while check for valid priorities
					
					
					if (itemIdxs != "") {
						
						runTotal = 0.0f;
						runTotal = userCart.runningTotal(itemIdxs);
						
					}
					
					if (runTotal > budget) {
						
						System.out.println("You cannot add to cart, more than you have in your budget");
						
						//adjust running Total
						runTotal -= userCart.getPricesInCart(itemNum);
						
					} else {
						
			            itemIdxs += itemNum.concat("-");
			            
			            //add to session cart
			            userCart.addItem(itemNum, priority);

					}
				
    			} else {
    				
    				//view cart if not empty
    				if (select == 1 && userCart.mappedItems.isEmpty() != true) {
    					
    					System.out.println(userCart.viewCart(itemIdxs));
    				
    				//cart is empty
    				} else if (userCart.mappedItems.isEmpty() == true) {
    					
    					System.out.println("Your cart is empty");
    					
    				}//end if get cart descriptions
    				
    				//check running total
    				if (select == 5) {
    					
    					runTotal = 0.0f;
    					
    					System.out.print("Your total is: $");

    					runTotal = userCart.runningTotal(itemIdxs);
    					
    					System.out.println(runTotal);
    					if (budget >= runTotal) {
    						System.out.println("Amount Left over: ");
        					System.out.println(budget - runTotal);
    					}
    					
    					
    				}//end if running total display
    				
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
