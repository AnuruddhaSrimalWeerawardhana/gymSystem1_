package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Expenditure;

public class Finance_ExpenditureAddQuery {
	
	public Connection connection;
	
	public Finance_ExpenditureAddQuery(String dbname,String uname,String pwd){
		String url = "jdbc:mysql://localhost:3307/" + dbname;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(Expenditure expenditure){
		String query = "insert into expenditure (description,amount) values (?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, expenditure.getDescription());
			ps.setDouble(2, expenditure.getAmount());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
