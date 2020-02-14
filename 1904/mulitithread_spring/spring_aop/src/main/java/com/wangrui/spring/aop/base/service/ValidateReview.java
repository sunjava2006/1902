package com.wangrui.spring.aop.base.service;

public class ValidateReview {

	public boolean validate(int month) {
		// 查询当前数据是否审核通过
		System.out.println("------- 校验是否审核通过 --------");
		return true;
	}
}
