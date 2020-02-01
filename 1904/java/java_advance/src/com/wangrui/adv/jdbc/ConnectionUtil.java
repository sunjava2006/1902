package com.wangrui.adv.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String URL = "jdbc:mariadb://localhost:3306/locations";
	private static final String USER = "location";
	private static final String PWD = "123456";
 	
	// 注册驱动
	static {
//		Driver driver = new org.mariadb.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
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
