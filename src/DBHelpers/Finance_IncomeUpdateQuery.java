package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Income;

public class Finance_IncomeUpdateQuery {
	
	
	private Connection connection;
	
	public Finance_IncomeUpdateQuery(String dbName,String uname,String pwd){
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdate(Income income){
		String query = "update income set description=?, amount=? where idincome=?";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			
			ps.setString(1, income.getDescription());
			ps.setDouble(2, income.getAmount());
			ps.setInt(3,income.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


}
