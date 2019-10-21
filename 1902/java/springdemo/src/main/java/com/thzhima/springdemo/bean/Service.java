package com.thzhima.springdemo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Service {

	@PostConstruct
	public void init() {
		System.out.println("---------------init-------");
	}
	
	public void service() {
		System.out.println("------------service-------");
	}
	
	@PreDestroy
	public void release() {
		System.out.println("---------release--------------");
	}
}
