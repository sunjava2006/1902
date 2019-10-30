package com.thzhima.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/regist_protocal").setViewName("regist_protocal");
		registry.addViewController("/registpage").setViewName("regist");
		registry.addViewController("/loginpage").setViewName("login");
	}
	
	

}
