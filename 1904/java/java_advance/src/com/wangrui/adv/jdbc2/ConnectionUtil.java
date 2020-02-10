package com.wangrui.adv.jdbc2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	
	static {
	
		try {
			// 1、读取配置文件信息
			Properties p = new Properties();
			InputStream in = ConnectionUtil.class.getResourceAsStream("/oracle.properties");
			p.load(in);
			user = p.getProperty("user_name");
			password = p.getProperty("password");
			url = p.getProperty("url");
			driver = p.getProperty("driver");
			
			// 2、加载驱动
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection c = null;
		c = DriverManager.getConnection(url, user, password);
		return c;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection c = null;
		try {
			c = getConnection();
			System.out.println(c.isClosed());
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != c) {
				c.close();
			}
		}
		
	}
}
