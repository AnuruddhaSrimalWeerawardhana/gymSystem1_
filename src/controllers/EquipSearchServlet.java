package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipSearchQuery;

/**
 * Servlet implementation class EquipSearchServlet
 */
public class EquipSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String sq = request.getParameter("search_query");
		
		EquipSearchQuery qq= new EquipSearchQuery("gym_equipment", "root", "apple12");
		
		qq.doSearch(sq);
		String sqtable = qq.getHTMLTable();
		// pass execution to read.jsp along with the table
		request.setAttribute("sqtable", sqtable);
		// pass execution on to the ReadServlet
	    String url = "/EquipReadServlet";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
