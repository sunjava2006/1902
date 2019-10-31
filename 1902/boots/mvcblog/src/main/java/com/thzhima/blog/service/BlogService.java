package com.thzhima.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.mapper.BlogMapper;

@Service
public class BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	public boolean applyBlog(Blog b) {
		boolean ok = false;
		if(this.blogMapper.add(b) == 1) {
			ok = true;
		}
		return ok;
	}
	
	public Blog findByUserID(int userID) {
		return this.blogMapper.findByUserID(userID);
	}
}
