package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.MemberUpdateQuery;
import model.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//Get the data
				int regid = Integer.parseInt(request.getParameter("regNo"));
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");
				String nic = request.getParameter("nic");
				String tel = request.getParameter("tel");
				
				
				//Setup an member object
				Member member = new Member();
				member.setRegid(regid);
				member.setName(name);
				member.setAddress(address);
				member.setAge(age);
				member.setGender(gender);
				member.setNIC(nic);
				member.setTel(tel);
				
				
				//Setup am MemberAddQuery object
				MemberUpdateQuery aq = new MemberUpdateQuery("gym_management","root","apple12");
				aq.doUpdate(member);
				//Pass the Member to MemberAddQuery to add to the database
				//aq.doAdd(member);
				
				//Pass execution control to the ReadServlet
				String url = "/MemberReadServlet";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
	}

}
