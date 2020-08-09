/**
 * 
 */
package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

/**
 * @author Suranjan
 *
 */
public class EmpReadRecord {
	private Connection  connection;
	private ResultSet results;
 
	private Employee employee = new Employee();
	private int regNo;
	
public EmpReadRecord(String dbName, String uname, String pwd,int regNo){
	
	String url = "jdbc:mysql://localhost:3307/" + dbName;
	this.regNo = regNo;
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url,uname,pwd);
		
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

public void doRead(){
	 String query = "select * from employee_details where regNo = ?";
	 
	 try {
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,this.regNo);
		this.results = ps.executeQuery();
		this.results.next();
		
		employee.setRegNo(this.results.getInt(1));
		employee.setName(this.results.getString("Employee Name"));
		employee.setDesignation(this.results.getString("Designation"));
		employee.setAddress(this.results.getString("Address"));
		employee.setTel(this.results.getString("Telephone"));
		employee.setMaritalStatus(this.results.getString("Marital Status"));
		employee.setSex(this.results.getString("Sex"));
		employee.setJoindate(this.results.getString("Joined Date"));
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }

public Employee getEmployee(){
	
	return this.employee;
	
	
}

	
}
