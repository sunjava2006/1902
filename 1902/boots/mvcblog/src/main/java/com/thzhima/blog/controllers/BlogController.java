package com.thzhima.blog.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.thzhima.blog.bean.Blog;
import com.thzhima.blog.bean.User;
import com.thzhima.blog.service.BlogService;

@Controller
@SessionAttributes({"userInfo"})
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@PostMapping("/apply")
	public String applyBlog(MultipartFile photo,
			                 @ModelAttribute("userInfo") User user,
			                 String blogName,
			                 HttpSession session
			                ) {
		String view  = "redirect:/";
		ServletContext app = session.getServletContext();
		String path = "/photos";//app.getRealPath("/");
		File photoDir = new File(path);//new File(path, "photos");
		if(!photoDir.exists()) {
			photoDir.mkdirs();
		}
		
		String name = photo.getOriginalFilename();
		String surfix = name.substring(name.lastIndexOf("."));
		String newName = System.currentTimeMillis()+surfix;
		
		File newFile = new File(photoDir, newName);
		try {
			photo.transferTo(newFile);
			Blog b = new Blog(null, user.getUserID(), blogName, newName );
			
			if(this.blogService.applyBlog(b)) {
				Blog blog = this.blogService.findByUserID(user.getUserID());
				user.setBlog(blog);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(path);
		return view;
	}
	
}
