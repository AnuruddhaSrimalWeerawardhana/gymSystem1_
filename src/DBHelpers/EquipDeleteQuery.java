package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipDeleteQuery {
	
	private Connection connection;
	public EquipDeleteQuery(String dbName, String uname, String pwd ){
		
		String url =  "jdbc:mysql://localhost:3307/" + dbName;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection =DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDelete(int item_id){
		// set up String to hold our query
		String query = "delete from equipment where item_id = ?";
		// create a preparedstatement using query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the  preparedstatement
			ps.setInt(1,item_id);
			
			
			//execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	

}
