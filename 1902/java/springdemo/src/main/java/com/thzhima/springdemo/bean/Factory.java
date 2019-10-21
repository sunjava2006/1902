package com.thzhima.springdemo.bean;

import javax.xml.ws.FaultAction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory {

	@Bean("car2")
	public static Car create() {
		return new Car() {};
	}
}
