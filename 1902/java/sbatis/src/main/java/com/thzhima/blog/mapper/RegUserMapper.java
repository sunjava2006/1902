package com.thzhima.blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.blog.bean.RegUser;

@Mapper
public interface RegUserMapper {
   
	@Select("select * from reg_user where user_id=#{id}")
	@Results({@Result(id=true, property="userID", column="user_id"),
			  @Result(property = "regName", column = "reg_name")
	})
	public RegUser findByID(int id);
	
	@Insert("insert into reg_user(reg_name, pwd, gender) values (#{regName}, #{pwd}, #{gender})")
	public int add(RegUser user);
	
}
