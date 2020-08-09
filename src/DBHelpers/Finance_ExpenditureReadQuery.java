package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Expenditure;

public class Finance_ExpenditureReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public Finance_ExpenditureReadQuery(String dbName,String uname,String pwd){
		String url = "jdbc:mysql://localhost:3307/"+dbName;
	
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
		String quary = "select * from expenditure";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(quary);
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
	      table += "Expenditure No";
	    table += "</th>";
		
	    table += "<th>";
	       table += "Description";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Amount";
	    table += "</th>";
	    
	  

	  
	  table += "</tr>";
		
		
		
		
		
		
		
		
		try {
			while(this.results.next()){
				Expenditure expenditure = new Expenditure();
				expenditure.setId(this.results.getInt(1));
				expenditure.setDescription(this.results.getString(2));
				expenditure.setAmount(this.results.getDouble(3));
				
				table +="<tr>";
			    table += "<td>";
			    table += expenditure.getId();
			    table += "</td>";
				table +="<td>";
				table +=expenditure.getDescription();
				table +="</td>";
				table +="<td>";
				table +=expenditure.getAmount();
				table +="</td>";
				table +="<td>";
					table += "<a href=FinanceUpdateForm_ExpenditureServlet?id=" + expenditure.getId() + ">update</a> <a href=FinanceDelete_ExpenditureServlet?id=" + expenditure.getId() + ">delete</a>";
				table +="</td>";
				table +="</tr>";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}

}
