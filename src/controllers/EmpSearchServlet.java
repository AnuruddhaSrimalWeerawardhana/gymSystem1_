package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpSearchQuery;

/**
 * Servlet implementation class EmpSearchServlet
 */
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchServlet() {
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
		
		String sq = request.getParameter("searchBox");
		
		EmpSearchQuery  es = new EmpSearchQuery("gym_management","root","apple12");
		es.doSearch(sq);
		String table = es.getHTMLTable();
		
		//Pass execution to EmployeeIndex along with the table
		request.setAttribute("table", table);
		
		//Pass execution to the EmpSearchServlet
		String url = "/EmployeeIndex.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
		dispatcher.forward(request, response);
		
	}

}
