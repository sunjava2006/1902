package com.thzhima.blog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thzhima.bean.User;
import com.thzhima.blog.dao.JdbcTemplate;
import com.thzhima.blog.dao.ResultSetExtractor;

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
	
	public User logon(String userName, String pwd) throws SQLException {
		User u = null;
		String sql = "select * from t_users where user_name=? and pwd=?";
		ResultSetExtractor<User> ext = new ResultSetExtractor<User>() {
			@Override
			public User extract(ResultSet rst) throws SQLException {
				User u = null;
				if(rst.next()) {
					Integer id = rst.getInt("id");
					String name = rst.getString("user_name");
					String pwd = rst.getString("pwd");
					u = new User(id, name, pwd);
				}
				return u;
			}
		};
		
		u = this.temp.select(sql, ext, userName, pwd);
		return u;
	}
	
}
