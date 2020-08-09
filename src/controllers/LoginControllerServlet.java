package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.LoginQuery;
import model.LoginBean;

/**
 * Servlet implementation class LoginControllerServlet
 */
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
		 
		String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
		 
		loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
		 loginBean.setPassword(password);
		 
		LoginQuery loginQuery = new LoginQuery(); //creating object for LoginDao. This class contains main logic of the application.
		 
		String userValidate = loginQuery.LoginQuery(loginBean); //Calling authenticateUser function
		 
		if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
		 {
		 request.setAttribute("userName", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		 request.getRequestDispatcher("/MainWebPage.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		 }
		 else
		 {
		 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returns other than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
		 request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);//forwarding the request
		 }
	}

}
