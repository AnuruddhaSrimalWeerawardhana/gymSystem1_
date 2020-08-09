package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EmployeeSalary;

public class EmpSalaryAddQuery {
	
	
	public Connection connection;
	
public EmpSalaryAddQuery(String dbName, String uname, String pwd){
	 String url = "jdbc:mysql://localhost:3307/" + dbName;
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url,uname,pwd);
		
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void doAdd(EmployeeSalary salary){
	
	String query = "insert into employee_salary (`eno`, `ename`, `basic`, `ot`,`atbonus`,`tot`) values (?,?,?,?,?,?)" ;
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, salary.getRegNo());
		ps.setString(2, salary.getName());
		ps.setDouble(3, salary.getBasic());
		ps.setDouble(4, salary.getOtSal());
		ps.setDouble(5, salary.getAtbonus());
		ps.setDouble(6, salary.getTotSal());
		
		
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}


}
