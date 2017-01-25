/**
 * @ClassName custDb
 * @Author Matthew Tse
 *
 */

public class custDb {
	
	private String[] custList;
	private String custLength	= Integer.toString(custList.length);
	
	/**
	 * @ClassName customer
	 * @Author Matthew Tse 
	 *
	 */
	protected class customer {
		
		//Declarations and initializations
		protected String Id		= "";
		protected String Name	= "";
		protected String Age	= "";
		protected String Income	= "";
		protected String CScore = "";
		
		/**
		 * @return the id
		 */
		protected String getId() {
			return Id;
		}
		/**
		 * @param id the id to set
		 */
		protected void setId(String id) {
			Id = id;
		}
		/**
		 * @return the name
		 */
		protected String getName() {
			return Name;
		}
		/**
		 * @param name the name to set
		 */
		protected void setName(String name) {
			Name = name;
		}
		/**
		 * @return the age
		 */
		protected String getAge() {
			return Age;
		}
		/**
		 * @param age the age to set
		 */
		protected void setAge(String age) {
			Age = age;
		}
		/**
		 * @return the income
		 */
		protected String getIncome() {
			return Income;
		}
		/**
		 * @param income the income to set
		 */
		protected void setIncome(String income) {
			Income = income;
		}
		/**
		 * @return the cScore
		 */
		protected String getCScore() {
			return CScore;
		}
		/**
		 * @param cScore the cScore to set
		 */
		protected void setCScore(String cScore) {
			CScore = cScore;
		}

	}//end customer class
	
	
	public void showCustomers() {
		
		for (int itemCnt = 0; itemCnt < Integer.parseInt(custLength); itemCnt++) {
			
			System.out.println(custList[itemCnt].concat("\t$");
			
		}//end for loop
		
	}
	
	public String getcustList(int num) {
		
		return custList[num - 1];
	}
	
}
