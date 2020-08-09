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
 * Servlet implementation class EquipCalcFormServlet
 */
public class EquipCalcFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipCalcFormServlet() {
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
				      //Get the regNo
						int itemid = Integer.parseInt(request.getParameter("item_id"));
						
						//Create EmpReadRecord object
						EquipReadRecord rr = new EquipReadRecord("gym_equipment", "root", "apple12",itemid);
						
						//Use EmpReadRecord to get the data
						rr.doRead();
						Equipment equipment = rr.getEquipment();
						
						
						request.setAttribute("equipment",equipment);
						
						String url = "/EquipmentCalForm.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	}

}
