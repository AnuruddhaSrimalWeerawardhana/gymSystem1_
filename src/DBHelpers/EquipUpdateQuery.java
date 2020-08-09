package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Equipment;

public class EquipUpdateQuery {
	
	
	 private Connection connection;
	   
	   public EquipUpdateQuery(String dbName, String uname,String pwd){
		   
		   String url ="jdbc:mysql://localhost:3307/" + dbName;
		   
		   
		   try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   }
	
	    
	   public void doUpdate(Equipment equipment){
		   String query = "update equipment set item_name=? , body_part=? , qnt=? , price=? where item_id=?";
		   try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, equipment.getItem_name());
			ps.setString(2,equipment.getBody_part());
			ps.setInt(3,equipment.getQnt());
			ps.setInt(4,equipment.getPrice());
			ps.setInt(5,equipment.getItem_id());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   
		   
	   }
	   
	
	

}
