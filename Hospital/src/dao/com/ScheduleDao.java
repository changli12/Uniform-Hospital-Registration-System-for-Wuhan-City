package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static boolean SelectSchedule(int doc_id) throws ClassNotFoundException
	{
		try
		{
			String sql="select * from schedule where doctor_id=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setInt(1,doc_id);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next())
			{
			do
			{
				System.out.println("星期一上午："+rs.getInt(3));
			}
			while(rs.next());
			return true;
			}
			System.out.println("查询不到科室信息");
			return false;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取科室信息异常");
		}
	}
}
