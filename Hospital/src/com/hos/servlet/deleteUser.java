package com.hos.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.com.*;
import object.*;
/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
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
			
			 UserDao dao=new UserDao();
			 String name = (String)request.getParameter("id");
			 User u=new User();//=new User(0,"null","null","null");
			 if(dao.deleteUser(name)&&PatientDao.deletePatient(name)){
			        
				 String message="删除成功�?";
				 request.getSession().setAttribute("uuser",u);
			       request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
				// response.sendRedirect(request.getContextPath()+"/regSucess.jsp");
			 }
			    else{
                //String message="删除失败";
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
