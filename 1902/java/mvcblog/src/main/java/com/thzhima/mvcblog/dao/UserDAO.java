package com.thzhima.mvcblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate temp;
	
	public int add(String sql, Object... args) {
		return this.temp.update(sql, args);
	}
}
