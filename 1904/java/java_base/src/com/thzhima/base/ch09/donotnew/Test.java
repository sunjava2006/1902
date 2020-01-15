package com.thzhima.base.ch09.donotnew;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

	public static void main(String[] args) 
			throws IOException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 我们要的对象。
		Car car = null;
		
		Properties p = new Properties();// 创建配置文件对象。
		
		// 配置文件对象，读取指定的配置文件 
		p.load(Test.class.getResourceAsStream("/cnf.properties"));
		
		// 从配置文件对象中，取参数的值。这个值就是我们想创建的类名。
		String className = p.getProperty("car");
		
		// 加载类，获取类对象。为反射做准备
		Class clazz = Class.forName(className);
		
		// （反射方法）获取类中定义的方法对象。
		Method method = clazz.getMethod("createNew", null);
		
		// （反射方法）调用方法。
		car  = (Car) method.invoke(null, null);
		
		car.run();
	} 

}
