package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Doctor;
import object.hospital;

public class DoctorDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static boolean deleteDoc(int id)throws ClassNotFoundException, SQLException{
		  
        try {
        	String sq="DELETE FROM  doctor  where doctor_id= ?";
        	PreparedStatement ptm=getConnection().prepareStatement(sq);
             ptm.setInt(1,id);
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
	public List readFirstTitle(int id){
        List<Doctor> list =new ArrayList<Doctor>();
       
        
        try {
        	String sql1="select *  from  doctor  where doctor_id= ? ";
        	PreparedStatement ptm=getConnection().prepareStatement(sql1);
             ptm.setInt(1,id);
             ResultSet r=ptm.executeQuery();
             while(r.next())
            {
               
                
                int doctor_id =r.getInt("doctor_id");
       		    String doctor_name=r.getString("doctor_name");
       		    String doctor_post=r.getString("doctor_post");
       		 String doctor_specialty=r.getString("doctor_specialty");
       		 String email=r.getString("email");
       		 String sex=r.getString("sex");
       		 String tel=r.getString("tel");
       		 int depart_id=r.getInt("depart_id");
                
               Doctor d=new Doctor(doctor_id,doctor_name,doctor_post, doctor_specialty,email,sex,tel,depart_id);
                list.add(d);
            }
            
        } catch (SQLException e) {
        	 System.out.println("hhhhhh");
            
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	 System.out.println("kkkkkkk");
		}
        
        return list;
    }
	public static List SelectDoctor(int depart_id,String datetime) throws ClassNotFoundException
	{
		try
		{
			Doctor doc;
			List list;
			list=new ArrayList();
			String sql="select d.doctor_id,d.doctor_name,d.doctor_post,d.doctor_specialty from doctor d,schedule s where d.doctor_id=s.doctor_id and s."+datetime+">0 and d.depart_id=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			System.out.println(depart_id);
			ptmt.setInt(1, depart_id);
			ResultSet rs=ptmt.executeQuery();
			System.out.println(sql);
			while(rs.next())
			{
				doc=new Doctor();
				doc.setDoctor_id(rs.getInt(1));
				doc.setDoctor_name(rs.getString(2));
				doc.setDoctor_post(rs.getString(3));
				doc.setDoctor_specialty(rs.getString(4));
				list.add(doc);
			}
			return list;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取医生信息异常");
		}
	}
	public static Doctor selectDoctor(int doctor_id) throws ClassNotFoundException, SQLException{
		Doctor doctor=new Doctor();
		String sql="select * from doctor where doctor_id=?";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ptmt.setInt(1, doctor_id);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next()){
		doctor.setDoctor_id(doctor_id);
		doctor.setDoctor_name(rs.getString(2));
		doctor.setDoctor_post(rs.getString(3));
		doctor.setDoctor_specialty(rs.getString(4));
		doctor.setEmail(rs.getString(5));
		doctor.setdepart_id(rs.getInt(6));
		doctor.setSex(rs.getString(7));
		doctor.setTel(rs.getString(8));
		System.out.println("doctor.getdepart_id():"+doctor.getdepart_id());
		
		return  doctor;
		}
		else
			return null;
	}
	public static boolean AddDoctor(Doctor doctor) throws ClassNotFoundException
	{
		
		try
		{
			if(selectDoctor(doctor.getDoctor_id())!=null)
			{
				System.out .println("该医生信息已被添加！");
				return false;
			}
			
			String sql="insert into doctor values(?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setLong(1,doctor.getDoctor_id());
			ptmt.setString(2,doctor.getDoctor_name());
			ptmt.setString(5,doctor.getEmail());
			ptmt.setInt(6, doctor.getdepart_id());
			ptmt.setString(7, doctor.getSex());
			ptmt.setString(8, doctor.getTel());
			ptmt.setString(3, doctor.getDoctor_post());
			ptmt.setString(4, doctor.getDoctor_specialty());
			ptmt.executeUpdate();
			System.out.println("添加成功");
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("添加用户信息异常");
		}
	
	}
}
