package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Equipment;

public class EquipReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Equipment equipment = new Equipment();
	private int item_id;
	
	public EquipReadRecord(String dbName , String uname , String pwd , int item_id){
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		this.item_id = item_id;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void doRead(){
		
		
		String query = "select * from equipment where item_id = ? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.item_id);
			this.results = ps.executeQuery();
			
			this.results.next();
			
			equipment.setItem_id(this.results.getInt(1));
			equipment.setItem_name(this.results.getString("item_name"));
			equipment.setBody_part(this.results.getString("body_part"));
			equipment.setQnt(this.results.getInt("qnt"));
			equipment.setPrice(this.results.getInt("price"));
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Equipment getEquipment(){
		
		return this.equipment;
		
		
	}
	
	
	

}
