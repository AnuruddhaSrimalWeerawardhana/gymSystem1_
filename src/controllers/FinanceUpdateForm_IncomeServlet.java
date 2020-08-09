package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_IncomeReadRecordQuery;
import model.Income;

/**
 * Servlet implementation class FinanceUpdateForm_IncomeServlet
 */
public class FinanceUpdateForm_IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceUpdateForm_IncomeServlet() {
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
		int incomeID = Integer.parseInt(request.getParameter("id"));
		Finance_IncomeReadRecordQuery rr = new Finance_IncomeReadRecordQuery("gym_management","root","apple12",incomeID);
		rr.doRead();
		
		Income income = rr.getIncome();
		
		request.setAttribute("income", income);
		
		String url = "/FinanceUpdateForm_Income.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
