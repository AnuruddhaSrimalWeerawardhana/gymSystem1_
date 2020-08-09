package model;

public class EmployeeSalary {
	
	 private int regNo;
	   private String name;
	   private double basic;
	   private double otSal;
	   private double atbonus;
	   private double totSal;
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getOtSal() {
		return otSal;
	}
	public void setOtSal(double otSal) {
		this.otSal = otSal;
	}
	public double getAtbonus() {
		return atbonus;
	}
	public void setAtbonus(double atbonus) {
		this.atbonus = atbonus;
	}
	public double getTotSal() {
		return totSal;
	}
	public void setTotSal(double totSal) {
		this.totSal = totSal;
	}
	@Override
	public String toString() {
		return "Salary [regNo=" + regNo + ", name=" + name + ", basic=" + basic + ", otSal=" + otSal + ", atbonus="
				+ atbonus + ", totSal=" + totSal + "]";
	}


}
