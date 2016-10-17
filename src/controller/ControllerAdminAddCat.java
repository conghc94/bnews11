package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import model.ModelCategory;

public class ControllerAdminAddCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerAdminAddCat() {
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
		
		if(request.getParameter("them")!=null){
			String name = request.getParameter("ten");//Mặc định ISO-8859-1
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			Category objCat = new Category(0,name);
			if(mCat.addItem(objCat) >0){//Thêm thành công
				System.out.println("Thêm thành công");
				response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=add1");
			}else{//Chưa thêm được
				System.out.println("Thêm thất bại");
				response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=add0");
			}
			
		}else{ //Ban đầu
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addCat.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
