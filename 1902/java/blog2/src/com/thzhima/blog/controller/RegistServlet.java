package com.thzhima.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.thzhima.blog.service.UserService;


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
		
		UserService us = new UserService();
		boolean ok = us.regist(userName, pwd);
		
		//-----------------------请求转发---------------
		if(ok) {
			request.setAttribute("msg", "注册成功");
		}else {
			request.setAttribute("msg", "注册失败");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/RegInfo.jsp");
		rd.forward(request, response);
		
//		PrintWriter writer = response.getWriter();
//		if(ok) {
//		writer.write("<html><head>message</head><body>regist ok</body></html>");
//		}else {
//			writer.write("regist error.");
//		}
//		writer.flush();
	}

}
