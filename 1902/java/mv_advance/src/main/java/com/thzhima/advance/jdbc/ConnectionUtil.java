package com.thzhima.advance.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class ConnectionUtil {

	private static BasicDataSource dataSource = null;
	
	static {
		try {
			Properties properties = new Properties();
			InputStream in = ConnectionUtil.class.getResourceAsStream("/config.properties");
			properties.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		Connection c = null;
		c = dataSource.getConnection();
		return c;
	}
	
}
