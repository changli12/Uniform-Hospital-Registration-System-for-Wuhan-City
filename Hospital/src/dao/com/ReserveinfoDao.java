package dao.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import object.Department;
import object.Doctor;
import object.hospital;
import object.patient;
import object.reserveinfo;

public class ReserveinfoDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static boolean AddReserveinfo(reserveinfo re) throws ClassNotFoundException
	{
		
		try
		{
			String sql="insert into reserveinfo values(?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setInt(1,re.getReserve_id());
			ptmt.setInt(2,re.getPatient_id());
			Timestamp timeStamp = new Timestamp(re.getReserve_time().getTime());
			ptmt.setTimestamp(3,timeStamp);
			ptmt.setInt(4,re.getHop_id());
			ptmt.setInt(5,re.getDpa_id());
			ptmt.setString(6, re.getPatient_name());
			ptmt.setInt(7, re.getDoc_id());
			ptmt.setString(8, re.getTextinfo());
			
			ptmt.executeUpdate();
			System.out.println("预约信息添加成功");
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("添加预约信息异常");
		}
	}
	public static int SelectMax() throws ClassNotFoundException, SQLException
	{
		int max=0;
		String sql="select MAX(reserve_id) from reserveinfo";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{max=rs.getInt(1);
		System.out.println("max");
		}
		return max;
	}	
	public static boolean UpdateReserveinfo(String daytime,int doc_id) throws ClassNotFoundException
	{
		
		try
		{
			String sql="update schedule set "+daytime+"="+daytime+"-1 where doctor_id=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setInt(1,doc_id);
			
			ptmt.executeUpdate();
			System.out.println("schedule修改成功");
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("修改schedule信息异常");
		}
	}
	public static reserveinfo selectreserveinfobyId(int reserve_id) throws ClassNotFoundException, SQLException{
		reserveinfo res=new reserveinfo();
		String sql="select * from reserveinfo where reserve_id=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setInt(1, reserve_id);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next()){
			res.setReserve_id(reserve_id);
			res.setPatient_id(rs.getInt(2));
			res.setReserve_time(rs.getDate(3));
			res.setHop_id(rs.getInt(4));
			res.setDpa_id(rs.getInt(5));
			res.setPatient_name(rs.getString(6));
			res.setDoc_id(rs.getInt(7));
			res.setTextinfo(rs.getString(8));
		return  res;
		}
		else
			return null;
	}
	
}
