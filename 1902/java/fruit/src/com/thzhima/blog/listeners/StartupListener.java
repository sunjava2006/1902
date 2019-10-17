package com.thzhima.blog.listeners;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {
	public static final String TOTAL_ACCESS_COUNT = "totalAccessCount";
     
	 public void contextInitialized(ServletContextEvent evt)  { 
         ServletContext application = evt.getServletContext();
         String path = application.getRealPath("/WEB-INF");
         System.out.println(path);
         
         FileReader reader = null;
         try {
			reader = new FileReader(new File(path, "count"));
			char[] buf = new char[20];
			int len = reader.read(buf); 
			String str = new String(buf, 0, len);
			long count = Long.valueOf(str);
			
			// 放入全局对象中
			application.setAttribute(TOTAL_ACCESS_COUNT, count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
    }

    public void contextDestroyed(ServletContextEvent evt)  { 
    	ServletContext application = evt.getServletContext();
        String path = application.getRealPath("/WEB-INF");
        Integer totalCount = (Integer) application.getAttribute(TOTAL_ACCESS_COUNT);
        
        FileWriter writer = null;
        try {
			writer = new FileWriter(new File(path, "count"));
			writer.write(totalCount.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
    }


   
	
}
