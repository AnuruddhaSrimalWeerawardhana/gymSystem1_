package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpAddQuery;
import model.Employee;

/**
 * Servlet implementation class EmpAddServlet
 */



public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAddServlet() {
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
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String maritalStatus = request.getParameter("maritalStatus");
		String sex = request.getParameter("sex");
		String jdate= request.getParameter("jdate");
		
		//Setup an Employee object
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDesignation(designation);
		employee.setAddress(address);
		employee.setTel(tel);
		employee.setMaritalStatus(maritalStatus);
		employee.setSex(sex);
		employee.setJoindate(jdate);
		
		//Setup am EmpAddQuery object
		EmpAddQuery aq = new EmpAddQuery("gym_management","root","apple12");
		
		//Pass the Employee to EmpAddQuery to add to the database
		aq.doAdd(employee);
		
		//Pass execution control to the ReadServlet
		String url = "/EmpReadServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}

}
