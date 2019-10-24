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
	
	/**
	 * 根据用户ID，查找博客。
	 * @param userID
	 * @return 如果存在Blog对象
	 */
	public Blog findByUserID(int userID) {
		return dao.findByUserID(userID);
	}
	
	/**
	 * 申请博客
	 * @param userID
	 * @param blogName
	 * @param photoName
	 * @return 成功返回true.
	 */
	public boolean apply(int userID, String blogName, String photoName) {
		boolean  ok = false;
		if(1 == this.dao.add(userID, blogName, photoName)) {
			ok = true;
		}
		return ok;
	}
}
