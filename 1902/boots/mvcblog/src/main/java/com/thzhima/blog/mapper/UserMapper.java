package com.thzhima.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.thzhima.blog.bean.User;

@Mapper
public interface UserMapper {

	@Insert("insert into t_users(user_name, pwd)values(#{userName},#{pwd})")
	public int insert(User u);

	@Select("select count(*) from t_users where user_name=#{name}")
	public int findName(String name);
	
	@Select("select * from t_users where user_name=#{userName} and pwd=#{pwd}")
	@Results(id = "userResult",
	        value = {
	           @Result(column = "user_id", property = "userID", id = true),
	           @Result(column = "user_name", property = "userName"),
	           @Result(column = "pwd", property = "pwd"),
	           @Result(property = "blog", column = "user_id",
	                   one = @One(select = "com.thzhima.blog.mapper.BlogMapper.findByUserID", fetchType = FetchType.EAGER) )
	        })
	public User findByNameAndPwd(User u);
	
	@Select("select * from t_users limit #{from},#{len}")
	@ResultMap("userResult")
	public List<User> list(int from,int len);
	
	@SelectProvider(value=com.thzhima.blog.mapper.DianmicSqlProvider.class,
			        method = "findUserByExam")
	@ResultMap("userResult")
	public List<User> findByExample(User u);
}
