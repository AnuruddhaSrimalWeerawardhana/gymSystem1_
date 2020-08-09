/**
 * 
 */
package model;

/**
 * @author Suranjan
 *
 */
public class User {
	private  String fame;
	private  String lname;
	private String nic;
	private String  uname;
	private String pwd;
	public User() {
		this.fame = "No fname";
		this.lname = "No lame";
		this.nic = "No nic";
		this.uname = "No uname";
		this.pwd = "No pwd";
	}
	public String getFame() {
		return fame;
	}
	public void setFame(String fame) {
		this.fame = fame;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "user [fame=" + fame + ", lname=" + lname + ", nic=" + nic + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
	
	

}
