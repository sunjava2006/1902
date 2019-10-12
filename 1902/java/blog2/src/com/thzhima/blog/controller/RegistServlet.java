package com.thzhima.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/regist")
public class RegistServlet implements Servlet {

    public RegistServlet() {
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("------------------------------");
		String userName = null;
		String pwd = null;
		
		userName = request.getParameter("userName");
		pwd = request.getParameter("pwd");
		
		System.out.println(userName);
		System.out.println(pwd);
		
		
		PrintWriter writer = response.getWriter();
		writer.write("regist ok");
		writer.flush();
	}

}
