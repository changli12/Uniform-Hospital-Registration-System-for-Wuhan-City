package dao.com;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import object.Doctor;
import object.reserveinfo;


public class OrderDao{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/hospital";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		return connection;
	}
	public boolean updateOrder(String textinfo,int reserve_id) throws ClassNotFoundException
	{

	try{
       String sql="update reserveinfo set textinfo=? where reserve_id=?";
       PreparedStatement psmt=getConnection().prepareStatement(sql);
       psmt.setString(1, textinfo);
       psmt.setInt(2, reserve_id);
       psmt.executeUpdate();
       return true;
	}catch(SQLException e){
		 e.printStackTrace();
		 return false;
	 }
	
	}
	public List<reserveinfo> readFirstOrder(int doc_id) throws ClassNotFoundException
     {//显示医生界面所需预约信息
		
    	 List<reserveinfo> list =new ArrayList<reserveinfo>();
    	 Doctor doc=new Doctor();
    	 try {
			 doc=DoctorDao.selectDoctor(doc_id);
    		 String sql="select * from reserveinfo,patient where reserveinfo.patient_id=patient.patient_id and reserveinfo.depart_id="+doc.getdepart_id();
    		 PreparedStatement psmt=getConnection().prepareStatement(sql);
    		 //psmt.setInt(1, doc.getdepart_id());
    		 ResultSet rs=psmt.executeQuery(sql);
			 while (rs.next())
	    	 {
	    		 int reserve_id=rs.getInt("reserve_id");
	    		 String patient_name=rs.getString("patient_name");
	             String sex=rs.getString("sex");
	             int age=rs.getInt("age");
	             Date reserve_time=rs.getDate("reserve_time");
	             String textinfo=rs.getString("textinfo");
	             reserveinfo t1= new reserveinfo(reserve_id,patient_name,age,sex,reserve_time,textinfo);
	             list.add(t1);
	    	 
	    	 }
	    	 }catch(SQLException e)
    	     {
	    		 e.printStackTrace();
	    	 }
 		 return list;
     }
    	 
}

