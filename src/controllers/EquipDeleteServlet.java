package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.EquipDeleteQuery;

/**
 * Servlet implementation class EquipDeleteServlet
 */
public class EquipDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipDeleteServlet() {
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
				int item_id =Integer.parseInt(request.getParameter("item_id"));
				// create a deleteQuery object
				EquipDeleteQuery dq= new EquipDeleteQuery("gym_equipment", "root", "apple12");
				// use deleteQuery to delete the record
				dq.doDelete(item_id);
				// pass execution on to the ReadServlet
			    String url = "/EquipReadServlet";
			    
			    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			    dispatcher.forward(request, response);
	}

}
