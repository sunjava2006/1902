package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class First {

	public static void main(String[] args) throws SQLException {
		
	
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			
			conn = ConnUtil.getConn();// ConnectionUtil.getConnection();
			System.out.println(conn.isClosed());
			
			stm = conn.createStatement(); // 连接对象创建语句对象
			rst = stm.executeQuery("select a.id, a.kind_name from t_kinds a");
//			conn.close();
			//rst = stm.getResultSet();
			
			ResultSetMetaData md = rst.getMetaData(); // 元数据对象
			int colCount = md.getColumnCount();
			
		
			
			while(rst.next()) {
			
				for(int i=1;i<=colCount; i++) {
					System.out.println("表名:" + md.getTableName(i));
					String label = md.getColumnLabel(i);
					String type = md.getColumnTypeName(i);
					System.out.print(type + "  ");
					Object o = rst.getObject(i);
					System.out.print(label +":" + o + "   ");
					
				}
				System.out.println();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rst.close();
			stm.close();
			conn.close();
		}
		
	}
	
}
