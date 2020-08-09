package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EquipmentPrice;

public class EquipCalculationAddQuery {
	
	public Connection connection;
	
public EquipCalculationAddQuery(String dbName, String uname, String pwd){
	 String url = "jdbc:mysql://localhost:3307/" + dbName;
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection(url,uname,pwd);
		
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void doAdd(EquipmentPrice eq){
	
	String query = "insert into equipment_price (`id`, `name`, `qty`, `price`,`tot`) values (?,?,?,?,?)" ;
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, eq.getItem_no());
		ps.setString(2, eq.getName());
		ps.setDouble(3, eq.getQty());
		ps.setDouble(4, eq.getPrice());
		ps.setDouble(5, eq.getTotprice());
		
		
		
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
