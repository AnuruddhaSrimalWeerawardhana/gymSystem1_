 /**
 * 
 */
package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Suranjan
 *
 */
public class EmpDeleteQuery {
	private Connection connection;
	
	public EmpDeleteQuery(String dbName,String uname,String pwd){
		 String url = "jdbc:mysql://localhost:3307/"+dbName;
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doDelete(int regNo){
		//Set up String to hold the query
		String query = "delete from employee_details where regNo = ? ";
		
		//Create a PreparedStatement using the query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//Fill in the PreparedStatement
			ps.setInt(1,regNo);
			//Execute the query
			ps.executeUpdate(); 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
