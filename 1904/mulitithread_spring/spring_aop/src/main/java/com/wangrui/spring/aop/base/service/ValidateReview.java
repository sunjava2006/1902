package com.wangrui.spring.aop.base.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateReview {

	
	public boolean validate(Integer month) {
		// 查询当前数据是否审核通过
		System.out.println("------- 校验是否审核通过 --------");
		return true;
	}
	
	@Before("execution(* com.wangrui.spring.aop.base.service.ReportService.service(..))")
	public void validate() {
		// 查询当前数据是否审核通过
		System.out.println("------- 校验是否审核通过 --------");
		
	}
}
