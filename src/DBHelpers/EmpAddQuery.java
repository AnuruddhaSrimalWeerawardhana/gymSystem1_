/**
 * 
 */
package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;

/** 
 * @author Suranjan
 *
 */
public class EmpAddQuery {
	public Connection connection;
	
public EmpAddQuery(String dbName, String uname, String pwd){
	 String url = "jdbc:mysql://localhost:3307/" + dbName;
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url,uname,pwd);
		
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void doAdd(Employee employee){
	
	String query = "insert into employee_details (`Employee Name`, `Designation`,`Address`,`Telephone`,`Marital Status`, `Sex` ,`Joined Date`) values (?,?,?,?,?,?,?)" ;
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getDesignation());
		ps.setString(3, employee.getAddress());
		ps.setString(4, employee.getTel());
		ps.setString(5, employee.getMaritalStatus());
		ps.setString(6, employee.getSex());
		ps.setString(7, employee.getJoindate());
		
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

}
