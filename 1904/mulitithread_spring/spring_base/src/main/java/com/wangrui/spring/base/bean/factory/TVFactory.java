package com.wangrui.spring.base.bean.factory;

public class TVFactory {

	// 静态工厂方法。
	public static TV createTV() {
		return new TV("小米") {};
	}
}
