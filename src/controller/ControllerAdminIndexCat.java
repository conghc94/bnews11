package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;

public class ControllerAdminIndexCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerAdminIndexCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelCategory mCat = new ModelCategory();
		request.setAttribute("alCat",mCat.getList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexCat.jsp");
		rd.forward(request, response);
	}

}
