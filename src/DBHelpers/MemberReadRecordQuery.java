package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberReadRecordQuery {
	
	private Connection connection;
	private ResultSet results;
	private Member member = new Member();
	private int regNo;
	public MemberReadRecordQuery(String dbName, String uname, String pwd,int regNo){
		
		String url = "jdbc:mysql://localhost:3307/" + dbName;
		this.regNo = regNo;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url,uname,pwd);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public void doRead(){
		 String query = "select * from member_details where `regid`= ?";
		 
		 try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,this.regNo);
			this.results = ps.executeQuery();
			this.results.next();
			
	
			
			
			member.setRegid(this.results.getInt(1));
			member.setName(this.results.getString("name"));
			member.setAddress(this.results.getString("address"));
			member.setAge(this.results.getInt("age"));
			member.setGender(this.results.getString("gender"));
			member.setNIC(this.results.getString("nic"));
			member.setTel(this.results.getString("tel"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  }

	public Member getMember(){
		
		return this.member;
		
		
	}

}
