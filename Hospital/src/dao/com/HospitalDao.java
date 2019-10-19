package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.hospital;



public class HospitalDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	
	public List SelectHos(String region,String hos_class,String depart,String mohusearch) throws ClassNotFoundException
	{
		try
		{
			hospital hos;
			List list;
			list=new ArrayList();
			String sql="select distinct h.hos_name,h.tel,h.hos_addr from hospital h,department d where h.hos_id=d.hospital_id ";
			
			if(!region.equals("all"))
			{
				sql+="and h.region='"+region+"'";
			}
			if(!hos_class.equals("all"))
			{
				sql+="and h.hos_class='"+hos_class+"'";
			}
			if(!depart.equals("all"))
			{
				sql+="and d.depart_name='"+depart+"'";
			}
			if(mohusearch!=null&&!(mohusearch.trim().equals("")))
			{
				sql+="and h.hos_name LIKE '%"+mohusearch+"%'";
			}
			System.out.println(sql);
			PreparedStatement ptmt=getConnection().prepareStatement(sql.toString());
			ResultSet rs=ptmt.executeQuery();
			
			while(rs.next())
			{
				hos=new hospital();
				hos.setHos_name(rs.getString("h.hos_name"));
				hos.setTel(rs.getString("h.tel"));
				hos.setHos_addr(rs.getString("h.hos_addr"));
				//hos.setHos_id(rs.getInt("hos_id"));
				//hos.setHos_class(hos_class);
				list.add(hos);
				System.out.println(hos.getHos_addr());
			}
			return list;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取医院信息异常");
		}
		
	}
	public static hospital SelectHosbyId(String name) throws ClassNotFoundException
	{
		try
		{
			hospital hos = null;
			String sql="select hos_name,hos_class,tel,hos_addr,hos_id from hospital where tel=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet rs=ptmt.executeQuery();
			
			if(rs.next()){
				hos=new hospital();
				hos.setHos_name(rs.getString("hos_name"));
				hos.setHos_class(rs.getString("hos_class"));
				hos.setTel(rs.getString("tel"));
				hos.setHos_addr(rs.getString("hos_addr"));
				hos.setHos_id(rs.getInt("hos_id"));
				System.out.println("testtest"+hos.getHos_addr());
				
			}
			
			return hos;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取医院信息异常");
		}
	}
	public static hospital selecHospital(int hos_id) throws ClassNotFoundException, SQLException{
		hospital hos=new hospital();
		String sql="select * from hospital where hos_id=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setInt(1, hos_id);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next()){
		hos.setHos_id(hos_id);
		hos.setHos_addr(rs.getString(2));
		hos.setTel(rs.getString(3));
		hos.setHos_name(rs.getString(4));
		hos.setRegion(rs.getString(5));
		hos.setHos_class(rs.getString(6));
		return  hos;
		}
		else
			return null;
	}

	
}
