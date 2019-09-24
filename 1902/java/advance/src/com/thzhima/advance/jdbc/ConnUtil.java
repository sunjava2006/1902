package com.thzhima.advance.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class ConnUtil {

	private static  DataSource pool;
	
	static {

		Properties p = new Properties();
		InputStream inStream = ConnectionUtil.class.getResourceAsStream("/config.properties");
		try {
			p.load(inStream);
			pool = BasicDataSourceFactory.createDataSource(p);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}
	
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		
		conn = pool.getConnection();
		
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection c = getConn();
		System.out.println(c.isClosed());
		c.close();
		
	}
}
