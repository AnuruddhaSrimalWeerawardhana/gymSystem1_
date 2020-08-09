package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DBHelpers.EmpUpdateQuery;
import model.Employee;

/**
 * Servlet implementation class EmpUpdateServlet
 */
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateServlet() {
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
		
		//Get the form data 
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String maritalStatus = request.getParameter("maritalStatus");
		String sex = request.getParameter("sex");
		String joinDate = request.getParameter("jdate");
		
		//Setup an Employee object
		Employee employee = new Employee();
		employee.setRegNo(regNo);
		employee.setName(name);
		employee.setDesignation(designation);
		employee.setAddress(address);
		employee.setTel(tel);
		employee.setMaritalStatus(maritalStatus);
		employee.setSex(sex);
		employee.setJoindate(joinDate);
		
		//Create an update query object  and use it to update the employee
		EmpUpdateQuery uq = new EmpUpdateQuery("gym_management","root","apple12");
		uq.doUpdate(employee);
		
		//Pass control to the ReadServlet
		String url = "/EmpReadServlet";
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
