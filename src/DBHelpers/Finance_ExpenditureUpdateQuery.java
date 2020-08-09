package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Expenditure;

public class Finance_ExpenditureUpdateQuery {
	
	private Connection connection;
	
	public Finance_ExpenditureUpdateQuery(String dbName,String uname,String pwd){
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdate(Expenditure expenditure){
		String query = "update expenditure set description=?, amount=? where idexpenditure=?";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			
			ps.setString(1, expenditure.getDescription());
			ps.setDouble(2, expenditure.getAmount());
			ps.setInt(3,expenditure.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
