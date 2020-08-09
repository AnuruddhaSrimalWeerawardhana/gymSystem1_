package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.EquipmentPrice;

public class EquipReadPriceQuery {
    private Connection connection;
    private ResultSet results;
    
    public EquipReadPriceQuery(String dbName,String uname,String pwd){
    	
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
    	String query = "Select * from equipment_price";
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
	      table += "Item No";
	    table += "</th>";
		
	    table += "<th>";
	       table += "Item Name";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Quantity";
	    table += "</th>";
	    
	  
	    table += "<th>";
	       table += "Item Price";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Total Price";
	    table += "</th>";
	    
	  
	  
	  
	  table += "</tr>";
    	
    	try {
			while(this.results.next()){
				EquipmentPrice eq = new EquipmentPrice();
				eq.setItem_no(this.results.getInt("id"));
				eq.setName(this.results.getString("name"));
				eq.setQty(this.results.getDouble("qty"));
				eq.setPrice(this.results.getDouble("price"));
				eq.setTotprice(this.results.getDouble("tot"));
			
				
				  table += "<tr>";
				    table += "<td>";
				      table += eq.getItem_no();
				    table += "</td>";
				  
				 
				    table += "<td>";
				      table += eq.getName();
				    table += "</td>";
				    
				    table += "<td>";
				      table += eq.getQty();
				    table += "</td>";
				    
				    
				    table += "<td>";
				      table += eq.getPrice();
				    table += "</td>";
				    
				    table += "<td>";
				      table += eq.getTotprice();
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
