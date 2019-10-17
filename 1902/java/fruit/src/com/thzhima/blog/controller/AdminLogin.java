package com.thzhima.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String msg = "fail";
		if("admin".equals(userName) && "123456".equals(pwd)) {
			msg = "ok";
			HttpSession session = req.getSession(true);
			session.setAttribute("adminInfo", userName);
		}
		
		PrintWriter out = resp.getWriter();
		out.print(msg);
		out.flush();
	}

	
}
