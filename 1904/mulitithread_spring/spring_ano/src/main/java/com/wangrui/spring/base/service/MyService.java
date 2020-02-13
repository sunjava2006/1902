package com.wangrui.spring.base.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	
	public void init() {
		System.out.println("连接网络。。。。。");
	}
	
	public void service() {
		System.out.println("提供网络服务。。。。。");
	}
	
	public void close() {
		System.out.println("释放网络资源。。。。。");
	}
}
