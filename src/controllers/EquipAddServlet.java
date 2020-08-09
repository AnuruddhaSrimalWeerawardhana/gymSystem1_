package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipAddQuery;
import model.Equipment;

/**
 * Servlet implementation class EquipAddServlet
 */
public class EquipAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipAddServlet() {
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
		// get the data
		String item_name = request.getParameter("item_name");
		String body_part = request.getParameter("body_part");
		int qnt = Integer.parseInt(request.getParameter("qnt"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		// set up a equipment object
		
		Equipment equipment = new Equipment();
		equipment.setItem_name(item_name);
		equipment.setBody_part(body_part);
		equipment.setQnt(qnt);
		equipment.setPrice(price);
		
		// set up an addQuery object
		
		  EquipAddQuery aq = new EquipAddQuery("gym_equipment", "root", "apple12");
		
		// pass the equipment to the addQuery to add to the database
		    aq.doAdd(equipment);
		  
		  // pass execution control to the ReadServlet
		    
		    String url = "/EquipReadServlet";
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	        dispatcher.forward(request, response);
	}

}
