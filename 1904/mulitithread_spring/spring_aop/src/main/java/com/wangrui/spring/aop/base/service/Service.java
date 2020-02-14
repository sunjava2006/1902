package com.wangrui.spring.aop.base.service;

import org.springframework.stereotype.Component;

@Component
public interface Service<T> {

	T service(int month);
}
