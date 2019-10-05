package com.thzhima.advanceTest;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class ConnectionUtil {
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
	static String user = "test";
	static String password = "test";
	
	
	static {
		try {
			Driver driver = null;
			driver = new OracleDriver();

			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}
