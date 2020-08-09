package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;



public class RegistrationQuery {
	public Connection connection;
	
public RegistrationQuery(String dbName, String uname, String pwd){
	 String url = "jdbc:mysql://localhost:3307/" + dbName;
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url,uname,pwd);
		
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void doAdd(User u){
	
	String query = "insert into users (first_name, last_name, nic, user_name,password) values (?,?,?,?,?)" ;
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, u.getFame());
		ps.setString(2, u.getLname());
		ps.setString(3, u.getNic());
		ps.setString(4, u.getUname());
		ps.setString(5, u.getPwd());
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
	
}
