package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.MemberReadRecordQuery;
import model.Member;



/**
 * Servlet implementation class MemberUpdateFormServlet
 */
public class MemberUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateFormServlet() {
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
				
				
				     //Get the regNo
						int regid = Integer.parseInt(request.getParameter("regid"));
						
						//Create memberReadRecord object
						MemberReadRecordQuery rr = new MemberReadRecordQuery("gym_management","root","apple12",regid);
						
						//Use MemberReadRecord to get the book data
						rr.doRead();
						Member member = rr.getMember();
						
						//Pass member and Control to the MemberUpdateForm.jsp
						request.setAttribute("member",member);
				
				
				
						String url = "/MemberUpdateForm.jsp";
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	}

}
