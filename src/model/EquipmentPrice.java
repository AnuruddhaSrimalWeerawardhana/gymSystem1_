package model;

public class EquipmentPrice {
	   private int item_no;
	   private String name;
	   private double qty;
	   private double price;
	   private double totprice;
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotprice() {
		return totprice;
	}
	public void setTotprice(double totprice) {
		this.totprice = totprice;
	}
	@Override
	public String toString() {
		return "EquipmentPrice [item_no=" + item_no + ", name=" + name + ", qty=" + qty + ", price=" + price
				+ ", totprice=" + totprice + "]";
	}
	  

}
