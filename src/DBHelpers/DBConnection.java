package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 public static Connection createConnection()
	 {
	 Connection con = null;
	 String url = "jdbc:mysql://localhost:3307/gym_management"; 
	 String username = "root"; 
	 String password = "apple12"; 
	 
	 try 
	 {
	 try 
	 {
	 Class.forName("com.mysql.jdbc.Driver"); 
	 } 
	 catch (ClassNotFoundException e)
	 {
	 e.printStackTrace();
	 } 
	 con = DriverManager.getConnection(url, username, password); 
	 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 return con; 
	 }
}
