package com.hos.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.reserDao;
import object.reserveinfo;

/**
 * Servlet implementation class deleteRes
 */
@WebServlet("/deleteRes")
public class deleteRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteRes() {
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
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try{
			
			 reserDao dao=new reserDao();
			 int i = Integer.parseInt(request.getParameter("m"));
			 Date d=null;
			 reserveinfo y=new reserveinfo(0,0,d,0,0,"null",0,"null");
			 if(dao.deleteUser(i)){
			        
				// String message="删除成功�?";
				  request.getSession().setAttribute("ser", y);	           			
				  request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
			 }
			    else{
            //   String message="删除失败";
               // request.getSession().setAttribute("ser", y);
	           //response.sendRedirect(request.getContextPath()+"/regFailed.jsp");
			    	
                request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
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
