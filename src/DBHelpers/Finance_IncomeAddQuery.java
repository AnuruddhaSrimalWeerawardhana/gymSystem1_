package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Income;

public class Finance_IncomeAddQuery {
     

	public Connection connection;
	
	public Finance_IncomeAddQuery(String dbname,String uname,String pwd){
		String url = "jdbc:mysql://localhost:3307/" + dbname;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(Income income){
		String query = "insert into income (description,amount) values (?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, income.getDescription());
			ps.setDouble(2, income.getAmount());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
