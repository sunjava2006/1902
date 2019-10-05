package com.thzhima.advance.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;


public class ConnectionUtil {
	static String url;
	static String user;
	static String password;
	
	static {
		InputStream inStream = null;
		try {// 注册驱动
			Driver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			
			//取出配置信息
			Properties p = new Properties();
			inStream = ConnectionUtil.class.getResourceAsStream("/config.properties");
			p.load(inStream);
			
			url = p.getProperty("url");
			user = p.getProperty("username");
			password = p.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
}
