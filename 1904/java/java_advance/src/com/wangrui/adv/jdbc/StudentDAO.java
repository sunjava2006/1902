package com.wangrui.adv.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDAO { //Database Access Object
	
	/**
	 * 添加学生，成功返回true,否则返回false
	 * @param name
	 * @param loginName
	 * @param pwd
	 * @return 成功返回true,否则返回false
	 * @throws SQLException 
	 */
	public static boolean addStudent(String name, String loginName, String pwd) throws SQLException {
		boolean ok = false;
		String sql = "insert into t_students (name, login_name, passwd)"
				   + " values ('"+name+"','"+loginName+"','"+pwd+"')";
		int count = JdbcTemplate.saveOrUpdate(sql);
		if(1==count) {
			ok = true;
		}
		return ok;
	}
	
	public static boolean updatePWd(String loginName, String pwd) throws SQLException {
		boolean ok = false;
		int count = -1;
		String sql = "update t_students set passwd='"+pwd
				    +"' where login_name='"+loginName+"'";
		count = JdbcTemplate.saveOrUpdate(sql);
		if(1 == count) {
			ok = true;
		}
		return ok;
	}
	
	public static List<Map<String, String>> listAllStudents() throws SQLException{
		return JdbcTemplate.listAll("t_students");
	}
	
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(addStudent("Huang", "HuangBing", "123456"));
//		System.out.println(updatePWd("wang", "abc"));
		
		List<Map<String, String>> list = listAllStudents();
		for(Map<String,String> m : list) {
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("login_name"));
		}
		
	}

}
