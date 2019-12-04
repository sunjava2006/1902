package com.thzhima.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.thzhima"})
@EnableCaching
public class MvcblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcblogApplication.class, args);
	}

}
