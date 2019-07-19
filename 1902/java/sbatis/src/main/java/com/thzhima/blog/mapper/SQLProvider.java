package com.thzhima.blog.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.thzhima.blog.bean.RegUser;

public class SQLProvider {
	
	public String insert(RegUser u) {
		SQL sql = new SQL();
		sql.INSERT_INTO("reg_user");
		if(null != u.getUserID()) {
			sql.VALUES("user_id", "#{userID}");
		}
		if(null != u.getRegName()) {
			sql.VALUES("reg_name", "#{regName}");
		}
		if(null != u.getPwd()) {
			sql.VALUES("pwd", "#{pwd}");
		}
		if(null != u.getGender()) {
			sql.VALUES("gender", "#{gender}");
		}
		
		String s = sql.toString();
		System.out.println(s);
		return s;
	}

	public String selectRegUser(RegUser user) {
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM("reg_user");
		if(null != user.getRegName()) {
			sql.WHERE("reg_name=#{regName}");
		}
		if(null != user.getPwd()) {
			sql.WHERE("pwd=#{pwd}");
		}
		
		String s = sql.toString();
		System.out.println(s);
		return s;
	}
	
	// 根据注册名，按or查询匹配的人
	public String ss(Map names) {
		String s = "";
		SQL sql = new SQL();
		
		sql.SELECT("*").FROM("reg_user");
		//sql.OR();
		String[] array = (String[])(names.get("array"));
		
		for(int i=0;i<array.length;i++) {
			String str = array[i];
			sql.WHERE("reg_name='"+str+"'");
			if(i<array.length-1) {
			   sql.OR();
			}
		}
		s = sql.toString();
		System.out.println(s);
		return s;
	}
	
	public String update(RegUser u) {
		SQL sql = new SQL();
		
		sql.UPDATE("reg_user");
		if(null != u.getRegName()) {
			sql.SET("reg_name=#{regName}");
		}
		if(null != u.getPwd()) {
			sql.SET("pwd=#{pwd}");
		}
	    if(u.getUserID()!=null) {
	    	sql.WHERE("user_id=#{userID}");
	    }

		String s = sql.toString();
		System.out.println(s);
		return s;
	}
	
	
}
