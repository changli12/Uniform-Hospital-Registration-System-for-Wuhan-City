package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.com.DoctorDao;
import dao.com.PatientDao;
import dao.com.UserDao;
import object.Doctor;
import object.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("gbk");
		User user=new User();
		
		HttpSession loginSession=request.getSession();
		loginSession.setMaxInactiveInterval(600);
		
		String username=request.getParameter("phone");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		String name=null;

		try {
			name=PatientDao.selectPatient(username);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PrintWriter out = null;
		out = response.getWriter();
	
		if(type.equals("病人用户"))
		{
			try {
				if(UserDao.SelectUser(username, password))
				{
					
					user=UserDao.selectUser(username, password);
					loginSession.setAttribute("login", user);
					loginSession.setAttribute("patientname", name);
					
					System.out.println(loginSession.getAttribute("login"));
					out.print("<script>alert('恭喜您，登录成功！');window.location='../Hospital/index.jsp'</script>");
				}
				else
				{
					out.print("<script>alert('抱歉，用户名或密码错误！');window.history.back()</script>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else if(type.equals("医生用户")){
			try {
				if(UserDao.SelectUser(username, password))
				{
					loginSession.setAttribute("login", user);
					Doctor doc=new Doctor();
					int doc_id=Integer.parseInt(username);
					try {
						doc=DoctorDao.selectDoctor(doc_id);
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					loginSession.setAttribute("nanadoctor", doc);
					System.out.println(loginSession.getAttribute("login"));
					out.print("<script>alert('恭喜您，登录成功！');window.location='../Hospital/doctor.jsp'</script>");
				}
				else
				{
					out.print("<script>alert('抱歉，用户名或密码错误！');window.history.back()</script>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				if(UserDao.SelectUser(username, password))
				{
					user=UserDao.selectUser(username, password);
					loginSession.setAttribute("login", user);
					System.out.println(loginSession.getAttribute("login"));
					out.print("<script>alert('恭喜您，登录成功！');window.location='../Hospital/manageIndex.jsp'</script>");
				}
				else
				{
					out.print("<script>alert('抱歉，用户名或密码错误！');window.history.back()</script>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
