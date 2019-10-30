package com.thzhima.blog.service;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	public boolean regist(User user) {
		boolean ok = false;
		if(1 ==  this.userMapper.insert(user)) {
			ok = true;
		}
		return ok;
	}
	
	public boolean canUse(String name) {
		int c = this.userMapper.findName(name);
		return c==0 ? true:false;
	}
	
	public void sendEmailValidate(User user) {
		this.jmsTemplate.convertAndSend(this.queue, user);
	}
	
	public User login(User u) {
		return this.userMapper.findByNameAndPwd(u);
	}
}
