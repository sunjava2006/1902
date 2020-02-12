package com.wangrui.spring.base.service;

import com.wangrui.spring.base.bean.ClearMan;

//抽象类
public abstract class HomeService {

	// 抽象方法（接口注入，注入的是方法。）
	abstract ClearMan pleaseClearMan();
	
	public void clearService() {
		ClearMan man = pleaseClearMan();
		man.clear();
	}
	
	public abstract void cookingService();
}
