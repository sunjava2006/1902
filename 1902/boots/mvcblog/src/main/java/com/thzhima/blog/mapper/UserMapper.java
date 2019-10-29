package com.thzhima.blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.thzhima.blog.bean.User;

@Mapper
public interface UserMapper {

	@Insert("insert into t_users(user_name, pwd)values(#{userName},#{pwd})")
	public int insert(User u);

	@Select("select count(*) from t_users where user_name=#{name}")
	public int findName(String name);
	
}
