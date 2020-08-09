package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Finance_ExpenditureDeleteQuery {
	private Connection connection;
	public Finance_ExpenditureDeleteQuery(String dbName,String uname,String pwd){
		
		String url = "jdbc:mysql://localhost:3307/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection=DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void doDelete(int ExpenditureID){
		 String query = "delete from expenditure where idexpenditure = ?";
		 try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, ExpenditureID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
