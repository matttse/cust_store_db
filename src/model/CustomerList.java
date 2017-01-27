package model;

/**
 * @ClassName CustomerList
 * @Author Matthew Tse
 * @SuperClass CustomerList
 * @Method addCustomer
 * @Method getCustomerListSize
 * @Method showCustomers
 * @Method updateCustomerInfo
 * @Method searchCustDb
 *
 */

import java.util.*;
import java.util.Map.Entry;
import dhl.UserInputHandler;

public class CustomerList {

	protected String custDetails[] = null;

	// instantiate the handler
	UserInputHandler process = new UserInputHandler();

	// instantiate the the customer list object	
	TreeMap<Integer, Customer> mappedCustomers = new TreeMap<Integer, Customer>();
	
	/*
	 * @Name: addCustomer
	 * 
	 * @Function/Purpose:add customer to customerlist
	 * 
	 * @Parameters: {vc} customer details
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: boolean
	 * 
	 */
	public boolean addCustomer(String custDetail) {
		// status check, default is fail
		boolean stat = false;
		// unpack customer info
		String temp[] = custDetail.split(",");
		// instantiate the the customer object
		Customer customer = new Customer();
		// set customer info to customer object
		customer.id = temp[0];
		customer.FName = temp[1];
		customer.LName = temp[2];
		customer.Age = Integer.parseInt(temp[3]);
		customer.income = Double.parseDouble(temp[4]);
		customer.cScore = Integer.parseInt(temp[5]);

		//add key value pair to customer map for searching
		mappedCustomers.put(Integer.parseInt(temp[0]), customer);

		// if the list exists and is bigger than 0
		if (mappedCustomers.size() > 0) {
			stat = true;
		}

		return stat;

	}// end method

	/*
	 * @Name: removeCustomer
	 * 
	 * @Function/Purpose: remove customer from list
	 * 
	 * @Parameters: {i4} custID
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: boolean status
	 * 
	 */
	public boolean removeCustomer(int custID) {
		//initialize status
		boolean stat = false;
		//remove customer
		try {
			mappedCustomers.remove(custID);
			stat = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return stat;
		
	}

	/*
	 * @Name: updateCustomerInfo
	 * 
	 * @Function/Purpose: update info for customer based on user choice
	 * 
	 * @Parameters:
	 * 		{i4} custID
	 * 		{i4} optionFlag
	 * 
	 * 
	 * @Additional Comments:source
	 * 		http://stackoverflow.com/questions/4088271/how-can-i-update-values-in-a-map
	 * @Return: boolean status
	 * 
	 */
	public boolean updateCustomerInfo(int custID, int optionFlag, String newVal) {
		boolean stat = false;
		try {
			Customer customer = mappedCustomers.get(custID);
			switch (optionFlag) {
			//Age
			case 3:
				customer.setAge(Integer.parseInt(newVal));			
				
				stat = true;
				break;
			//Income
			case 4:
				customer.setIncome(Double.parseDouble(newVal));			
				
				stat = true;
				break;
			//Credit Score
			case 5:
				customer.setcScore(Integer.parseInt(newVal));			
				
				stat = true;
				break;
			default:
				stat = false;
				break;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return stat;

	}

	/*
	 * @Name: showCustomers
	 * 
	 * @Function/Purpose: display all customer names
	 * 
	 * @Parameters: null
	 * 
	 * @Additional Comments:sources
	 * 		http://beginnersbook.com/2014/07/treemap-iterator-example-java/
	 * 		http://stackoverflow.com/questions/8689725/map-entry-how-to-use-it
	 * @Return: null
	 * 
	 */
	public void showCustomers() {

		Set<Entry<Integer, Customer>> set = mappedCustomers.entrySet();
		
		Iterator<Entry<Integer, Customer>> idx = set.iterator();
		
		while(idx.hasNext()) {
			Map.Entry<Integer, Customer> custId = (Map.Entry<Integer, Customer>)idx.next();
			Customer customer = (Customer) custId.getValue();
			System.out.print("\n");
			System.out.println("Customer id: " + customer.getId());
			System.out.println("First name: " + customer.getFName());
			System.out.println("Last name: " + customer.getLName());
			System.out.println("Age: " + Integer.toString(customer.getAge()));
			System.out.println("Income: " + Double.toString(customer.getIncome()));
			System.out.println("Credit score: " + Integer.toString(customer.getcScore()));
		}

	}// end method
	
	/*
	 * @Name: getCustomerListSize
	 * 
	 * @Function/Purpose: determine if list has been populated
	 * 
	 * @Parameters: null
	 * 
	 * @Additional Comments:
	 * 
	 * @Return: boolean success/fail
	 * 
	 */
	public Boolean getCustomerListSize() {
		boolean stat = false;
		if (mappedCustomers.size() > 0) {
			stat = true;
		} else {
			System.out.println("You have not added any customers yet.");
			
		}
		return stat;

	}//end getCustomerListSize method
	
	public CustomerList() {
		super();
		
	}

	/*
	 * @Name: searchCustDb
	 * 
	 * @Function/Purpose: find customer based on ID
	 * 
	 * @Parameters: {i4} custID
	 * 
	 * @Additional Comments:internal use ONLY
	 * 
	 * @Return: object Customer
	 * 
	 */
	private Customer searchCustDb(int custID) {
		// instantiate the the customer object
		Customer customer = new Customer();
		
		if (mappedCustomers.isEmpty() != true) {
			try {
				Customer custDetail = mappedCustomers.get(custID);
				
				customer.setId(custDetail.id);
				customer.setFName(custDetail.FName);
				customer.setLName(custDetail.LName);
				customer.setAge(custDetail.Age);
				customer.setIncome(custDetail.income);
				customer.setcScore(custDetail.cScore);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				customer = null;
			}//end try catch
			
		}//end if check against empty list
		
		return customer;
		
	}//end searchCustDb method

}// end CustomerList class
