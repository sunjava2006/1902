package com.thzhima.springdemo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarFactory {

	@Bean("car")
	public Car create() {
		return new Car() {};
	}
}
