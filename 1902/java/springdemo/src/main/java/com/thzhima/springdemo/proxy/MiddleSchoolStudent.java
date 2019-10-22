package com.thzhima.springdemo.proxy;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component

public class MiddleSchoolStudent{// implements Student {

	//@Override
	public void toSchool() {
		System.out.println("----------to School-------");
	}

}
