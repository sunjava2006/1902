package com.thzhima.blog.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JdbcTemplate {

	private static BasicDataSource ds = null;
	private ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	static {
		Properties p = new Properties();
		InputStream in = JdbcTemplate.class.getResourceAsStream("/db.properties");
		try {
			p.load(in);
			BasicDataSourceFactory f = new BasicDataSourceFactory();
			ds = f.createDataSource(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public <T>  T select(String sql, ResultSetExtractor<T> ext, Object...args) throws SQLException {
		T o = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = this.getConnection();
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			rst = stm.executeQuery();
			o = ext.extract(rst);
			
		} catch (Exception e) {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				
				conn.close();
			}
		}
		return o;
	}
	
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		synchronized (local) {
			conn = local.get();
			if(null == conn) {
				conn = ds.getConnection();
				local.set(conn);
			}
		}
		
	     return conn;
	}
	
	public int update(String sql, Object...args) throws SQLException {
		int count = 0;
		Connection conn  = null;
		PreparedStatement stm = null;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			count = stm.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws SQLException {
		JdbcTemplate temp = new JdbcTemplate();
		Connection c = temp.getConnection();
		Connection c1 = temp.getConnection();
		
		System.out.println(c.isClosed());
		System.out.println(c == c1);
		
		c.close();
		c1.close();
	}
}
