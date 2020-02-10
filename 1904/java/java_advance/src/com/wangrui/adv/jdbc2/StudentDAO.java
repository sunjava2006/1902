package com.wangrui.adv.jdbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangrui.adv.entity.Student;

public class StudentDAO {

	public static Student select(String loginName, String pwd) throws SQLException {
		Student s = null;
		String sql= "select * from students "
				  + "where login_name=? and passwd=?";
		
		ResultSetExtractor<Student> ext = new ResultSetExtractor<Student>() {
			public Student extract(ResultSet rst) throws SQLException {
				Student s = null;
				while(rst.next()) {
					int studentID = rst.getInt("student_id");
					String studentName = rst.getString("student_name");
					String gender = rst.getString("gender");
					Date birthDate = rst.getDate("birth_date");
					String loginName = rst.getString("login_name");
					String passwd = rst.getString("passwd");
					s = new Student(studentID, studentName, gender, birthDate, loginName, passwd);
				}
				return s;
			}
		};
		
		s = JdbcTemplate.findOne(sql, ext, loginName, pwd);
		
		return s;
	}
	
	public static int add(String name, String gender, Date birthDate, String loginName,String pwd) throws SQLException {
		String sql = "insert into students(student_id, student_name, gender,birth_date, login_name, passwd)"
				   + " values(seq_students.nextval,?,?,?,?,?)";
	     return JdbcTemplate.saveOrUpdate(sql, name, gender, birthDate, loginName,pwd);
	}
	
	
	public static void main(String[] args) throws SQLException {
//		String loginName = "Jack";
//		String pwd = "123456";
//				
//		Student s = select(loginName,pwd);
//		System.out.println(s);
		System.out.println(add("李刚","男",new Date(1990-1900,2,3), "ligang", "123456"));
	}
}
