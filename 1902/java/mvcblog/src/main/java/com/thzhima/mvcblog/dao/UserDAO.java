package com.thzhima.mvcblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.thzhima.mvcblog.beans.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate temp;
	
	public int add(String sql, Object... args) {
		return this.temp.update(sql, args);
	}
	
	public User selectOne(String sql, Object[] args, ResultSetExtractor<User> ext) {
		User user = null;
		user = this.temp.query(sql, args, ext);
		return user;
	}
}
