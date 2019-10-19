package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.HospitalDao;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		List list;
		
		if(action.equals("first"))
		{
			try {
				HospitalDao HosDao=new HospitalDao();
				list=HosDao.SelectHos("all","all","all","");
				request.getSession().setAttribute("hossele", list);
				response.sendRedirect("search.jsp");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else
			if(action.equals("second"))
			{
				String region=request.getParameter("region");
				String hos_class=request.getParameter("hos_class");
				String depart=request.getParameter("depart");
				String mohusearch=request.getParameter("mohusearch");
				try {
					HospitalDao HosDao=new HospitalDao();
					list=HosDao.SelectHos(region, hos_class, depart,mohusearch);
					request.getSession().setAttribute("hossele", list);
					response.sendRedirect("search.jsp");
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		System.out.println("oops");
		//request.setAttribute("messages", messages);
		//request.getRequestDispatcher("search.jsp").forward(request,response);
	}

}
