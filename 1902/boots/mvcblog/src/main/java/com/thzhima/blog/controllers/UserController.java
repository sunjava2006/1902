package com.thzhima.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.UserService;

@Controller
@SessionAttributes({"userInfo"})
public class UserController {
	
	@Value("${server.port}")
	private int port;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userInfo")
	public User userInfo() {
		return new User();
	}

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
	
	@PostMapping("/login")
	public String login(@ModelAttribute("userInfo") User user, Model m) {
		System.out.println(this.port);
		String view = "/index";
		User u = this.userService.login(user);
		if(null != u) {
			user.setUserID(u.getUserID());
			user.setEmail(u.getEmail());
		}else {
			view = "/login";
			m.addAttribute("msg", "用户名或密码不正确");
		}
		return view;
	}
	
}
