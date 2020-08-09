package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberReadQuery {
	
	private Connection connection;
	private ResultSet result;
	
	public MemberReadQuery(String dbName,String uname,String pwd) {
		
		String url ="jdbc:mysql://localhost:3307/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection =DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dbRead(){
		String query = "Select * from member_details";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.result =ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public String getHtmlTable() {
		String table ="";
		table +="<table border =1>";
		
		table += "<tr>";
		
		 table += "<th>";
	      table += "Regestration No";
	    table += "</th>";
		
	    table += "<th>";
	       table += "Member Name";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Address";
	    table += "</th>";
	    
	  
	    table += "<th>";
	       table += "Age";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Gender";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "NIC";
	    table += "</th>";
	    
	    table += "<th>";
	       table += "Telephone";
	    table += "</th>";
	 

	  
	  table += "</tr>";
   	
				
				try {
					while(this.result.next()) {
						Member member = new Member();
						member.setRegid(this.result.getInt("regid"));
						member.setName(this.result.getString("name"));
						member.setAddress(this.result.getString("address"));
						member.setAge(this.result.getInt("age"));
						member.setGender(this.result.getString("gender")); 
						member.setNIC(this.result.getString("nic")); 
						member.setTel(this.result.getString("tel")); 
						
						
						
						table += "<tr>";
						
						 table += "<th>";
					      table += member.getRegid();;
					    table += "</th>";
						
					    table += "<th>";
					       table += member.getName();;
					    table += "</th>";
					    
					    table += "<th>";
					       table +=member.getAddress() ;
					    table += "</th>";
					    
					  
					    table += "<th>";
					       table +=member.getAge() ;
					    table += "</th>";
					    
					    table += "<th>";
					       table +=member.getGender() ;
					    table += "</th>";
					    
					    table += "<th>";
					       table += member.getNIC();
					    table += "</th>";
					    
					    table += "<th>";
					       table += member.getTel();
					    table += "</th>";
					 
						
					    table += "<td>";
					       table+="<a href =MemberUpdateFormServlet?regid="+member.getRegid()+">UPDATE</a> "
					       		+ "	   <a href =MemberDeleteServlet?regid=" +member.getRegid()+">DELETE</a>";
					    table += "</td>";
					  
					  
					    
					  table += "</tr>";
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table +="</table>";
				return table;
	}
	


}
