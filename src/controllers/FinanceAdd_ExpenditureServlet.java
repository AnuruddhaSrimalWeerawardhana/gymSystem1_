package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_ExpenditureAddQuery;
import model.Expenditure;

/**
 * Servlet implementation class FinanceAdd_ExpenditureServlet
 */
public class FinanceAdd_ExpenditureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceAdd_ExpenditureServlet() {
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
		
		Expenditure expenditure = new Expenditure();
		expenditure.setDescription(description);
		expenditure.setAmount(amount);
		
		Finance_ExpenditureAddQuery aq = new Finance_ExpenditureAddQuery("gym_management","root","apple12");
		
		aq.doAdd(expenditure);
		
		String url = "/FinanceRead_ExpenditureServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
