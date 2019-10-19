package dao.com;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import object.User;
import java.util.ArrayList;
import java.util.List;
import object.reserveinfo;
public class reserDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection conn=null;
		String Driver="com.mysql.jdbc.Driver";
	    String Url="jdbc:mysql://localhost:3306/hospital?characterEncoding=utf8&useSSL=false";
	    String User="root";
	    String Password="123";
	    
	    try{
	           
            Class.forName(Driver);
          conn=DriverManager.getConnection(Url,User,Password);
        }
        catch (Exception e) {
           
            System.out.println(e);
        }
	    return conn;       
		   
 }
	public List<reserveinfo> readFirstTitle(int resid){
        List<reserveinfo> list =new ArrayList<reserveinfo>();
       
        
        try {
        	String sql1="select *  from  reserveinfo  where reserve_id=? ";
        	PreparedStatement ptm=getConnection().prepareStatement(sql1);
             ptm.setInt(1,resid);
             ResultSet r=ptm.executeQuery();
             while(r.next())
            {
                
                
                int reserve_id=r.getInt("reserve_id");
            	 int patient_id=r.getInt("patient_id");
            	 Date reserve_time=r.getDate("reserve_time");
            	 int hospital_id=r.getInt("hospital_id") ;
            	 int depart_id=r.getInt("depart_id");
                 String patient_name=r.getString("patient_name");
            	 int doctor_id=r.getInt("doctor_id");
                 String textinfo=r.getString("textinfo");
                 reserveinfo  tl=new reserveinfo(reserve_id,
                		 patient_id,
                		 reserve_time,
                		 hospital_id ,
                		  depart_id,
                		 patient_name,
                	    doctor_id,
                		 textinfo);
                list.add(tl);
            }
            
        } catch (SQLException e) {
        	 System.out.println(e);
            
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	 System.out.println("kkkkkkk");
		}
        
        return list;
    }
	
	
	public static boolean deleteUser(int i)throws ClassNotFoundException, SQLException{
		  
        try {
        	String sq="DELETE FROM  reserveinfo  where reserve_id= ?";
        	PreparedStatement ptm=getConnection().prepareStatement(sq);
             ptm.setInt(1,i);
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
}
