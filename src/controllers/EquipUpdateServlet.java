package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipUpdateQuery;
import model.Equipment;

/**
 * Servlet implementation class EquipUpdateServlet
 */
public class EquipUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// get the form data and set equipment object
		
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		String item_name= request.getParameter("item_name");
		String body_part = request.getParameter("body_part");
		int qnt = Integer.parseInt(request.getParameter("qnt"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		Equipment equipment = new Equipment();
		equipment.setItem_id(item_id);
		equipment.setItem_name(item_name);
		equipment.setBody_part(body_part);
		equipment.setQnt(qnt);
		equipment.setPrice(price);
		
		
		// create an UpdateQuary object and use it to update the equipment
		
		EquipUpdateQuery uq= new EquipUpdateQuery("gym_equipment","root" ,"apple12");
		uq.doUpdate(equipment);
		// pass control on to the ReadServlet
		
		String url = "/EquipReadServlet";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
