package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_ExpenditureReadRecordQuery;
import model.Expenditure;

/**
 * Servlet implementation class FinanceUpdateForm_ExpenditureServlet
 */
public class FinanceUpdateForm_ExpenditureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceUpdateForm_ExpenditureServlet() {
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
		int expenditureID = Integer.parseInt(request.getParameter("id"));
		Finance_ExpenditureReadRecordQuery rr = new Finance_ExpenditureReadRecordQuery("gym_management","root","apple12",expenditureID);
		rr.doRead();
		
		Expenditure expenditure = rr.getExpenditure();
		
		request.setAttribute("expenditure",expenditure);
		
		String url = "/FinanceUpdateForm_Expenditure.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
