package com.thzhima.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.thzhima.blog.bean.RegUser;

@Mapper
public interface RegUserMapper {
	@Results(
		  id = "RegUserMap",
		  value={@Result(id=true, property="userID", column="user_id"),
		  @Result(property = "regName", column = "reg_name")
    })
	@Select("select * from reg_user where user_id=#{id}")
	public RegUser findByID(int id);
	
	@ResultMap(value = "RegUserMap")
	@Select("select * from reg_user")
	public List<RegUser> listAll();
	
	@Select("select * from reg_user where user_id=#{id}")
	public Map list(int id);
	
	
	@Insert("insert into reg_user(reg_name, pwd, gender) values (#{regName}, #{pwd}, #{gender})")
	public int add(RegUser user);
	
	@Update("update reg_user set reg_name=#{regName}, pwd=#{pwd} where user_id=#{userID}")
	public int update(String regName, String pwd, int userID);
	
}
