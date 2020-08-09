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
public class EmpReadQuery {
    private Connection connection;
    private ResultSet results;
    
    public EmpReadQuery(String dbName,String uname,String pwd){
    	
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
    	String query = "Select * from employee_details";
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
	       table += "Designation";
	    table += "</th>";
	    
	  
	    table += "<th>";
	       table += "Address";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Telephone";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Marital Status";
	    table += "</th>";
	 
	    table += "<th>";
	       table += "Sex";
	    table += "</th>";
	  
	    table += "<th>";
	       table += "Joined Date";
	    table += "</th>";
	  
	  table += "</tr>";
    	
    	try {
			while(this.results.next()){
				Employee employee = new Employee();
				employee.setRegNo(this.results.getInt("regNo"));
				employee.setName(this.results.getString("Employee Name"));
				employee.setDesignation(this.results.getString("Designation"));
				employee.setAddress(this.results.getString("Address"));
				employee.setTel(this.results.getString("Telephone"));
				employee.setMaritalStatus(this.results.getString("Marital Status"));
				employee.setSex(this.results.getString("Sex"));
				employee.setJoindate(this.results.getString("Joined Date"));
				
				  table += "<tr>";
				    table += "<td>";
				      table += employee.getRegNo();
				    table += "</td>";
				  
				 
				    table += "<td>";
				      table += employee.getName();
				    table += "</td>";
				    
				    table += "<td>";
				      table += employee.getDesignation();
				    table += "</td>";
				    
				    
				    table += "<td>";
				      table += employee.getAddress();
				    table += "</td>";
				    
				    table += "<td>";
				      table += employee.getTel();
				    table += "</td>";
				    
				    table += "<td>";
				      table += employee.getMaritalStatus();
				    table += "</td>";
				    
				    table += "<td>";
				      table += employee.getSex();
				    table += "</td>";
				    
				    table += "<td>";
				      table += employee.getJoindate();
				    table += "</td>";
				    
				    table += "<td>";
				     table += "<a href=updateEmp?regNo="+employee.getRegNo()+">Update</a> <a href=deleteEmp?regNo="+employee.getRegNo()+">Delete</a> <a href=EmpCalSalFormServlet?regNo="+employee.getRegNo()+">Calculate Salary</a>";
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
