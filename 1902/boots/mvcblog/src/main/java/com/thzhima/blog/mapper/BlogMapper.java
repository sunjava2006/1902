package com.thzhima.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.blog.bean.Blog;

@Mapper
public interface BlogMapper {


	@Select("select * from t_blogs where user_id=#{userID}")
	@Results(id = "blogResult",
	         value = {
	        		 @Result(column = "blog_id", property = "blogID", id = true),
	        		 @Result(column = "user_id", property = "userID"),
	        		 @Result(column = "blog_name", property = "blogName"),
	        		 @Result(column = "photo", property = "photo")
	         })
	public Blog findByUserID(int userID);
	
}
