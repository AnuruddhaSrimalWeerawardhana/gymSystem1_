package DBHelpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.LoginBean;

public class LoginQuery {
	public Connection connection;
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
public String LoginQuery(LoginBean loginBean){
	String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
	String password = loginBean.getPassword();
	String userNameDB = "";
	String passwordDB = "";

	 try {
		 con = DBConnection.createConnection(); //establishing connection
		 statement = (Statement) con.createStatement(); //Statement is used to write queries. Read more about it.
		 resultSet = statement.executeQuery("select user_name,password from users"); //Here table name is users
		
		while(resultSet.next()) // Until next row is present otherwise it return false
		 {
		  userNameDB = resultSet.getString("user_name"); //fetch the values present in database
		  passwordDB = resultSet.getString("password");
		 
		   if(userName.equals(userNameDB) && password.equals(passwordDB))
		   {
		      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
		   }
		 }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Invalid user credentials"; // Just returning appropriate message otherwise
	
}
}
