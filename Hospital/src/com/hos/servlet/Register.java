package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import dao.com.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("gbk");
		String username=request.getParameter("username");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String  idnumber=request.getParameter("idnumber");
		String password=request.getParameter("passwd");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		User user=new User();
		user.setPassword(password);
		user.setUser_name(phone);
		user.setSort("病人用户");
		patient patient=new patient();
		patient.setPatient_name(username);
		patient.setAge(age);
		patient.setEmail(email);
		patient.setId_number(idnumber);
		patient.setPatient_addr(address);
		patient.setPhone_number(phone);
		patient.setSex(sex);
		
		int max=0;
		try {
			max = UserDao.SelectMax();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.setUser_id(max+1);
		try {
			patient.setPatient_id(PatientDao.SelectMax()+1);
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		PrintWriter out = null;
		out = response.getWriter();
			try {
				if(PatientDao.AddPatient(patient)&&UserDao.AddUser(user))
				{
					out.print("<script>alert('恭喜您，注册成功！');window.location='../Hospital/login.jsp'</script>");
				}
				else
			   	{
			   		out.print("<script>alert('抱歉，注册失败！');window.history.back()</script>");
			   	}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
