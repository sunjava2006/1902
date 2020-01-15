package com.thzhima.base.ch09.donotnew;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

	public static void main(String[] args) 
			throws IOException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Car car = null;
		
		Properties p = new Properties();
		p.load(Test.class.getResourceAsStream("/cnf.properties"));
		String className = p.getProperty("car");
		
		Method method = Class.forName(className).getMethod("createNew", null);
		car  = (Car) method.invoke(null, null);
		
		car.run();
	} 

}
