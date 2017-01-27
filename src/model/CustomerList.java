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

public class CustomerList {
	
	protected String custDetails[]	= null;
		
	//instantiate the handler
    UserInputHandler process = new UserInputHandler();

    //instantiate the the customer list object    
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    
	//add item to customer object
	public boolean addCustomer(String custDetail) {
    	//status check, default is fail
		boolean stat	= false;
		//unpack customer info
		String temp[] = custDetail.split(",");
	    //instantiate the the customer object    
	    Customer customer = new Customer();
		//set customer info to customer object
		customer.id		= temp[0];
		customer.FName	= temp[1];
		customer.LName	= temp[2];
		customer.Age	= Integer.parseInt(temp[3]);
		customer.income	= Double.parseDouble(temp[4]);
		customer.cScore	= Integer.parseInt(temp[5]);
		
		//add customer info to customer list
		customerList.add(customer);
		
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
	 * @Return: status
	 * 
	 * */
	public Boolean showCustomers() {

		boolean stat		= false;

		if (customerList.size() > 0) {
			for (int custID = 0; custID < customerList.size(); custID++) {
//				System.out.println(customerList.get(custID).getId());
				System.out.println(customerList.get(custID).getFName()
						+ " " + customerList.get(custID).getLName());
				
			}	
			
			stat = true;
		}
		
		return stat;
	}//end method
	
	public CustomerList(ArrayList<Customer> customerList) {
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
