package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_IncomeUpdateQuery;
import model.Income;

/**
 * Servlet implementation class FinanceUpdate_IncomeServlet
 */
public class FinanceUpdate_IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceUpdate_IncomeServlet() {
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
		int incomeID = Integer.parseInt(request.getParameter("incomeID"));
		String title = request.getParameter("description");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		Income income = new Income();
		income.setId(incomeID);
		income.setDescription(title);
		income.setAmount(amount);
		
		Finance_IncomeUpdateQuery uq = new Finance_IncomeUpdateQuery("gym_management","root","apple12");
		uq.doUpdate(income);
		
		String url = "/FinanceRead_IncomeServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
