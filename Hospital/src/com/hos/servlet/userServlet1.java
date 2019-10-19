package com.hos.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.com.UserDao;
import object.User;

/**
 * Servlet implementation class userServlet1
 */
@WebServlet("/userServlet1")
public class userServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet1() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("textfield");
			        
		try {
			 UserDao dao=new UserDao();
			 User t;
		    List<User> list =dao.readFirstTitle(userName);  
	        if(list.isEmpty())
	        {
	        	System.out.println("empty");
	        	
	        	PrintWriter out=response.getWriter();
	        	out.println("<script>alert('抱歉没有此用户！');window.location='../Hospital/manageIndex.jsp';</script>");
	        	 t=new User(0,"null","null","null");
	        }
	        	
	        else
	        {
	        	System.out.println("!empty");
		        t=list.get(0);
		        request.getSession().setAttribute("ValueList",t);
			       request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
	        }
	         
	         //request.getSession().setAttribute("delete",t);
//	         ServletContext sc=getServletContext();
//	         RequestDispatcher rd=sc.getRequestDispatcher("/manageIndex.jsp");
//	         rd.forward(request,response);
	         //request.getRequestDispatcher("manageIndex.jsp").forward(request,response);
	  
	          // request.getRequestDispatcher("hospital/WebContent/manageIndex.jsp").forward(request,response); 
	          
	        }	
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("error");
				
			}//鎵ц娣诲姞鎿嶄綔
            
		}		
	}


