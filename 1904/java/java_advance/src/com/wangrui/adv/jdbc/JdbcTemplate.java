package com.wangrui.adv.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 模板模式
public class JdbcTemplate {
	
	public static int saveOrUpdate(String sql) throws SQLException {
		int count = -1; // 执行语言所影响的记录数。
		
		Connection conn = null;
		Statement stm = null;
		try {
			// 获取连接对象
			conn = ConnectionUtil.getConnection();
			// 创建语句对象
			stm = conn.createStatement();
			// 执行语句
			count = stm.executeUpdate(sql);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		// 返回结果
		return count;
	}
	
	public static List<Map<String, String>> listAll(String tableName) throws SQLException{
		List<Map<String, String>> list = new ArrayList<>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		String sql = "select * from " + tableName;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql); // 查询返回结果集对象.
			ResultSetMetaData mdata = rst.getMetaData(); // 元数据对象.
			int colCount = mdata.getColumnCount(); // 获取查询返回的列数
			while(rst.next()) {
				Map<String, String> map = new HashMap<>();
				for(int i=1;i<=colCount;i++) {
					Object value = rst.getObject(i); // 取每一列的值
					String colName = mdata.getColumnLabel(i); // 取每一列的列名
					map.put(colName, value.toString()); // 将列名为Key,添加到Map中.
				}
				list.add(map); // 将Map中保存的记录信息,添加到List中.
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
		return  list;
	}
	

}
