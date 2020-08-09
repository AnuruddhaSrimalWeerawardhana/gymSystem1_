package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.Finance_ExpenditureUpdateQuery;
import model.Expenditure;

/**
 * Servlet implementation class FinanceUpdate_ExpenditureServlet
 */
public class FinanceUpdate_ExpenditureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceUpdate_ExpenditureServlet() {
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
		int expenditureID = Integer.parseInt(request.getParameter("expenditureID"));
		String title = request.getParameter("description");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		Expenditure expenditure = new Expenditure();
		expenditure.setId(expenditureID);
		expenditure.setDescription(title);
		expenditure.setAmount(amount);
		
		Finance_ExpenditureUpdateQuery uq = new Finance_ExpenditureUpdateQuery("gym_management","root","apple12");
		uq.doUpdate(expenditure);
		
		String url = "/FinanceRead_ExpenditureServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
