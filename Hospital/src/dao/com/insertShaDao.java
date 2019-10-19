package dao.com;
import java.sql.Connection;
import object.shedule;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import object.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import object.getWeekDate;
public class insertShaDao {
              
	public static boolean updateInsDoc(int num,int id)throws ClassNotFoundException, SQLException{
		 getWeekDate d=new getWeekDate();
		Date a=new Date();
		 String s=d.getWeekOfDate(a);	
        try {
        	String sq="update  schedule   set "+s+"= ? where doctor_id=? ";
        	PreparedStatement ptm=getConnection().prepareStatement(sq);
             ptm.setInt(1,num);
             ptm.setInt(2,id);
             
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
	public static List InsertDoc()throws ClassNotFoundException, SQLException{
		 getWeekDate d=new getWeekDate();
		 Date a=new Date();
		 String s=d.getWeekOfDate(a);	
		  List<shedule> list =new ArrayList<shedule>();
       try {
       	String sq="select doctor_id ,doctor_name ,"+s+" from schedule ";
       	PreparedStatement ptm=getConnection().prepareStatement(sq);
            ResultSet r=ptm.executeQuery();
            while(r.next())
           {
            	int docI=r.getInt("doctor_id");
            	String name=r.getString("doctor_name");
            	int numm=r.getInt(s);
            	shedule uu=new shedule(docI,name,numm);
                list.add(uu);
           }
          
       } catch (SQLException e) {
       	 System.out.println(e);
           
       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
       	 System.out.println("kkkkkkk");
		}
       
       return list;
   }
	
}
