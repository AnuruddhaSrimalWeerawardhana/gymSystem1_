package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Finance_IncomeDeleteQuery {

	private Connection connection;
	public Finance_IncomeDeleteQuery(String dbName,String uname,String pwd){
		
		String url = "jdbc:mysql://localhost:3307/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection=DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void doDelete(int IncomeID){
		 String query = "delete from income where idincome = ?";
		 try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, IncomeID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
