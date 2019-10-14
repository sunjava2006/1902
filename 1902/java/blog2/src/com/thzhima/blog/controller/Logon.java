package com.thzhima.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzhima.bean.User;
import com.thzhima.blog.service.UserService;


@WebServlet("/Logon")
public class Logon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String to = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		to = config.getServletContext().getInitParameter("to");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userName ;
		 request.setCharacterEncoding(to);
		 userName = request.getParameter("userName");
		 String pwd = request.getParameter("pwd");
		 
		 // 到数据库查询。
		 UserService us = new UserService();
		 User u = null;
		 String msg = "";
		 try {
			u = us.logon(userName, pwd);
			if(null == u) {
				msg = "用户名或密码错误";
			}
		} catch (SQLException e) {
			msg = "登录发生错误，重试或联系管理员";
			e.printStackTrace();
		} 
		if(null == u) {
			// 回到登录页面,给出提示消息。
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/Logon.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("http://www.qq.com");
		}
	
		
		 
		 // 获取（创建）Session 会话对象。
		HttpSession session =  request.getSession(true);
		session.setAttribute("userInfo", u);
		   
		
	}

	

}
