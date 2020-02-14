package com.wangrui.spring.aop.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.aop.base.entity.A;
import com.wangrui.spring.aop.base.service.MyService;
import com.wangrui.spring.aop.base.service.ReportService;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
   
	
    public void testApp()
    {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
        
//        ReportService rs = app.getBean(ReportService.class);
//        A report = rs.service(3);
//        System.out.println(report);
        
        MyService ms = app.getBean(MyService.class);
        System.out.println(ms.getGDP());
    }
}
