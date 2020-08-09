package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.MemberDeleteQuery;

/**
 * Servlet implementation class MemberDeleteServlet
 */
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try{
		//get the RegNo
		int regNo = Integer.parseInt(request.getParameter("regid"));
		
		//create a DeleteQuery object
		MemberDeleteQuery dq = new MemberDeleteQuery("gym_management","root","apple12");
		
		//use DeleteQuery to delete the record
		dq.doDelete(regNo);
		//pass execution on to the ReadServlet
		String url = "/MemberReadServlet";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
		dispatcher.forward(request, response);
		}
		
		catch(NumberFormatException e){
			e.printStackTrace();
			
		}
		
	}

}
