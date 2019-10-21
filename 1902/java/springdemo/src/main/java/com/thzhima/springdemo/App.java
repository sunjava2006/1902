package com.thzhima.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thzhima.springdemo.bean.Book;
import com.thzhima.springdemo.bean.People;
import com.thzhima.springdemo.bean.Room;
import com.thzhima.springdemo.bean.Student;

/**
 * Hello world!
 *
 */
public class App 
{   
	
	
    public static void main( String[] args )
    {  
    	ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
//        Book book = null;
//        
//        book = (Book)app.getBean("pythonBook");//app.getBean(Book.class);
        
        
       Room myRoom = app.getBean(Room.class);
       System.out.println(myRoom);
        
//        System.out.println(book);
//        
//        System.out.println("----------------------------------------------");
//        Student s = app.getBeanFactory().getBean(Student.class);
//        s.readBook();
//        System.out.println(s.getClass().getName());
//        System.out.println(s.mkBook());
//        System.out.println("===============================");
//        
//        People p = app.getBean(People.class);
//        p.todo();
    }
}
