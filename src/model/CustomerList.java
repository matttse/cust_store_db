package model;

/**
 * @ClassName custSessionList
 * @Author Matthew Tse
 *
 */

import java.util.*;
import java.io.*;

import javax.lang.model.element.Element;

import dhl.UserInputHandler;

public class CustomerList extends Customer {
	
	protected String customer		= "";
	protected String custDetails[]	= null;
		
	//instantiate the handler
    UserInputHandler process = new UserInputHandler();

    //instantiate the the customer object    
    ArrayList<String> customerList = new ArrayList<String>();	
    
	//add item to customer object
	public boolean addCustomer(String custDetail) {
    	//status check, default is fail
		boolean stat	= false;		
		
		//add customer info to customer list
		customerList.add(custDetail);
		
		//if the list exists and is bigger than 0
		if (customerList.size() > 0) {
			stat = true;
		}
		
        return stat;
		
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

	/*
	 * @Name: showCustomers
	 * @Function/Purpose: 
	 * 
	 * @Parameters: 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public String showCustomers(ArrayList<String> customerList) {
		String details = "";
		String customerIdx = "";
		for (int custID = 0; custID < customerList.size(); custID++) {
			customerIdx	+= customerList.get(custID);
			details += customerIdx.split(",");
			
			
		}			
		
		//customer list iterator
//		for (int cid = 0; cid < customerList.size(); cid++) {
			//customer detail iterator
//			customer = customerList.get(cid);
			
//			for (int detail = 0; detail < 6; detail++) {
//			customer.split(",");
			
			
				
				
						
//			}

				
//		} 
		
		return details;
	}//end method
	
	public CustomerList(ArrayList<String> customerList) {
		super();
		
	}
	
	/*
	 * @Name: searchCustDb
	 * @Function/Purpose: find customer based on ID
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	

}//end class
