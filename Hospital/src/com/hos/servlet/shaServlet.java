package com.hos.servlet;
import dao.com.insertShaDao;
import object.shedule;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.UserDao;
import object.User;

/**
 * Servlet implementation class shaServlet
 */
@WebServlet("/shaServlet")
public class shaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
	
		int num =Integer.parseInt(request.getParameter("select2")) ;
		int id=Integer.parseInt(request.getParameter("docId"));
		try{
			
			insertShaDao  dao=new insertShaDao();
		
			shedule u=new shedule(0,"null",0);
			 if(dao.updateInsDoc(num,id)){
			        
				
				response.sendRedirect(request.getContextPath()+"/regSucess.jsp");
				 //request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
			 }
			    else{
               //String message="删除失败";
               //request.getSession().setAttribute("user", u);
	           response.sendRedirect(request.getContextPath()+"/regFailed.jsp");
			    	// response.sendRedirect("regFailed.jsp");
               //request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
	            }
			 //response.sendRedirect(request.getContextPath()+"/manageIndex.jsp");
			// request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
		  }
       
//	         ServletContext sc=getServletContext();
//	         RequestDispatcher rd=sc.getRequestDispatcher("/manageIndex.jsp");
//	         rd.forward(request,response);
	         //request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
	  
	          // request.getRequestDispatcher("hospital/WebContent/manageIndex.jsp").forward(request,response); 
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("error");
				
			}//执行添加操作
		
	}

}
