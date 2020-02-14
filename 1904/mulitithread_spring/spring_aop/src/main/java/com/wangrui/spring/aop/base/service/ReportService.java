package com.wangrui.spring.aop.base.service;

import com.wangrui.spring.aop.base.entity.A;

public class ReportService implements Service{

	@Override
	public A service(int month) {
		// 查询数据
		System.out.println("-------- 查询数据 --------");
		A areport = new A(month, 1000000, 999999999);
		return areport;
	}
}
