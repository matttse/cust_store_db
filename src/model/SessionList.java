package model;

/**
 * @ClassName custSessionList
 * @Author Matthew Tse
 *
 */

import java.util.*;
import java.io.*;

import dhl.UserInputHandler;

public class SessionList {
	
	private String cartDetail	= "";
	protected String itemName	= "";
	private String itemIdx		= "";
		
	//instantiate the handler
    UserInputHandler process = new UserInputHandler();
    
	//instantiate the the customer object
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	//add item to customer object
	public boolean addCustomer(String custDetail) {
    	//status check, default is fail
		boolean stat	= false;		
		
		//TODO ADD stat return 1 success 0 fail
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
	public String showCustomers() {
		String custList = "";
		int mylength = 20;
		for (int custID = 0; custID < customerList.size(); custID++) {
			custList	+= custID;
		}			
		
		return custList;
	}//end method
	
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
