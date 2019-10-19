package com.hos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import object.Department;
import object.Doctor;
import object.Reserveconfirm;
import object.hospital;
import object.patient;
import object.reserveinfo;

/**
 * Servlet implementation class Reserveshow
 */
public class Reserveshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserveshow() {
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
		
		int reserve_id=Integer.parseInt(request.getParameter("reserve_id"));
		patient pa=new patient();
	    Department dep=new Department();
	    Doctor doc=new Doctor();
	    hospital hos=new hospital();
	    reserveinfo res=new reserveinfo();
	    Reserveconfirm resfirm=new Reserveconfirm();
	    try {
	    	res=ReserveinfoDao.selectreserveinfobyId(reserve_id);
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    if(res!=null)
		{
			
			
		
	    try {
			doc=DoctorDao.selectDoctor(res.getDoc_id());
			pa=PatientDao.selectpatientbyId(res.getPatient_id());
			dep=DepartmentDao.selectDepartment(res.getDpa_id());
			hos=HospitalDao.selecHospital(res.getHop_id());
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	    resfirm.setDepart_name(dep.getDepart_name());
	    resfirm.setDoctor_name(doc.getDoctor_name());
	    resfirm.setHospital_name(hos.getHos_name());
	    resfirm.setPatient_name(pa.getPatient_name());
	    resfirm.setReserve_id(res.getReserve_id());
	    resfirm.setReserve_time(res.getReserve_time().toString());
	    request.getSession().setAttribute("reserveshow", resfirm);
	    response.sendRedirect("reserveshow.jsp");
		}
	    else
	    {
	    	 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out=response.getWriter();
			 out.print("<script type='text/javascript'>alert('查无此预约编号！');window.location='reservesearch.jsp';</script>");
	    }
	    
	}

}
