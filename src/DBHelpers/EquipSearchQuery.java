package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Equipment;

public class EquipSearchQuery {
	
	private Connection connection;
	private ResultSet results;
	public EquipSearchQuery(String dbName, String uname, String pwd ){
		
		String url =  "jdbc:mysql://localhost:3307/" + dbName;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection =DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doSearch(String itname){
		// set up String to hold our query
		String query = "select * from equipment where item_name LIKE'"+itname+"%'";
		// create a preparedstatement using query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			//execute the query
			this.results = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
    public String getHTMLTable(){
    	
    	String sqtable ="";
    	
    	sqtable += "<table border=1>";
    	
    	sqtable +="<tr>";
    	

    	sqtable += "<th>";
    	sqtable += "ID";
    	sqtable += "</th>";
       
    	sqtable += "<th>";
    	sqtable += "Regestration No";
    	sqtable += "</th>";
   	

    	sqtable += "<th>";
    	sqtable += "Regestration No";
    	sqtable += "</th>";
  	

    	sqtable += "<th>";
    	sqtable += "Regestration No";
    	sqtable += "</th>";
 	

    	sqtable += "<th>";
    	sqtable += "Regestration No";
    	sqtable += "</th>";
	
    

	 
		
    	
    	
    	
    	
    	sqtable +="</tr>";
    	
    	
    	
    	
    	
    	
    	
    	try {
			while(this.results.next()){
				
				
			Equipment equipment = new Equipment();
			equipment.setItem_id(this.results.getInt("item_id"));
			equipment.setItem_name(this.results.getString("item_name"));
			equipment.setBody_part(this.results.getString("body_part"));
			equipment.setQnt(this.results.getInt("qnt"));
			equipment.setPrice(this.results.getInt("price"));
				
			
			sqtable +="<tr>";
			
			sqtable +="<td>";
			sqtable += equipment.getItem_id();
			sqtable +="</td>";
			
			sqtable +="<td>";
			sqtable += equipment.getItem_name();
			sqtable +="</td>";
			
			sqtable +="<td>";
			sqtable +=equipment.getBody_part();
			sqtable +="</td>";
			
			sqtable +="<td>";
			sqtable+=equipment.getQnt();
			sqtable +="</td>";
			
			sqtable +="<td>";
			sqtable +=equipment.getPrice();
			sqtable +="</td>";
			
			sqtable +="<td>";
			sqtable += "<a href=update?item_id=" +equipment.getItem_id() + ">update</a> <a href=delete?item_id=" +equipment.getItem_id() +  ">delete</a>";
			sqtable +="</td>";
			
			
			sqtable +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	sqtable +="</table>";
    	return sqtable;
    	
    	
    	
    	
    }

}
