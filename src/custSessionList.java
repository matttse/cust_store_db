
/**
 * @ClassName custSessionList
 * @Author Matthew Tse
 *
 */

import java.util.*;
import java.io.*;

public class custSessionList implements Printer{
	
	private String cartDetail	= "";
	protected String itemName	= "";
	private String itemIdx		= "";
	private String priorityIdx	= "";
	private String shoppingListFile	= "shoppingList.txt";
	
	
	Map<String, String> mappedItems = new TreeMap<String, String>();
	
	
	//instantiate the handler
    UserInputHandler process = new UserInputHandler();
    
	//instantiate the the store
	custDb custStoreDb = new custDb();
	
	public void addItem() {
		
	}
	
	public String addItem(String itemNum, String priority) {
    	
        boolean checkItem		= false;
		boolean checkPriority	= false;
		
		
		if (mappedItems.isEmpty() != true) {
			
	        //check to see if user has already added item to their cart
//	        checkItem = process.getMatchedItems(itemIdx, itemNum);
	        
	        checkPriority = process.getMatchedItems(priorityIdx, priority);
	        
		} 
        
        
//        if (checkItem == false && checkPriority == false) {
        if (checkPriority == false) {
    		cartDetail += itemNum
    				.concat("-")
    				.concat(custStoreDb.getcustList(Integer.parseInt(itemNum)))
    				.concat("-")
    				.concat(priority)
    				.concat("-");
    		
    		mappedItems.put(priority, itemNum);
    		
    		itemIdx		+= itemNum.concat("-");
    		priorityIdx	+= priority.concat("-");
    	
    	/*taken out to allow multiples
        } else if (checkItem == true) {
        	
        	System.out.println("You already have this item in your cart.");
        */
        	
        } else if (checkPriority == true) {
        	
        	System.out.println("You already selected this priority in your cart.");	
        	
        } else {
        	
        	System.out.print("Error");
        	
        }
        return cartDetail;
		
	}//end method

	public void removeItem() {
		// TODO Auto-generated method stub
	}

	public void viewItem() {
		// TODO Auto-generated method stub
		
	}

	public void viewPrice() {
		// TODO Auto-generated method stub
		
	}
	
	public String viewCart(String itemIdxs) {
		
		String itemsInCart = "Your Cart: \n";
		String[] names = itemIdxs.split("-");
		
		if (mappedItems.isEmpty() != true) {
			for (int idx = 0; idx < mappedItems.size(); idx++) {

				itemsInCart += custStoreDb.getcustList(
						Integer.parseInt(names[idx]))
						.concat("\n");
				
			}
		} else {
			System.out.println("You have not mapped any items to the cart yet.");
		}
		
		return itemsInCart;
		
	}//end method
	/*
	 * @Name: getPricesInCart
	 * @Function/Purpose: adds up running total for prices in cart
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public float getPricesInCart(String itemNum) {
		
		float totalPrice = 0.0f;
		
		totalPrice += Float.parseFloat(custStoreDb.getcustList(Integer.parseInt(itemNum)));
				
		return totalPrice;
	}//end method
	
	/*
	 * @Name: completePurchase
	 * @Function/Purpose: finalizes purchases by priority
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: purchased items in string
	 * 
	 * */
	public void completePurchase(String itemIdxs, Float budget) {
		String purchasedItems = "You have purchased:\n";
		Float total = 0.0f;
		Float remainingValue = 0.0f;
		
		//declare/create arraylist for key of mapped items
		List<String> sortedKeys = new ArrayList<String>(mappedItems.keySet());
		
		//Sort the keys by priority
		Collections.sort(sortedKeys);
		
		for (int idx = 0; idx < mappedItems.size(); idx++) {

			String priority = sortedKeys.get(idx);//priority sorted is key
			String iNum = mappedItems.get(priority);//item number is value
			custStoreDb.getcustList(Integer.parseInt(iNum));//individual prices of items
			purchasedItems += custStoreDb.getcustList(Integer.parseInt(iNum)).concat("-");//individual name of items
			
			total += getPricesInCart(iNum);
			
		}
		
		
		System.out.println("Total Price: $".concat(String.format("%.2f", total)));
		remainingValue = budget - total;
		
		System.out.println("Your remaining value is: ".concat(String.format("%.2f", remainingValue)));
		
		printToFile(purchasedItems);
		
//		return null;
	}//end method
	
	/*
	 * @Name: printToFile
	 * @Function/Purpose: read/write to file
	 * 
	 * @Parameters: which item(s) was added 
	 * 
	 * @Additional Comments: 
	 * @Return: void
	 * 
	 * */	
	private void printToFile(String purchasedItems) {
		
		String fileName = shoppingListFile;
		PrintWriter outputStream = null;
		String items[] = purchasedItems.split("-");
		
		try {
			
			outputStream = new PrintWriter(fileName);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error opening the file" + fileName);
			e.printStackTrace();
			System.exit(0);
			
		}//end try catch block
		
		//loop through items purchased
		for (int lnCnt = 0; lnCnt < items.length; lnCnt++) {
			
			//input items by line into the outputStream
			outputStream.println(items[lnCnt]);	
			
		}//end for loop
		
		outputStream.close();
		System.out.println("Those lines were written to " + fileName);
		
//		ObjectInputStream inputStream = null;
		Scanner inputStream = null;
		try {
		
//			inputStream = new ObjectInputStream (new FileInputStream (fileName));
			inputStream = new Scanner(new File(fileName));
			
			
			while (inputStream.hasNext()) {
				
				//print each line out in file
				String line = inputStream.nextLine();
				System.out.println(line);
				
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Problem opening the file" + fileName);
			e.printStackTrace();
			System.exit(0);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(0);
			
		}

		
	}//end method
	
	/*
	 * @Name: runningTotal
	 * @Function/Purpose: get total from customers in list
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public float runningTotal(String itemIdxs) {
		Float runTotal = 0.0f;
		String items[] = itemIdxs.split("-");
		for (int cnt = 0; cnt < items.length; cnt++) {
			
			runTotal += getPricesInCart(items[cnt]);
				
		}//end for loop for iterating through items added
		return runTotal;
	}

	public void printToFile() {
		// TODO Auto-generated method stub
		
	}
	
	


}//end class
