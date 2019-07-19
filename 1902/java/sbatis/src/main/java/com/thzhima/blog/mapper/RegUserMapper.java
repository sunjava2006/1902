package com.thzhima.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

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
	
	@ResultMap("RegUserMap")
	@SelectProvider(type = com.thzhima.blog.mapper.SQLProvider.class, 
			method ="selectRegUser" )
	public List<RegUser> select(RegUser u);

	@SelectProvider(type = com.thzhima.blog.mapper.SQLProvider.class, 
			method = "ss")
	@ResultMap("RegUserMap")
	public List<RegUser> list2(String[] names);
	
	@UpdateProvider(type = com.thzhima.blog.mapper.SQLProvider.class,
			method = "update")
	public int updateExample(RegUser u);
	
	@InsertProvider(type=com.thzhima.blog.mapper.SQLProvider.class,
			method="insert")
	public int insert(RegUser u);
}
