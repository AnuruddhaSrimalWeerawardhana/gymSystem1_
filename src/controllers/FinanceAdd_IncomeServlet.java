package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_IncomeAddQuery;
import model.Income;

/**
 * Servlet implementation class FinanceAdd_IncomeServlet
 */
public class FinanceAdd_IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceAdd_IncomeServlet() {
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
		String description = request.getParameter("description");
		double amount = Double.parseDouble(request.getParameter("amount"));
	
		Income income = new Income();
		income.setDescription(description);
		income.setAmount(amount);
		
		Finance_IncomeAddQuery aq = new Finance_IncomeAddQuery("gym_management","root","apple12");
		
		aq.doAdd(income);
		
		String url = "/FinanceRead_IncomeServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
