package com.thzhima.mvcblog.controllers;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thzhima.mvcblog.beans.User;

@Controller
@SessionAttributes(names = {"USER_INFO"})
public class SessionController {

	@ModelAttribute(name = "USER_INFO") 
	public User user() {
		System.out.println("create User()................");
		return new User();
	}
	
	@RequestMapping("/todo")
	public String todo(@ModelAttribute(name = "USER_INFO") User user) {
		System.out.println(user);
		return "/Test";
	}
	
	@RequestMapping("/todo2")
	public String todo() {
		
		return "/Test";
	}
	
	@RequestMapping("/u")
	@ResponseBody
	public User ggg(User u) {
		return u;
	}
}
