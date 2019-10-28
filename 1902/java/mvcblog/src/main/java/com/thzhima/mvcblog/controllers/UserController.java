package com.thzhima.mvcblog.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String regist(@ModelAttribute(name = "userName") String userName,
			                                @RequestParam("password") String pwd,
			                                Model m 
			                                 ) throws UnsupportedEncodingException {
		String view = "/RegistOk";
		//userName = new String(userName.getBytes("iso-8859-1"), "utf-8"); 
		System.out.println(userName + pwd);
		boolean ok = this.userService.registUser(userName, pwd);
		if(ok) {
			m.addAttribute("userName", userName);
//			m.addObject("userName", userName);
			
		}else {
			view= "/Regist";
			m.addAttribute("smg", "注册失败");
//			m.addObject("smg", "注册失败");
		}
		return view;
		
	}
	
	@RequestMapping(path="/login" , params = {"userName","pwd"} )
	public ModelAndView login(ModelAndView mv,User user, HttpSession session,
			                              boolean auto, HttpServletResponse response,
			                              @RequestHeader(name = "Referer", required = false) String referer) {
		if("http://localhost:8088/login.do".equals(referer) || "http://localhost:8088/Login.jsp".equals(referer)) {
			User u = this.userService.login(user);
			if(null == u) {
				mv.addObject("msg", "用户名或密码不正确。");
				mv.setViewName("Login");
			}else {
				session.setAttribute("userInfo", u);
				
				Blog blog = this.blogService.findByUserID(u.getUserID());
				session.setAttribute("blogInfo", blog);
				
				if(auto) {
					Cookie c = new Cookie("userName", u.getUserName());
					c.setMaxAge(10*24*60*60);
					
					Cookie c2 = new Cookie("pwd", u.getPwd());
					c2.setMaxAge(10*24*60*60);
					
					response.addCookie(c);
					response.addCookie(c2);
				}
				
				
				mv.setViewName("redirect:/");
			}
		}else {
			mv.setViewName("redirect:/Login.jsp");
			mv.addObject("msg", "别瞎玩！！！！！！！");
		}
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "/Index";
	}
}
