package com.wangrui.adv.jdbc2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	public static void delStudent(int id) throws SQLException {
		String delScore = "delete from scores where student_id="+id;
		String delStu = "delete from students where student_id="+id;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.createStatement();
			// 身语句对象中添加多条DML语句
			stm.addBatch(delScore);
			stm.addBatch(delStu);
			// 多条语句一次性提交到数据库，一批执行。
			stm.executeBatch();
			
//			stm.clearBatch();
			
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
	}
	
	public static void main(String[] args) throws SQLException {
		delStudent(1);
	}
}
