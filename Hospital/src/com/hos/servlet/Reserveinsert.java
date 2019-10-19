package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.ReserveinfoDao;
import object.reserveinfo;

/**
 * Servlet implementation class Reserveinsert
 */
public class Reserveinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserveinsert() {
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
		reserveinfo res=new reserveinfo();
		res=(reserveinfo) request.getSession().getAttribute("reserveinfo");
		String daytime=(String)request.getSession().getAttribute("daytime");
		try {
			if(ReserveinfoDao.UpdateReserveinfo(daytime,res.getDoc_id())&&ReserveinfoDao.AddReserveinfo(res))
			{
				response.setContentType("text/html;charset=utf-8");
				 PrintWriter out=response.getWriter();
				 out.print("<script type='text/javascript'>alert('预约成功！');window.location='index.jsp';</script>");
		    
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
