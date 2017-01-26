package model;

/**
 * @ClassName Customer
 * @Author Matthew Tse
 *
 */

public abstract class Customer extends Person{

	protected String id;
	protected double income;
	protected int cScore;

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
