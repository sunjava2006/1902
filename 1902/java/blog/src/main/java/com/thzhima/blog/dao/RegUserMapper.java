package com.thzhima.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.thzhima.blog.bean.RegUser;

@Mapper
public interface RegUserMapper
{
	@Select("select * from reg_user where user_id=#{id}")
    RegUser findByID(int id);
	
	@Insert("insert into reg_user ")
	int insert(RegUser u);
}
