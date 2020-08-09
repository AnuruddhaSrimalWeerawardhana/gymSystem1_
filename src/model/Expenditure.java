package model;

public class Expenditure {
	

	private int id;
	private String description;
	private double amount;
	private double totalamount;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the totalamount
	 */
	public double getTotalamount() {
		return totalamount;
	}

	/**
	 * @param totalamount the totalamount to set
	 */
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	

}
