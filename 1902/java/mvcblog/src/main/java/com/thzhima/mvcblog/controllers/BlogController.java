package com.thzhima.mvcblog.controllers;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.thzhima.mvcblog.beans.Blog;
import com.thzhima.mvcblog.beans.User;
import com.thzhima.mvcblog.services.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@PostMapping("/apply")
	public ModelAndView apply(ModelAndView mv, 
			 @RequestParam(value="blogName", required = false) String blogName,
			 @RequestParam(required=false, value="photo")  CommonsMultipartFile photo,
			 HttpSession session
			                                ) throws Exception {
		ServletContext app = session.getServletContext();
		String path = app.getRealPath("/photos");
		System.out.println(path);
		String fileName = photo.getOriginalFilename();
		String surfix = fileName.substring(fileName.lastIndexOf("."));
		String newName = System.currentTimeMillis()+surfix;
		
		photo.getFileItem().write(new File(path, newName));
		User user = (User) session.getAttribute("userInfo");
		
		boolean ok = this.blogService.apply(user.getUserID(), blogName, newName);
		if(ok) {
			Blog b = this.blogService.findByUserID(user.getUserID());
			session.setAttribute("blogInfo", b);
		}
		mv.setViewName("redirect:/");
		return mv;
	}
}
