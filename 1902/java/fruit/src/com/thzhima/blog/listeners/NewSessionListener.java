package com.thzhima.blog.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class NewSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent evt)  { 
        ServletContext application = evt.getSession().getServletContext();
        long count = (Long)application.getAttribute(StartupListener.TOTAL_ACCESS_COUNT);
        application.setAttribute(StartupListener.TOTAL_ACCESS_COUNT, count+1);
       
    }

	
    public void sessionDestroyed(HttpSessionEvent evt)  { 
         
    }
	
}
