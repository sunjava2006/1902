package com.thzhima.advance.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thzhima.advance.entity.Goods;
import com.thzhima.advance.entity.Kind;

import oracle.jdbc.OracleCallableStatement;

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
	
	
	public Kind find(int id) throws SQLException {
		Kind  k = null;
		Connection conn=null;
		Statement stm=null;
		ResultSet rst=null;
		try {
			conn=ConnectionUtil.getConnection();
//			conn.setAutoCommit(false);
			stm=conn.createStatement();
			rst=stm.executeQuery("select kind_name,id from t_kinds where id="+id);
			if(rst.next()) {
//				取游标中数据
				int idd = rst.getInt("id");
				String name = rst.getString("kind_name");
				
				// 创建一个对象
				k = new Kind(idd, name);
			}
//			conn.commit();
		}catch(SQLException ex) {
//			conn.rollback();
			ex.printStackTrace();
		}finally {
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
		return k;
	}
	
	
	public int[] deleteKind(int kindID) throws SQLException {
		int[] result = null;
		String sql1 = "delete t_goods where kind_id="+kindID;
		String sql2 = "delete t_kinds where id="+kindID;
		
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.createStatement();
			stm.addBatch(sql1); // 添加多条语句
			stm.addBatch(sql2);
			
			result = stm.executeBatch();  // 批量执行。
			conn.commit(); 
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
			return result;
		}
	}
	
	
	public String getKindName(int id) throws SQLException {
		String name = null;
		
		String sql = "{call p_get_name(?,?)}";
		Connection conn = null;
		CallableStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareCall(sql);
			stm.setInt(1, id);// 输入参数要赋值的。
			stm.registerOutParameter(2,Types.NVARCHAR); //输出参数是要注册的。
			
			stm.execute();
			
			name = stm.getString(2); // 取输出参数（第2个）的数据
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
			
		}
		
		
		return name;
	}
	
	
	
	
	
	

	public static void main(String[] args) throws SQLException {
		KindsDAO dao =new KindsDAO();
		
//		Object[] kind = dao.findByID(10);
//		if(null != kind) {
//			  Object id = kind[0];
//			  Object name = kind[1];
//			  System.out.println(id + ":" + name);
//		}
//		
//		System.out.println("=======================");
//		Map map = dao.findByName("工具");
//		System.out.println(map.get("ID"));
//		System.out.println(map.get("KIND_NAME"));
//	  
		
		Kind k = dao.find(20);
		if(null != k) {
			System.out.println(k.getID());
			System.out.println(k.getKindName());
		}
		
	}
	
}
