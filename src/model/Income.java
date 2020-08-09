package model;

public class Income {
	private int id;
	private String description;
	private double amount;
	private double totalAmount;
	
	
	/**
	 * 
	 */
	public Income() {
		this.id = 1;
		this.description = "null";
		this.amount = 0;
		this.totalAmount = 0;
	}
	
	/**
	 * @param id
	 * @param description
	 * @param amount
	 */
	public Income(int id, String description, double amount, double totalAmount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.totalAmount = totalAmount;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Income [id=" + id + ", description=" + description + ", amount=" + amount + "]";
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
