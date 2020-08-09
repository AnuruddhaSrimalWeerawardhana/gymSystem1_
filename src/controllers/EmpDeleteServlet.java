package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpDeleteQuery;

/**
 * Servlet implementation class EmpDeleteServlet
 */



public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDeleteServlet() {
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
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		
		//create a DeleteQuery object
		EmpDeleteQuery dq = new EmpDeleteQuery("gym_management","root","apple12");
		
		//use DeleteQuery to delete the record
		dq.doDelete(regNo);
		//pass execution on to the ReadServlet
		String url = "/EmpReadServlet";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
		dispatcher.forward(request, response);
		}
		
		catch(NumberFormatException e){
			e.printStackTrace();
			
		}
		
	}

}
