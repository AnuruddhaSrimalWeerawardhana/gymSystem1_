package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpSalaryReadQuery;

/**
 * Servlet implementation class EmpReadSalaryServlet
 */
public class EmpReadSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpReadSalaryServlet() {
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
				//doGet(request, response);
						
						
						EmpSalaryReadQuery rq = new EmpSalaryReadQuery ("gym_management","root","apple12");
						
						rq.doRead();
						String table = rq.getHTMLTable();
						
						request.setAttribute("table",table);
						String url = "/EmployeeReadSalary.jsp";
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	}

}
