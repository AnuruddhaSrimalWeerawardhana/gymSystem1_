package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Member;

public class MemberAddQuery {

	public Connection connection;
	
	public MemberAddQuery(String dbName, String uname, String pwd){
		 String url = "jdbc:mysql://localhost:3307/" + dbName;
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doAdd(Member member){
		
		String query = "insert into member_details (`name`, `address`, `age`,`gender`, `nic` ,`tel`) values (?,?,?,?,?,?)" ;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, member.getName());
			ps.setString(2, member.getAddress());
			ps.setInt(3, member.getAge());
			ps.setString(4, member.getGender());
			ps.setString(5, member.getNIC());
			ps.setString(6, member.getTel());
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
		
}
