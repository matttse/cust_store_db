package model;
/**
 * @ClassName Person
 * @Author Matthew Tse 
 *
 */
public abstract class Person {
	
	//Declarations and initializations
	protected String FName	= "";
	protected String LName	= "";
	protected int Age;
	/**
	 * @return the fName
	 */
	protected String getFName() {
		return FName;
	}
	/**
	 * @param fName the fName to set
	 */
	protected void setFName(String fName) {
		FName = fName;
	}
	/**
	 * @return the lName
	 */
	protected String getLName() {
		return LName;
	}
	/**
	 * @param lName the lName to set
	 */
	protected void setLName(String lName) {
		LName = lName;
	}
	/**
	 * @return the age
	 */
	protected int getAge() {
		return Age;
	}
	/**
	 * @param age the age to set
	 */
	protected void setAge(int age) {
		Age = age;
	}
	


}//end customer class