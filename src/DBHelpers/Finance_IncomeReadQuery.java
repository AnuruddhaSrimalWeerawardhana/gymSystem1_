package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Income;

public class Finance_IncomeReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public Finance_IncomeReadQuery(String dbName,String uname,String pwd){
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
		String quary = "select * from income";
		
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
	      table += "Income No";
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
				Income income = new Income();
				income.setId(this.results.getInt(1));
				income.setDescription(this.results.getString(2));
				income.setAmount(this.results.getDouble(3));
				
				table +="<tr>";
			    table += "<td>";
			    table += income.getId();
			    table += "</td>";
				table +="<td>";
				table +=income.getDescription();
				table +="</td>";
				table +="<td>";
				table +=income.getAmount();
				table +="</td>";
				table +="<td>";
					table += "<a href=FinanceUpdateForm_IncomeServlet?id=" + income.getId() + ">update</a> <a href=FinanceDelete_IncomeServlet?id=" + income.getId() + ">delete</a>";
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
