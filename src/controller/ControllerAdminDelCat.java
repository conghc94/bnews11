package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;

/**
 * Servlet implementation class ControllerAdminDelCat
 */
@WebServlet("/ControllerAdminDelCat")
public class ControllerAdminDelCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDelCat() {
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
		ModelCategory mCat = new ModelCategory();
		int id =0;
		if(request.getParameter("cid")!=null){
			id = Integer.parseInt(request.getParameter("cid"));
		}
		if(mCat.delItem(id)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=del1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=del0");
		}
	}

}
