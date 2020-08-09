package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Income;

public class Finance_IncomeReadRecordQuery {

	private Connection connection;
	private ResultSet results;
	
	private Income income = new Income();
	private int incomeID;
	
	public Finance_IncomeReadRecordQuery(String dbName,String uname,String pwd,int incomeID) {
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		this.incomeID = incomeID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doRead(){
		String query = "select * from income where idincome = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, this.incomeID);
			this.results = ps.executeQuery();
			this.results.next();
			income.setId(this.results.getInt("idincome"));
			income.setDescription(this.results.getString("description"));
			income.setAmount(this.results.getDouble("amount"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Income getIncome(){
		return this.income;
	}

}
