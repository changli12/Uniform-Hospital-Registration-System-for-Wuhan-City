package dao.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/hospital?"+"&user=root&password=123&useUnicode=true&amp;characterEncoding=GBK;";
		connection=DriverManager.getConnection(url,"root","123");//数据库地址连接数据库
		System.out.println("");
		
		return connection;
	}
}
