package com.thzhima.blog.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebListener
public class NewAccessUser implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent evt)  { 
         // TODO Auto-generated method stub
    }

	
    public void requestInitialized(ServletRequestEvent evt)  { 
         HttpServletRequest req = (HttpServletRequest) evt.getServletRequest();
         HttpSession session = req.getSession(true);
         if(session.isNew()) {
        	 System.out.println("---------new Session------------------");
         }
        
    }
	
}
