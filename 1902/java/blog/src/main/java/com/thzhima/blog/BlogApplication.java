package com.thzhima.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thzhima.blog.bean.RegUser;
import com.thzhima.blog.dao.RegUserMapper;

@SpringBootApplication
//@MapperScan(value = {"com.thzhima.blog"})
public class BlogApplication //implements CommandLineRunner 
{

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	private RegUserMapper map;
	public BlogApplication(RegUserMapper map) {
		this.map = map;
	}


	public void run(String... args) throws Exception {
		RegUser u  = this.map.findByID(1);
		System.out.println(u);
		
	}

	

}
