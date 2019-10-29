package com.thzhima.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/regist")
	public String regist(User user, Model m) {
		String view = "/registOK";
		if( this.userService.regist(user)) {
			m.addAttribute("msg", user.getUserName()+"注册成功,已经发送激活邮件。");
			userService.sendEmailValidate(user);// 发送到MQ.
		}else {
			m.addAttribute("msg", user.getUserName()+"注册失败");
			view = "/regist";
		}
	
		return view;
	}
}
