package com.thzhima.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thzhima.blog.bean.RegUser;
import com.thzhima.blog.dao.RegUserMapper;

@RestController
public class UserController {

	@Autowired
	private RegUserMapper userMapper;
	
	@RequestMapping("/findByID")
	public RegUser findbyid(int id) {
		return userMapper.findByID(id);
	}
}
