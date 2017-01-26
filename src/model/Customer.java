package model;

/**
 * @ClassName Customer
 * @Author Matthew Tse
 *
 */

public class Customer extends Person{
	
	private String[] custList;
	private String custLength;
	protected int age;
	protected double income;
	protected int cScore;

	/**
	 * @return the age
	 */
	protected int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	protected void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the income
	 */
	protected double getIncome() {
		return income;
	}


	/**
	 * @param income the income to set
	 */
	protected void setIncome(double income) {
		this.income = income;
	}


	/**
	 * @return the cScore
	 */
	protected int getcScore() {
		return cScore;
	}


	/**
	 * @param cScore the cScore to set
	 */
	protected void setcScore(int cScore) {
		this.cScore = cScore;
	}
	
}//end class
