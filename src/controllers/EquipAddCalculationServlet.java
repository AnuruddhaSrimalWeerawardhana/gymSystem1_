package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipCalculationAddQuery;
import model.EquipmentPrice;

/**
 * Servlet implementation class EquipAddCalculationServlet
 */
public class EquipAddCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipAddCalculationServlet() {
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
		int item_id = Integer.parseInt(request.getParameter("iid"));
		String name = request.getParameter("iname");
		double qty = Double.parseDouble(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
        double tot = Double.parseDouble(request.getParameter("tot"));
		
	
		
		
	
        EquipmentPrice eq = new EquipmentPrice();
        eq.setItem_no(item_id);
        eq.setName(name);
        eq.setQty(qty);
        eq.setPrice(price);;
        eq.setTotprice(tot);
        
		
		
		//Create an add query object  
        EquipCalculationAddQuery ad = new EquipCalculationAddQuery("gym_management","root","apple12");
		ad.doAdd(eq);
		
		//Pass control to the ReadServlet
		String url = "/EquipReadPriceServlet";
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
