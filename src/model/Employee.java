/**
 * 
 */
package model;

/**
 * @author Suranjan
 *
 */
public class Employee {
	   private int regNo;
	   private String name;
	   private String address;
	   private String tel;
	   private String designation;
	   private String maritalStatus;
	   private String sex;
	   private String joindate;  
	   
	

	public Employee() {
		this.regNo = 1;
		this.name = "No Name";
		this.address ="No Address";
		this.tel = "No Tel";
		this.designation = "No Designation";
		this.maritalStatus = "No MaritalStatus";
		this.sex = "No Sex";
	}

	/**
	 * @return the regNo
	 */
	public int getRegNo() {
		return regNo;
	}

	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	
	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "Employee [regNo=" + regNo + ", name=" + name + ", address=" + address + ", tel=" + tel
				+ ", designation=" + designation + ", maritalStatus=" + maritalStatus + ", sex=" + sex + ", joindate="
				+ joindate + "]";
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	


}
