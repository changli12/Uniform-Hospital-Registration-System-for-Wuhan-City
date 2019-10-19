package com.hos.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.com.reserDao;
import object.reserveinfo;
/**
 * Servlet implementation class reserServlet
 */
@WebServlet("/reserServlet")
public class reserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		reserDao dao=new reserDao();
		int res=0;    
		reserveinfo t;
		try {
				
				if(request.getParameter("textf")!=null)
				{
						res = Integer.parseInt(request.getParameter("textf"));
						List<reserveinfo> list =dao.readFirstTitle(res);  
						if(!list.isEmpty())
						{

							t=list.get(0);
							request.getSession().setAttribute("serinfo",t);
							request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
						}
						else
						{
							 Date d=null;
							 t=new reserveinfo(0,0,d,0,0,"null",0,"null");
							 PrintWriter out=response.getWriter();
							 request.getSession().setAttribute("serinfo",t);
					        out.println("<script>alert('±ß«∏√ª”–¥À‘§‘º±‡∫≈£°');window.location='../Hospital/manageIndex.jsp';</script>");
						}
						
						
						//request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
				}
			
			
				

	          
	        }	
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("error");
				
			}//ÊâßË°åÊ∑ªÂä†Êìç‰Ωú
            
		}		
}
