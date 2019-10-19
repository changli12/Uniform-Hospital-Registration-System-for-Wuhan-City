package com.hos.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DoctorDao;
import dao.com.reserDao;
import object.Doctor;



/**
 * Servlet implementation class doctorServlet
 */
@WebServlet("/doctorServlet")
public class doctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorServlet() {
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
		DoctorDao dao=new DoctorDao();
		int r=0;    
		Doctor t;
		try {
				
				if(request.getParameter("t")!=null)
				{
						r = Integer.parseInt(request.getParameter("t"));
						List<Doctor> list =dao.readFirstTitle(r);  
						if(!list.isEmpty())
						{

							t=list.get(0);
				         
						}
						else
						{
							 Date d=null;
							 t=new Doctor(0,"null","null", "null","null","null","null",0);
						}
						
						request.getSession().setAttribute("doc1",t);
				}
			
				else{

					 Date d=null;
					 t=new Doctor(0,"null","null", "null","null","null","null",0);
					 request.getSession().setAttribute("doc1",t);
					 
				}
	         request.getRequestDispatcher("manageIndex.jsp").forward(request,response);

	          
	        }	
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("error");
				
			}//执行添加操作
	}

}
