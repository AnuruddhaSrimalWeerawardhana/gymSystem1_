package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Equipment;

public class EquipReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public EquipReadQuery(String dbName,String uname,String pwd){
		
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		
		//set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			this.connection=DriverManager.getConnection(url, uname, pwd);
			
			
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
		
		String query ="select * from equipment";
		
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
	    	
	    	table +="<tr>";
	    	

	    	table += "<th>";
	         table += "Gym Item ID";
	       table += "</th>";
	       
	   	 table += "<th>";
	         table += "Item Name";
	       table += "</th>";
	   	

	  	 table += "<th>";
	        table += "Suitable Body Part";
	      table += "</th>";
	  	

	 	 table += "<th>";
	       table += "Quantity of Item";
	     table += "</th>";
	 	

		 table += "<th>";
	      table += "Price Of Item";
	    table += "</th>";
		
	    

		 
			
	    	
	    	
	    	
	    	
	    	table +="</tr>";
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	try {
				while(this.results.next()){
					
					
				Equipment equipment = new Equipment();
				equipment.setItem_id(this.results.getInt("item_id"));
				equipment.setItem_name(this.results.getString("item_name"));
				equipment.setBody_part(this.results.getString("body_part"));
				equipment.setQnt(this.results.getInt("qnt"));
				equipment.setPrice(this.results.getInt("price"));
					
				
				table +="<tr>";
				
				table +="<td>";
				table += equipment.getItem_id();
				table +="</td>";
				
				table +="<td>";
				table += equipment.getItem_name();
				table +="</td>";
				
				table +="<td>";
				table +=equipment.getBody_part();
				table +="</td>";
				
				table +="<td>";
				table+=equipment.getQnt();
				table +="</td>";
				
				table +="<td>";
				table +=equipment.getPrice();
				table +="</td>";
				
				table +="<td>";
				table += "<a href=EquipUpdateFormServlet?item_id=" +equipment.getItem_id() + ">update</a> <a href=EquipDeleteServlet?item_id=" +equipment.getItem_id() +  ">delete</a> <a href=EquipCalcFormServlet?item_id="+equipment.getItem_id()+">Calculate Salary</a>";
				table +="</td>";
				
				
				table +="</tr>";
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	table +="</table>";
	    	return table;
	    	
	    	
	    	
	    	
	    }
	

}
