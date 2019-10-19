package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.patient;


public class PatientDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static int SelectMax() throws ClassNotFoundException, SQLException
	{
		int max=0;
		String sql="select MAX(patient_id) from patient";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{
			max=rs.getInt(1);
		}
		return max;
	}
	public static boolean SelectPatientname(String phonenumber) throws ClassNotFoundException
	{
		try
		{
			String sql="select * from patient where phone_number=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setString(1, phonenumber);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			return false;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取用户信息异常");
		}

	}
	
	public static String selectPatient(String phonenumber) throws ClassNotFoundException, SQLException
	{
		String sql="select patient_name from patient where phone_number=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setString(1, phonenumber);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{
		return rs.getString(1);
		}
		else
			return null;
	}
	public static boolean AddPatient(patient patient) throws ClassNotFoundException
	{
		
		try
		{
			if(SelectPatientname(patient.getPhone_number()))
			{
				System.out .println("该手机号码已被注册");
				return false;
			}
			String sql="insert into patient values(?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setLong(1,patient.getPatient_id());
			ptmt.setString(2,patient.getPatient_name());
			ptmt.setString(3,patient.getId_number());
			ptmt.setString(4, patient.getSex());
			ptmt.setLong(5, patient.getAge());
			ptmt.setString(6, patient.getPhone_number());
			ptmt.setString(7, patient.getEmail());
			ptmt.setString(8, patient.getPatient_addr());
			ptmt.executeUpdate();
			System.out.println("注册成功");
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("添加用户信息异常");
		}
	}
	public static boolean deletePatient(String name)throws ClassNotFoundException, SQLException{
		  
        try {
        	String sq="DELETE FROM  patient  where phone_number= ?";
        	PreparedStatement ptm=getConnection().prepareStatement(sq);
             ptm.setString(1,name);
            // ResultSet r=ptm.executeQuery();
             while(ptm.executeUpdate()>0)
            {
                return true;
            }
            
        } catch (SQLException e) {
        	 System.out.println("hhhhhh");
            
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	 System.out.println("kkkkkkk");
		}
        
        return false;
    }
	public static int selectPatientbyPhone(String phonenumber) throws ClassNotFoundException, SQLException
	{
		String sql="select patient_id from patient where phone_number=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setString(1, phonenumber);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{
			System.out.println(rs.getInt(1));
		return rs.getInt(1);
		}
		else
			return 0;
	}
	public static patient selectpatientbyId(int patient_id) throws ClassNotFoundException, SQLException{
		patient patient=new patient();
		String sql="select * from patient where patient_id=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setInt(1, patient_id);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next()){
		patient.setPatient_id(patient_id);
		patient.setPatient_name(rs.getString(2));
		patient.setId_number(rs.getString(3));
		patient.setSex(rs.getString(4));
		patient.setAge(rs.getInt(5));
		patient.setPhone_number(rs.getString(6));
		patient.setEmail(rs.getString(7));
		patient.setPatient_addr(rs.getString(8));
		return  patient;
		}
		else
			return null;
	}

}
