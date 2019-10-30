package com.thzhima.blog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.mapper.UserMapper;

@SpringBootTest
class MvcblogApplicationTests {

	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	void findByNameAndPwd() {
//		User u = this.userMapper.findByNameAndPwd(new User(null, "wang", "123456"));
//		System.out.println(u);
//	}
//	
//	@Test
//	void list() {
//		List<User> list = this.userMapper.list(0, 2);
//		System.out.println(list);
//		
//	}
	
	@Test
	public void findByExample() {
		List<User> users = this.userMapper.findByExample(new User(null, "wang", "123456"));
		System.out.println(users);
	}

}
