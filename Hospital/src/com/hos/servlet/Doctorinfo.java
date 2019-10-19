package com.hos.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.com.DepartmentDao;
import dao.com.DoctorDao;
import dao.com.HospitalDao;
import object.Doctor;
import object.hospital;

/**
 * Servlet implementation class Doctorinfo
 */
public class Doctorinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctorinfo() {
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
		int depart_id=Integer.parseInt(request.getParameter("depart_id"));
		String reservedate=request.getParameter("reservedate");
		String reservetime=request.getParameter("reservetime");
		String reservetime2 = null;
		if(reservetime.equals("1"))
		{
			reservetime2="08:30:00";
		}
		if(reservetime.equals("2"))
		{
			reservetime2="13:30:00";
		}
		String sdatetime=reservedate+" "+reservetime2;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = null;
		try {
			date = dateFormat.parse(reservedate);
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		int day=calendar.get(Calendar.DAY_OF_WEEK);
		String sign=Integer.toString(day);
		String sign2=sign+reservetime;
		String daytime = null;
		System.out.println(sign2);
		switch(sign2){
			 case "21":
				 daytime="Mon1";
				 break; 
			 case "22":
				 daytime="Mon2";
				 break;
			 case "31":
				 daytime="Tues1";
				 break;
			 case "32":
				 daytime="Tues2";
				 break;
			 case "41":
				 daytime="Wed1";
				 break;
			 case "42":
				 daytime="Wed2";
				 break;
			 case "51":
				 daytime="Thur1";
				 break;
			 case "52":
				 daytime="Thur2";
				 break;
			 case "61":
				 daytime="Fri1";
				 break;
			 case "62":
				 daytime="Fri2";
				 break;
			 case "71":
				 daytime="Sat1";
				 break;
			 case "72":
				 daytime="Sat2";
			 case "11":
				 daytime="Sun1";
				 break;
			 case "12":
				 daytime="Sun2";
				 break;
			 default : 			}
		List list = null;
		if(daytime!=null)
		{
		try {
			System.out.println(depart_id);
			list=DoctorDao.SelectDoctor(depart_id, daytime);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getSession().setAttribute("daytime",daytime);
		request.getSession().setAttribute("doctor", list);
		request.getSession().setAttribute("sdatetime", sdatetime);
		System.out.println("searchdoctorsuccessful");
		
		}
		
		response.sendRedirect("hosreserve.jsp");
	}

}
