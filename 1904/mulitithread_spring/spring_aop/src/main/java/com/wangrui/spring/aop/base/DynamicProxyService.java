package com.wangrui.spring.aop.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wangrui.spring.aop.base.entity.A;
import com.wangrui.spring.aop.base.service.ReportService;
import com.wangrui.spring.aop.base.service.Service;
import com.wangrui.spring.aop.base.service.ValidateReview;

public class DynamicProxyService {

	public static Service getProxyServer(ReportService serviceObj, ValidateReview addone, String addoneMethod, Class ... paramargs) {
		Service s = null;
		
		ClassLoader loader = serviceObj.getClass().getClassLoader();
		
		Class[] interfaces = serviceObj.getClass().getInterfaces();
		
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				ValidateReview vr = new ValidateReview();
				A areport = null;
				if("service".equals(method.getName())){
					
					Method m = addone.getClass().getDeclaredMethod(addoneMethod, paramargs);
					if((boolean) m.invoke(addone, args)) {
						areport = (A) method.invoke(serviceObj, args);
					}
				}
				
				return areport;
			}

			
		};
		
		s = (Service)Proxy.newProxyInstance(loader, interfaces, h);
		
		
		return s;
	}
	
	public static void main(String[] args) {
		
		Service s = DynamicProxyService.getProxyServer(new ReportService(), new ValidateReview(), "validate", Integer.class);
		s.service(2);
	}
	
	
}
