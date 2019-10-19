package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DoctorDao;
import dao.com.UserDao;
import object.Doctor;
import object.User;

/**
 * Servlet implementation class doctorRegister
 */
@WebServlet("/doctorRegister")
public class doctorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorRegister() {
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
		String doctor_name=request.getParameter("username");
		String sex=request.getParameter("sex");
		int  doctor_id=Integer.parseInt(request.getParameter("doctor_id"));
		String password=request.getParameter("passwd");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String doctor_post=request.getParameter("doctor_post");
		String doctor_specialty=request.getParameter("doctor_specialty");
	   int  depart_id=Integer.parseInt(request.getParameter("depart_id"));
		
		User user=new User();
		user.setPassword(password);
		user.setUser_name(Integer.toString(doctor_id));
		user.setSort("医生 用户");
		Doctor doctor=new Doctor();
		doctor.setDoctor_id(doctor_id);
		doctor.setDoctor_name(doctor_name);
		doctor.setEmail(email);
		doctor.setSex(sex);
		doctor.setTel(phone);
		doctor.setdepart_id(depart_id);
		doctor.setDoctor_post(doctor_post);
		doctor.setDoctor_specialty(doctor_specialty);
		
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

		PrintWriter out = null;
		out = response.getWriter();
			try {
				if(DoctorDao.AddDoctor(doctor)&&UserDao.AddUser(user))
				{
					out.print("<script>alert('添加医生成功！');window.location='../Hospital/manageIndex.jsp'</script>");
				}
				else
			   	{
			   		out.print("<script>alert('抱歉，添加失败！');window.history.back()</script>");
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
