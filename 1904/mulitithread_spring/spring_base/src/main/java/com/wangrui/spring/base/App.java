package com.wangrui.spring.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.base.bean.Home;
import com.wangrui.spring.base.bean.People;
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
        People p = app.getBean(People.class);
        System.out.println(p);
        
        HomeService hservice = app.getBean(HomeService.class);
        hservice.clearService();
        hservice.cookingService();
        
        Home home = (Home)app.getBean("home");
        System.out.println(home);
    }
}
