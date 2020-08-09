package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EmpAddQuery;
import DBHelpers.RegistrationQuery;
import model.Employee;
import model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPut(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Get the data
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String nic = request.getParameter("nic");
				String uname = request.getParameter("uname");
				String pwd = request.getParameter("password");
				
				
				//Setup an User object
				User u = new User();
				u.setFame(fname);
				u.setLname(lname);
				u.setNic(nic);
				u.setUname(uname);
				u.setPwd(pwd);
				
				
				
				RegistrationQuery rq = new RegistrationQuery("gym_management","root","apple12");
				
				
				rq.doAdd(u);
				
				
				
				String url = "/LoginForm.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
				
		
		
	}

}
