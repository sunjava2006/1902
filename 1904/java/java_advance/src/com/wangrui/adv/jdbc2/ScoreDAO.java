package com.wangrui.adv.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.adv.entity.Student;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ScoreDAO {

	// 调用 存储过程，返回number一个输出参数
	public static Integer findScore(int sid, int jid) throws SQLException {
		String sql = "{call p_find_score(?,?,?)}";
		Integer score = null;
		Connection c = null;
		CallableStatement stm = null;
		
		try {
			c = ConnectionUtil.getConnection();
			stm = c.prepareCall(sql);
			// 为输入参数赋值
			stm.setObject(1, sid);
			stm.setObject(2, jid);
			// 注册输出参数
			stm.registerOutParameter(3, Types.INTEGER);
			// 调用 
			stm.execute();
			// 获取输出参数的值
			score=stm.getInt(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != c) {
				c.close();
			}
		}
		
		return score;
	}
	
	public static <T>T dynamicSql(String sql, ResultSetExtractor<T> ext) throws SQLException {
		T t = null;
		Connection c = null;
		CallableStatement stm = null;
		ResultSet rst = null;
		try {
			c = ConnectionUtil.getConnection();
			stm = c.prepareCall("{call p_dysql(?,?)}");
			// 参数赋值
			stm.setString(1, sql);
			// 注册输出参数，游标参数类型在OracleTypes中定义。
			stm.registerOutParameter(2, OracleTypes.CURSOR);
			// 执行
			stm.execute();
			// 处理输出参数,游标就是结果集。
			rst = ((OracleCallableStatement)stm).getCursor(2);
			t = ext.extract(rst);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rst.close();
			stm.close();
			c.close();
		}
		return t;
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		String sql= "select student_id, student_name from students";
		
		ResultSetExtractor<List<Student>> ext = new ResultSetExtractor<List<Student>>() {

			@Override
			public List<Student> extract(ResultSet rst) throws SQLException {
				List<Student> list = new ArrayList<>();
				while(rst.next()) {
					int studentID = rst.getInt("student_id");
					String studentName = rst.getString("student_name");
					Student s  =new Student(studentID, studentName,null,null,null,null);
					list.add(s);
				}
				
				return list;
			}
			
		};
		
		List list = dynamicSql(sql, ext);
		System.out.println(list);
		
	}
}
