package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DepartmentDao;
import dao.com.HospitalDao;
import object.hospital;

/**
 * Servlet implementation class Hosinfo
 */
public class Hosinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hosinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		System.out.println(action);
		hospital hos=new hospital();
		List list = null;
		try {
			hos=HospitalDao.SelectHosbyId(action);
			System.out.println(hos.getHos_addr());
			list=DepartmentDao.SelectDepbyHos(hos.getHos_id());
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getSession().setAttribute("hosinfo", hos);
		request.getSession().setAttribute("department", list);
		response.sendRedirect("hosreserve.jsp");
		

		
	}

}
