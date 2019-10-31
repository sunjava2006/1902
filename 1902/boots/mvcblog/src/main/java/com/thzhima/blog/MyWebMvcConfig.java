package com.thzhima.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/regist_protocal").setViewName("regist_protocal");
		registry.addViewController("/registpage").setViewName("regist");
		registry.addViewController("/loginpage").setViewName("login");
		registry.addViewController("/applypage").setViewName("apply");
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		ResourceHandlerRegistration regis = registry.addResourceHandler("/**");
//		regis.addResourceLocations("classpath:/static/","file:/photos/"); // 这里设置了“ / ”根目录是资源目录。
//	}
	
	

}
