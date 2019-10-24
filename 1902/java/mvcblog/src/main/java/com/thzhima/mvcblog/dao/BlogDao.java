package com.thzhima.mvcblog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	
	public Blog findByUserID(int userID) {
		String sql = "select * from t_blogs where user_id=?";
		
		ResultSetExtractor<Blog> ext = new ResultSetExtractor<Blog>() {
			@Override
			public Blog extractData(ResultSet rs) throws SQLException, DataAccessException {
				Blog b = null;
				if(rs.next()) {
					Integer blogID = rs.getInt(1);
					Integer userID = rs.getInt(2);
					String blogName = rs.getString(3);
					String photo = rs.getString(4);
					b = new Blog(blogID, userID, blogName, photo);
				}
				return b;
			}
		};
		
		return this.selectOne(sql, ext, userID);
	}
	
	public int add(int userID, String blogName, String photoName) {
		String sql = "insert into t_blogs(blog_id, user_id,blog_name,photo)"
				+ "values(seq_blogs.nextval,?,?,?)";
		return this.tmp.update(sql, userID, blogName, photoName);
	}
	
}
