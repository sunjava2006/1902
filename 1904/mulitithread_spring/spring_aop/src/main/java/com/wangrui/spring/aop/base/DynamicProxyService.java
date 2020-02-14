package com.wangrui.spring.aop.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wangrui.spring.aop.base.entity.A;
import com.wangrui.spring.aop.base.service.ReportService;
import com.wangrui.spring.aop.base.service.Service;
import com.wangrui.spring.aop.base.service.ValidateReview;

public class DynamicProxyService {

	public static void main(String[] args) {
		
		ClassLoader loader = ReportService.class.getClassLoader();
		
		Class[] interfaces = ReportService.class.getInterfaces();
		
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				ValidateReview vr = new ValidateReview();
				A areport = null;
				if("service".equals(method.getName())){
					if(vr.validate((int)args[0])) {
						ReportService rs = new ReportService();
						areport = rs.service((int)args[0]);
								
					}
				}
				
				return areport;
			}

			
		};
		
		Service service = (Service)Proxy.newProxyInstance(loader, interfaces, h);
		service.service(2);
	}
}
