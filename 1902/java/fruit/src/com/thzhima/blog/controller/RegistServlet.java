package com.thzhima.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.thzhima.blog.service.UserService;



public class RegistServlet implements Servlet {
   private String targetEncod;
	
    public RegistServlet() {
      System.out.println("----------创建Servlet---------");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-------------init----创建后立即运行，仅一次-------------");
		// 取当前Servlet 自己的初始化配置参数。
		targetEncod = config.getInitParameter("targetEncod");
		
		// 获取全局对象。
		ServletContext application = config.getServletContext();
		//从全局对象中取初始化配置参数
		targetEncod = application.getInitParameter("to");
	}

	
	public void destroy() {
		System.out.println("--------------应用关闭时调用---释放-----------");
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
		HttpServletRequest req = (HttpServletRequest) request;
		String userName = null;
		String pwd = null;
		
		//获取发送的请求参数
		req.setCharacterEncoding(targetEncod);
		userName = request.getParameter("userName");
		pwd = request.getParameter("pwd");
		
		if("GET".equalsIgnoreCase(req.getMethod())) {
			//request.
		}
		
		System.out.println(userName);
		System.out.println(pwd);
		
		UserService us = new UserService();
		boolean ok = us.regist(userName, pwd);
		
		//-----------------------请求转发---------------
		if(ok) {
			// 讲求转发是同一个用户发生的请求，同用同一个请求和响应对象的。
			request.setAttribute("msg", "注册成功"); // 向请求对象中设置属性。在不同服务单元间，共享数据。
		}else {
			request.setAttribute("msg", "注册失败");
		}
		//请求转发（在服务端的不同的服务单元之间）
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
