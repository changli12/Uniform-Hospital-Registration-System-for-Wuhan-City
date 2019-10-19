package com.hos.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DoctorDao;
import dao.com.UserDao;
//reserveinfo
import object.Doctor;

/**
 * Servlet implementation class deleteDoc
 */
@WebServlet("/deleteDoc")
public class deleteDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteDoc() {
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
		try{
			
			 DoctorDao dao=new DoctorDao();
			 int d =Integer.parseInt(request.getParameter("do"));
			 Doctor u=new Doctor(0,"null","null", "null","null","null","null",0);
			 if(dao.deleteDoc(d)&&UserDao.deleteUser(request.getParameter("do"))){
			        
				 String message="删除成功�?";
				 request.getSession().setAttribute("doin",u);
	           //response.sendRedirect(request.getContextPath()+"/manageIndex.jsp");
				 response.sendRedirect(request.getContextPath()+"/deleteSuc.jsp");
				//  request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
			 }
			    else{
                String message="删除失败";
               // request.getSession().setAttribute("doin", u);
	           //response.sendRedirect(request.getContextPath()+"/regFailed.jsp");
			    	response.sendRedirect("deleteFailed.jsp");
               // request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
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
