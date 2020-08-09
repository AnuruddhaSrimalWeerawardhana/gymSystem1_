package model;

public class Member {
	
	
	   private int regid;
	   private String name;
	   private String address;
	   private String tel;
	   private String NIC;
	   private int age;
	   private String gender;
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Member [regid=" + regid + ", name=" + name + ", address=" + address + ", tel=" + tel + ", NIC=" + NIC
				+ ", age=" + age + ", gender=" + gender + "]";
	}



}
