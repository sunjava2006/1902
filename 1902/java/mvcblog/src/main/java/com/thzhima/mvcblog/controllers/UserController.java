package com.thzhima.mvcblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/regist")
	public String regist(String userName, String pwd) {
		System.out.println(userName + pwd);
		return("/Regist");
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/Index";
	}
}
