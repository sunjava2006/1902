package com.thzhima.springdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy1 {
     public static void main(String[] args) {

    	 InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
				if("toSchool".equals(method.getName())) {
				
					Sport s = new Sport();
					s.run();
					MiddleSchoolStudent mss = new MiddleSchoolStudent();
					mss.toSchool();
				}
			
				return null;
			}
		};
		
		Student student  = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), MiddleSchoolStudent.class.getInterfaces(), h);
		
		
		student.toSchool();
		System.out.println(student.getClass().getName());
		System.out.println(student instanceof Student);
	}
}
