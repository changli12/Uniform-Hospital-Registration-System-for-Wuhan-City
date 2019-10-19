package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DepartmentDao;
import dao.com.DoctorDao;
import dao.com.HospitalDao;
import dao.com.PatientDao;
import dao.com.ReserveinfoDao;
import dao.com.UserDao;
import object.Department;
import object.Doctor;
import object.Reserveconfirm;
import object.User;
import object.hospital;
import object.patient;
import object.reserveinfo;

/**
 * Servlet implementation class Reserveinfo
 */
public class Reserveinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserveinfo() {
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
		
		int doc_id=Integer.parseInt(request.getParameter("action"));
		System.out.println(doc_id);
		String sdatetime=(String) request.getSession().getAttribute("sdatetime");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date datetime = null;
		try {
			datetime = dateFormat.parse(sdatetime);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  
	    User user=new User();
	    user=(User)request.getSession().getAttribute("login");
	    //user.setUser_name("a");//整合时删掉
	    response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		if(user!=null)
	    {
	    patient pa=new patient();
	    Department dep=new Department();
	    Doctor doc=new Doctor();
	    hospital hos=new hospital();
	    reserveinfo res=new reserveinfo();
	    Reserveconfirm resfirm=new Reserveconfirm();
	    try {
			int patient_id=PatientDao.selectPatientbyPhone(user.getUser_name());
			doc=DoctorDao.selectDoctor(doc_id);
			System.out.println(doc.getdepart_id());
			pa=PatientDao.selectpatientbyId(patient_id);
			dep=DepartmentDao.selectDepartment(doc.getdepart_id());
			hos=HospitalDao.selecHospital(dep.getHos_id());
			int reserve_id=ReserveinfoDao.SelectMax()+1;
			
			resfirm.setDepart_name(dep.getDepart_name());
			resfirm.setDoctor_name(doc.getDoctor_name());
			resfirm.setHospital_name(hos.getHos_name());
			resfirm.setPatient_name(pa.getPatient_name());
			resfirm.setReserve_id(reserve_id);
			resfirm.setReserve_time(sdatetime);
			request.getSession().setAttribute("resfirm", resfirm);
			res.setDoc_id(doc_id);
			res.setDpa_id(dep.getDepart_id());
			res.setHop_id(hos.getHos_id());
			res.setPatient_id(patient_id);
			res.setPatient_name(pa.getPatient_name());
			System.out.println("res.getPatientName()"+res.getPatient_name());
			res.setReserve_time(datetime);
			res.setTextinfo("");
			res.setReserve_id(reserve_id);
			request.getSession().setAttribute("reserveinfo", res);
			

	    	    } catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		response.sendRedirect("confirm.jsp");
	    }
		else
		{
			out.print("<script>alert('请先登录！');window.location='../Hospital/login.jsp'</script>");

	    
		}
	}

}
