package com.wangrui.adv.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static  String URL ;
	private static  String USER ;
	private static  String PWD ;
 	
	// 注册驱动
	static {
//		Driver driver = new org.mariadb.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		try {
			Properties p = new Properties();
			p.load(ConnectionUtil.class.getResourceAsStream("/db.properties"));
			URL = p.getProperty("url");
			USER = p.getProperty("user");
			PWD = p.getProperty("passwd");
			String driver = p.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USER, PWD);
		return conn;
	}
	
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		System.out.println(conn.isClosed());
		conn.close();
		System.out.println(conn.isClosed());
	}
	
}
