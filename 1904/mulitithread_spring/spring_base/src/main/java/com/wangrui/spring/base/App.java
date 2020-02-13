package com.wangrui.spring.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.base.bean.Home;
import com.wangrui.spring.base.bean.People;
import com.wangrui.spring.base.bean.School;
import com.wangrui.spring.base.bean.Student;
import com.wangrui.spring.base.service.HomeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext app = 
        		new ClassPathXmlApplicationContext("app.xml");
        Student s = app.getBean(Student.class);
        System.out.println(s.getSchool()==null);
        
        School school = app.getBean(School.class);
        System.out.println(school.getStudent()==null);
//        People p = (People)app.getBean("com.wangrui.spring.base.bean.People");
//        System.out.println(p);
//        
//        
//        HomeService hservice = app.getBean(HomeService.class);
//        hservice.clearService();
//        hservice.cookingService();
//        
//        Home home = (Home)app.getBean("home");
//        System.out.println(home);
    }
}
