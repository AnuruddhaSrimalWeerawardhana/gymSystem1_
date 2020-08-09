package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpSalaryAddQuery;
import model.EmployeeSalary;

/**
 * Servlet implementation class EmpAddSalaryServlet
 */
public class EmpAddSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAddSalaryServlet() {
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
		
		//Get the form data 
		int regno = Integer.parseInt(request.getParameter("regno"));
		String name = request.getParameter("ename");
		double basic = Double.parseDouble(request.getParameter("basic"));
		double ot = Double.parseDouble(request.getParameter("otsal"));
		double atb = Double.parseDouble(request.getParameter("atb"));;
		double tot = Double.parseDouble(request.getParameter("tot"));
		
	
		
		
		//Setup an Salary object
		EmployeeSalary salary = new EmployeeSalary();
		salary.setRegNo(regno);
		salary.setName(name);
		salary.setBasic(basic);
		salary.setOtSal(ot);
		salary.setAtbonus(atb);
		salary.setTotSal(tot);
		
		
		//Create an add query object  
		EmpSalaryAddQuery ad = new EmpSalaryAddQuery("gym_management","root","apple12");
		ad.doAdd(salary);
		
		//Pass control to the ReadServlet
		String url = "/EmpReadSalaryServlet";
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
