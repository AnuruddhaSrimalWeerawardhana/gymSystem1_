package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.EmployeeSalary;

public class EmpSalaryReadQuery {
    private Connection connection;
    private ResultSet results;
    
    public EmpSalaryReadQuery(String dbName,String uname,String pwd){
    	
    	String url = "jdbc:mysql://localhost:3307/" +dbName;
    	//set up the driver
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void doRead(){
    	String query = "Select * from employee_salary";
    	try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String getHTMLTable(){
    	String table ="";
    	table += "<table border=2>";
    	
    	table += "<tr>";
		
		 table += "<th>";
	      table += "Regestration No";
	    table += "</th>";
		
	    table += "<th>";
	       table += "Employee Name";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Basic Salary";
	    table += "</th>";
	    
	  
	    table += "<th>";
	       table += "OT Salary";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Attendance Bonus";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Total Salary";
	    table += "</th>";
	 
	  
	  
	  table += "</tr>";
    	
    	try {
			while(this.results.next()){
				EmployeeSalary salary = new EmployeeSalary();
				salary.setRegNo(this.results.getInt("eno"));
				salary.setName(this.results.getString("ename"));
				salary.setBasic(this.results.getDouble("basic"));
				salary.setOtSal(this.results.getDouble("ot"));
				salary.setAtbonus(this.results.getDouble("atbonus"));
				salary.setTotSal(this.results.getDouble("tot"));
			
				
				  table += "<tr>";
				    table += "<td>";
				      table += salary.getRegNo();
				    table += "</td>";
				  
				 
				    table += "<td>";
				      table += salary.getName();
				    table += "</td>";
				    
				    table += "<td>";
				      table += salary.getBasic();
				    table += "</td>";
				    
				    
				    table += "<td>";
				      table += salary.getOtSal();
				    table += "</td>";
				    
				    table += "<td>";
				      table += salary.getAtbonus();
				    table += "</td>";
				    
				    table += "<td>";
				      table += salary.getTotSal();
				    table += "</td>";
				    
				    
				    
				  
				    
		    table += "</tr>";
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	table += "</table>";
    	
    	return table;
    	
    	
    	
    }

}
