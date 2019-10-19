package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Department;

public class DepartmentDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static List SelectDepbyHos(int hos_id) throws ClassNotFoundException
	{
		try
		{
			List list;
			list=new ArrayList();
			Department dep;
			String sql="select depart_id,depart_name from department where hospital_id=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setInt(1,hos_id);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				dep=new Department();
				dep.setDepart_id(rs.getInt("depart_id"));
				dep.setDepart_name(rs.getString("depart_name"));
				list.add(dep);
			}
			System.out.println("读取科室");
			return list;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取科室信息异常");
		}
	}
	public static Department selectDepartment(int depart_id) throws ClassNotFoundException, SQLException{
		Department department=new Department();
		String sql="select * from department where depart_id=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setInt(1, depart_id);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next()){
		department.setDepart_id(depart_id);
		department.setHos_id(rs.getInt(2));
		department.setDepart_name(rs.getString(3));
		department.setSub_depart(rs.getString(4));
		return  department;
		}
		else
			System.out.println("dep查询为空");
			return null;
	}
}
