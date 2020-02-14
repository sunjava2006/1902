package com.wangrui.spring.base;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.base.bean.Book;
import com.wangrui.spring.base.bean.Home;
import com.wangrui.spring.base.bean.Library;
import com.wangrui.spring.base.bean.People;
import com.wangrui.spring.base.service.MyService;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    private ClassPathXmlApplicationContext app;
    @Override
	protected void setUp() throws Exception {
		super.setUp();
		app = new ClassPathXmlApplicationContext("app.xml");
	}

	public void testApp()
    {
//        People p = (People)app.getBean("people");
//        System.out.println(p);
//        People p2 = (People)app.getBean("people");
//        System.out.println(p);
//        System.out.println(p==p2);
//        
//        Home h = app.getBean(Home.class);
//        System.out.println(h);
//        
//        Library l = app.getBean(Library.class);
//       List<Book> books = l.getBookNames();
//       for(Book b : books) {
//    	   System.out.println(b.getName());
//       }
		
		MyService ms = app.getBean(MyService.class);
		ms.service();
       
    }

	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
		app.close();
	}
	
	
}
