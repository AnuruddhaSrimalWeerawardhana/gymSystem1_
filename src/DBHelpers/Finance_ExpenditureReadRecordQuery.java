package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Expenditure;

public class Finance_ExpenditureReadRecordQuery {
	private Connection connection;
	private ResultSet results;
	
	private Expenditure expenditure = new Expenditure();
	private int expenditureID;
	
	public Finance_ExpenditureReadRecordQuery(String dbName,String uname,String pwd,int expenditureID) {
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		this.expenditureID = expenditureID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doRead(){
		String query = "select * from expenditure where idexpenditure = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, this.expenditureID);
			this.results = ps.executeQuery();
			this.results.next();
			expenditure.setId(this.results.getInt("idexpenditure"));
			expenditure.setDescription(this.results.getString("description"));
			expenditure.setAmount(this.results.getDouble("amount"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Expenditure getExpenditure(){
		return this.expenditure;
	}

}
