package com.wangrui.adv.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {

	public static int saveOrUpdate(String sql, Object ...args) throws SQLException {
		int count = -1;
		Connection c = null;
		PreparedStatement stm = null;
		try {
			c = ConnectionUtil.getConnection();
			c.setAutoCommit(false);
			stm = c.prepareStatement(sql);
			if(args != null) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			count = stm.executeUpdate();
			c.commit();
		} catch (Exception e) {
			c.rollback();
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.close();
			}
		}
		
		
		return count;
	}
	
	/**
	 * 对数据库进行insert、update、delete操作。
	 * @param sql ，要执行的SQL语句。
	 * @return int类型，返回操作影响的行数。
	 * @throws SQLException 
	 */
	public static int saveOrUpdate(String sql) throws SQLException {
		int count = -1;
		Connection c = null;
		Statement stm = null;
		try {
			c = ConnectionUtil.getConnection();
			c.setAutoCommit(false);// 添加事务处理
			stm = c.createStatement();
			count = stm.executeUpdate(sql);
			c.commit(); // 提交事务-保存到数据库中。
		} catch (Exception e) {
			c.rollback(); // 回滚事务-撤销所做的操作。
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.setAutoCommit(true);
				c.close();
			}
		}
		
		return count;
	}

	public static List<Map<String, Object>> list(String sql) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<>();
		Connection c = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			c = ConnectionUtil.getConnection();
			c.setAutoCommit(false);
			stm = c.createStatement();
			rst = stm.executeQuery(sql);
			while(rst.next()) {
				Map map = new HashMap<>();
				// 从结果集中，获取元数据对象。
				ResultSetMetaData md = rst.getMetaData();
				// 通过元数据，可以知道查询语句中返回的列数
				int colCount = md.getColumnCount();
				for(int i=1;i<=colCount;i++) {
					// 取出每列的列名
					String name = md.getColumnLabel(i);
					// 取出第列的值
					Object value = rst.getObject(i);
					map.put(name, value);
				}
				list.add(map);
			}
			c.commit();
		} catch (Exception e) {
			c.rollback();
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.setAutoCommit(true);
				c.close();
			}
		}
		return list;
	}
	
	public static Map<String, Object> selectOne(String sql) throws SQLException{
		Map<String, Object> map = null;
		Connection c = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			c = ConnectionUtil.getConnection();
			c.setAutoCommit(false);
			stm = c.createStatement();
			rst = stm.executeQuery(sql);
			if(rst.next()) {
				map = new HashMap<>();
				// 从结果集中，获取元数据对象。
				ResultSetMetaData md = rst.getMetaData();
				// 通过元数据，可以知道查询语句中返回的列数
				int colCount = md.getColumnCount();
				for(int i=1;i<=colCount;i++) {
					// 取出每列的列名
					String name = md.getColumnLabel(i);
					// 取出第列的值
					Object value = rst.getObject(i);
					map.put(name, value);
				}
			}
			c.commit();
		} catch (Exception e) {
			c.rollback();
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.setAutoCommit(true);
				c.close();
			}
		}
		return map;
	}
	
	
	public static <T> T findOne(String sql, ResultSetExtractor<T> ext, Object...args) throws SQLException {
		T o = null;
		Connection c = null;
		PreparedStatement stm = null;// 预编译语句对象,是Statement的子类
		ResultSet rst = null;
		try {
			c = ConnectionUtil.getConnection();
			c.setAutoCommit(false);
			stm = c.prepareStatement(sql); // 创建预编译语句对象。语句会在数据库进行预编译，语义确定了。。
			if(null != args) {// 判断语句是否有参数
				for(int i=0;i<args.length;i++) { // 遍历参数，为语句中每一个参数赋值。
					stm.setObject(i+1, args[i]);
				}
			}
			rst = stm.executeQuery();
			// 怎么将结果集对象中的数据转化成所要的对象。
			o = ext.extract(rst);
			c.commit();
		} catch (Exception e) {
			c.rollback();
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.setAutoCommit(true);
				c.close();
			}
		}
		return  o;
	}
	
	public static void main(String[] args) throws SQLException {
//		String sql = "insert into subjects(subject_id, subject_name)"
//				   + "values(seq_subjects.nextval, '4年级信息技术')";
//		saveOrUpdate(sql);
		
//		String sql = "select * from students where login_name='Jack' and passwd='123456'";
//		Map m = selectOne(sql);
//		System.out.println(m);
		
		System.out.println(list("select * from scores"));
	}
}
