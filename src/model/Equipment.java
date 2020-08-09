package model;

public class Equipment {
	

	
	private int item_id;
	private String item_name;
	private String body_part;
	private int qnt;
	private int price;
	
	
	

	/**
	 * @param item_id
	 * @param item_name
	 * @param body_part
	 * @param qnt
	 * @param price
	 */
	public Equipment() {
		this.item_id = 1;
		this.item_name = "No item_name";
		this.body_part = "No body_part";
		this.qnt = 0;
		this.price = 0;
	}
	
	
	
	
	
	
	
	/**
	 * @param item_id
	 * @param item_name
	 * @param body_part
	 * @param qnt
	 * @param price
	 */
	public Equipment(int item_id, String item_name, String body_part, int qnt, int price) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.body_part = body_part;
		this.qnt = qnt;
		this.price = price;
	}







	/**
	 * @return the item_id
	 */
	public int getItem_id() {
		return item_id;
	}







	/**
	 * @param item_id the item_id to set
	 */
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}







	/**
	 * @return the item_name
	 */
	public String getItem_name() {
		return item_name;
	}







	/**
	 * @param item_name the item_name to set
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}







	/**
	 * @return the body_part
	 */
	public String getBody_part() {
		return body_part;
	}







	/**
	 * @param body_part the body_part to set
	 */
	public void setBody_part(String body_part) {
		this.body_part = body_part;
	}







	/**
	 * @return the qnt
	 */
	public int getQnt() {
		return qnt;
	}







	/**
	 * @param qnt the qnt to set
	 */
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}







	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}







	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}







	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Equipment [item_id=" + item_id + ", item_name=" + item_name + ", body_part=" + body_part + ", qnt="
				+ qnt + ", price=" + price + "]";
	}
	
	
	
	

}
