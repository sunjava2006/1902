package com.thzhima.blog.service;

import java.sql.SQLException;

import com.thzhima.blog.dao.JdbcTemplate;

public class UserService {

	private JdbcTemplate temp ;
	
	public UserService() {
		this.temp = new JdbcTemplate();
	}
	
	public boolean regist(String userName, String pwd) {
		int count = 0;
		String sql = "insert into t_users(id, user_name, pwd) values(seq_users.nextval, ?,?) ";
		try {
			count = this.temp.update(sql, userName, pwd);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}
}
