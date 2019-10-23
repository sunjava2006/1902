package com.thzhima.mvcblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.thzhima.mvcblog.beans.Blog;

@Repository
public class BlogDao {

	@Autowired
	private JdbcTemplate tmp;
	
	public Blog selectOne(String sql,ResultSetExtractor<Blog> ext, Object...args) {
		return tmp.query(sql, ext, args);
	}
	
}
