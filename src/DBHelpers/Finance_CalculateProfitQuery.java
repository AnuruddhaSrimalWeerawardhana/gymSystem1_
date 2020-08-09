package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Expenditure;
import model.Income;

public class Finance_CalculateProfitQuery {
	
	private Connection connection;
	private ResultSet income_results;
	private ResultSet expenditure_results;
	
	public Finance_CalculateProfitQuery(String dbName,String uname,String pwd){
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
		String income_quary = "SELECT SUM(amount) FROM income";
		String expenditure_quary = "SELECT SUM(amount) FROM expenditure";
		
		try {
			PreparedStatement psi = this.connection.prepareStatement(income_quary);
			this.income_results = psi.executeQuery();
			
			PreparedStatement pse = this.connection.prepareStatement(expenditure_quary);
			this.expenditure_results = pse.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table = "Gym and Sports Management System";
		table += "<table border=1>";
		
		try {
			while(this.income_results.next()){
				Income income = new Income();
				income.setTotalAmount(this.income_results.getDouble(1));
							
				table +="<tr>";
			    table += "<td>";
			    table += "Total Income ";
			    table += "</td>";
			    table += "<td>";
			    table += income.getTotalAmount() ;
			    table += "</td>";
			    table +="</tr>";

			    while(this.expenditure_results.next()){
					Expenditure expenditure = new Expenditure();
					expenditure.setTotalamount(this.expenditure_results.getDouble(1));
								
					table +="<tr>";
				    table += "<td>";
				    table += "Total Expenditure ";
				    table += "</td>";
				    table += "<td>";
				    table += expenditure.getTotalamount();
				    table += "</td>";
				    table +="</tr>";
				    
				   
									
						table +="<tr>";
					    table += "<td>";
					    table += "Gross Profit ";
					    table += "</td>";
					    table += "<td>";
					    table += (income.getTotalAmount()-expenditure.getTotalamount());
					    table += "</td>";
					    table +="</tr>";
					    
					    table +="<tr>";
					    table += "<td>";
					    table += "  -TAX	(15%)";
					    table += "</td>";
					    table += "<td>";
					    table += "-(" + ((income.getTotalAmount()-expenditure.getTotalamount())*15/100) + ")";
					    table += "</td>";
					    table +="</tr>";
					    
						table +="<tr>";
					    table += "<td>";
					    table += "Net Profit ------------------------- ";
					    table += "</td>";
					    table += "<td>";
					    table += ((income.getTotalAmount()-expenditure.getTotalamount())-((income.getTotalAmount()-expenditure.getTotalamount())*15/100));
					    table += "</td>";
					    table +="</tr>";
					
			    }
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
	
}
