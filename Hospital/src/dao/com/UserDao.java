package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.User;


public class UserDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
	public static boolean AddUser(User user) throws ClassNotFoundException
	{
		
		try
		{
			if(SelectUsername(user.getUser_name()))
			{
				System.out .println("该手机号码已被注册");
				return false;
			}
			String sql="insert into user_regist values(?,?,?,?)";//user_id已设置为自动增长，不需添加此字段
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setInt(1,user.getUser_id());
			ptmt.setString(2,user.getUser_name());
			ptmt.setString(3,user.getPassword());
			ptmt.setString(4,user.getSort());
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
	public static boolean SelectUser(String name,String pwd) throws ClassNotFoundException
	{
		try
		{
			String sql="select * from user_regist where user_name=? and password=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setString(2, pwd);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next())
			{
				System.out.println("登录正确");
				return true;
			}
			System.out.println("账户密码不对");
			return false;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取用户信息异常");
		}

	}
	public static User selectUser(String name,String pwd) throws ClassNotFoundException
	{
		User user=new User();
		try
		{
			String sql="select * from user_regist where user_name=? and password=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setString(2, pwd);
			ResultSet rs=ptmt.executeQuery();
			
			if(rs.next())
			{ 
				user.setUser_id(rs.getInt(1));
				user.setPassword(pwd);
				user.setSort(rs.getString(4));
				user.setUser_name(name);
				return user;
			}
			System.out.println("账户密码不对");
			return null;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取用户信息异常");
		}
	}
	public static boolean SelectUsername(String name) throws ClassNotFoundException
	{
		try
		{
			String sql="select * from user_regist where user_name=?";
			PreparedStatement ptmt=getConnection().prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next())
			{
				System.out.println("用户名已被占用，请换一个用户名");
				return true;
			}
			System.out.println("无重复用户名");
			return false;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("读取用户信息异常");
		}

	}
	public static int SelectMax() throws ClassNotFoundException, SQLException
	{
		int max=0;
		String sql="select MAX(user_id) from user_regist";
		PreparedStatement ptmt=getConnection().prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		if(rs.next())
		{max=rs.getInt(1);}
		return max;
	}	
	public static boolean deleteUser(String name)throws ClassNotFoundException, SQLException{
		  
        try {
        	String sq="DELETE FROM  user_regist  where user_name= ?";
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
	public List readFirstTitle(String name){
        List<User> list =new ArrayList<User>();
       
        
        try {
        	String sql1="select *  from  user_regist  where user_name= ? ";
        	PreparedStatement ptm=getConnection().prepareStatement(sql1);
             ptm.setString(1,name);
             ResultSet r=ptm.executeQuery();
             while(r.next())
            {
                int id=r.getInt("user_id");
                String nam=r.getString("user_name");
                String pwd=r.getString("password");
                String sort=r.getString("sort");
                User tl=new User(id, nam, pwd, sort);
                list.add(tl);
            }
            
        } catch (SQLException e) {
        	 System.out.println("hhhhhh");
            
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	 System.out.println("kkkkkkk");
		}
        
        return list;
    }
}
