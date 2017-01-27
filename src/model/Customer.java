package model;

/**
 * @ClassName Customer
 * @Author Matthew Tse
 *
 */

public class Customer extends Person{

	protected String id;
	protected double income;
	protected int cScore;
	
	/**
	 * @return the id
	 */
	protected String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	protected void setId(String id) {
		this.id = id;
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
