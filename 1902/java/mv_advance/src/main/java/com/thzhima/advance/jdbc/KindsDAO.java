package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class KindsDAO {
	
	public Object[] findByID(int id) throws SQLException {
		Object[] record = null;
		String sql = "select kind_name, id from t_kinds where id=" + id;
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			if(rst.next()) {
				int colCount = rst.getMetaData().getColumnCount();
				record = new Object[colCount];
				for(int i=1; i<=colCount; i++) {
					Object value = rst.getObject(i);
					record[i-1] = value;
				}
			}
		} catch (Exception e) {
			
		} finally {
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
		
		return record;
	}
	
	public Map<String, Object> findByName(String name) throws SQLException{
		Map<String, Object> map = null;
		Connection conn=null; 
		Statement stm=null;
		ResultSet rst=null;
		try {
			conn=ConnectionUtil.getConnection();
			stm=conn.createStatement();
			rst=stm.executeQuery(
					"select kind_name,id from t_kinds where kind_name='"+name+"'");
		while(rst.next()) {
			map = new HashMap();
//			map.put("id", rst.getInt("id"));
//			map.put("kindName", rst.getString("kind_name"));
			
			ResultSetMetaData md = rst.getMetaData();
			int count = md.getColumnCount();
			
			for(int i=1;i<=count; i++) {
				String label = md.getColumnLabel(i);
				Object value = rst.getObject(i);
				map.put(label,  value);
			}
			
		}	
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
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
		
		return map;
	}

	public static void main(String[] args) throws SQLException {
		KindsDAO dao =new KindsDAO();
		
		Object[] kind = dao.findByID(10);
		if(null != kind) {
			  Object id = kind[0];
			  Object name = kind[1];
			  System.out.println(id + ":" + name);
		}
		
		System.out.println("=======================");
		Map map = dao.findByName("工具");
		System.out.println(map.get("ID"));
		System.out.println(map.get("KIND_NAME"));
	  
	}
	
}
