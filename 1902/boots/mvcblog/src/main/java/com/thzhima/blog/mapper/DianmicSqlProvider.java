package com.thzhima.blog.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.blog.bean.User;

public class DianmicSqlProvider {

	public String findUserByExam(User u) {
		SQL sql = new SQL();
		sql.SELECT("*").FROM("t_users");
		if(u.getUserID()!=null) {
			sql.WHERE("user_id=#{userID}");
		}else {
			if(u.getUserName()!=null) {
				sql.WHERE("user_name=#{userName}");
			}
			if(u.getPwd()!=null) {
				sql.WHERE("pwd=#{pwd}");
			}
		}
		
		return sql.toString();
	}
}
