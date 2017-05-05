package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	
	//静态代码块执行注册驱动
	static{
		try {
		/*InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);模板代码操作properties文件*/
		
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username= prop.getProperty("username");
		password = prop.getProperty("password");
		
		Class.forName(driver);
		
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	
	//得到连接对象
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	
	//对三个对象进行销毁
	public static void release(Connection con,Statement st,ResultSet rs){
		
		if(rs!=null){
			try{
				rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			rs=null;
		}
		
		if(st!=null){
			try{
			st.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			st=null;
		}
		
		if(con!=null){
			try{
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			con=null;
		}
		
	}
	
}
