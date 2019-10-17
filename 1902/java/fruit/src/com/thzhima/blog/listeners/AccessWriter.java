package com.thzhima.blog.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AccessWriter implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         System.out.println("----------add-----------");
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
        System.out.println("---------remove------------");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         System.out.println("-------------replace----------");
         
//         if()
         
    }
	
}
