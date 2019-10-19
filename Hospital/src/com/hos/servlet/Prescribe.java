package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.OrderDao;

/**
 * Servlet implementation class Prescribe
 */
public class Prescribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prescribe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("method");//获取<form>表单action传过来的值，根据不同action请求，调用不同方法
		
		System.out.println("post:"+action);
		
	 if(action.equals("add_textinfo"))
		{
		
		try {
			add_textinfo(request,response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		}

	}

	public void add_textinfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
		//添加预约成功的病人病历信息
		request.setCharacterEncoding("utf-8");
		OrderDao order=new OrderDao();
		String textinfo=request.getParameter("textinfo");
		Integer  reserve_id=Integer.parseInt(request.getParameter("reserve_id"));
		
	    //order.updateOrder(textinfo,reserve_id);
	    System.out.println(textinfo);
	    System.out.println(reserve_id);
	    
	    //order.updateOrder(textinfo,reserve_id);
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		if(order.updateOrder(textinfo,reserve_id))
		{
			out.print("<script type='text/javascript'>alert('添加病历成功');window.location='doctor.jsp';</script>");
		}
		else
		{
			
			out.print("<script type='text/javascript'>alert('添加病历失败');history.go(-1);</script>");
		}
		
	}
}


