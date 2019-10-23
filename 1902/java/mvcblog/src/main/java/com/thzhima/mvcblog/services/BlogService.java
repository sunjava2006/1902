package com.thzhima.mvcblog.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.thzhima.mvcblog.beans.Blog;
import com.thzhima.mvcblog.dao.BlogDao;

@Service
public class BlogService {

	@Autowired
	private BlogDao dao;
	
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
		
		return dao.selectOne(sql, ext, userID);
	}
}
