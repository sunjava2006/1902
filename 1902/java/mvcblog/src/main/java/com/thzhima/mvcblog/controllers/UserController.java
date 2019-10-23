package com.thzhima.mvcblog.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.mvcblog.beans.Blog;
import com.thzhima.mvcblog.beans.User;
import com.thzhima.mvcblog.services.BlogService;
import com.thzhima.mvcblog.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(path = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(String userName, String pwd) {
		ModelAndView mv = new ModelAndView(); 
		System.out.println(userName + pwd);
		boolean ok = this.userService.registUser(userName, pwd);
		if(ok) {
			mv.setViewName("/RegistOk");
			mv.addObject("userName", userName);
			
		}else {
			mv.setViewName("/Regist");
			mv.addObject("smg", "注册失败");
		}
		return mv;
		
	}
	
	@PostMapping(path="/login" )
	public ModelAndView login(ModelAndView mv, User user, HttpSession session) {
		User u = this.userService.login(user);
		if(null == u) {
			mv.addObject("msg", "用户名或密码不正确。");
			mv.setViewName("Login");
		}else {
			session.setAttribute("userInfo", u);
			
			Blog blog = this.blogService.findByUserID(u.getUserID());
			session.setAttribute("blogInfo", blog);
			
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "/Index";
	}
}
