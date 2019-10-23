package com.thzhima.mvcblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thzhima.mvcblog.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/regist")
	public String regist(String userName, String pwd) {
		System.out.println(userName + pwd);
		boolean ok = this.userService.registUser(userName, pwd);
		if(ok) {
			return "/RegistOk";
		}else {
			return "/Regist";
		}
		
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/Index";
	}
}
