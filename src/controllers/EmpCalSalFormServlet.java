package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpReadRecord;
import model.Employee;

/**
 * Servlet implementation class EmpCalSalFormServlet
 */
public class EmpCalSalFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpCalSalFormServlet() {
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
				      //Get the regNo
						int regNo = Integer.parseInt(request.getParameter("regNo"));
						
						//Create EmpReadRecord object
						EmpReadRecord rr = new EmpReadRecord("gym_management","root","apple12",regNo);
						
						//Use EmpReadRecord to get the data
						rr.doRead();
						Employee employee = rr.getEmployee();
						
						
						request.setAttribute("employee",employee);
						
						String url = "/EmployeeCalSalForm.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	}

}
