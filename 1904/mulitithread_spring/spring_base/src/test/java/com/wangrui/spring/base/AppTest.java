package com.wangrui.spring.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.base.bean.Airplane;
import com.wangrui.spring.base.bean.Library;
import com.wangrui.spring.base.bean.School;
import com.wangrui.spring.base.bean.Student;
import com.wangrui.spring.base.service.MyService;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase{
   
    
    public void testApp()
    {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
//        Airplane a = app.getBean(Airplane.class);
//        System.out.println(a.getModle());
//        
//        School sch = (School) app.getBean("school2");
//        System.out.println(sch.getStudent());
//        
//        Student s = app.getBean(Student.class);
//        Student s2 = app.getBean(Student.class);
//        System.out.println(s == s2);
//        System.out.println(s == sch.getStudent());
        
//        Library l = app.getBean(Library.class);
//        System.out.println(l.getBookNames());
        
        MyService ms = app.getBean(MyService.class);
        ms.service();
        
        app.close();
    }
}


// 15:55 继续，课间休息时间。



