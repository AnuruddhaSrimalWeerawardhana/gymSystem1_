package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipReadRecord;
import model.Equipment;

/**
 * Servlet implementation class EquipUpdateFormServlet
 */
public class EquipUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipUpdateFormServlet() {
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
		// get the item_id
		
		  int item_id = Integer.parseInt(request.getParameter("item_id"));
		
		// create ReadRecord to get equipment data
		  EquipReadRecord rr= new EquipReadRecord("gym_equipment", "root", "apple12", item_id);
		  
		// use ReadRecord to get equipment data
		  rr.doRead();
		  
		  Equipment equipment = rr.getEquipment();
		// pass Equipment and control to the update.jsp
		
		request.setAttribute("equipment", equipment);
		
		String url = "EquipmentUpdateForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
