package com.thzhima.blog.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns = {"/Main.html","/add.html","/goodsList"})
public class AdminFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--------Filter Init----2222222222-------------");
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			                    FilterChain chain) throws IOException, ServletException {
		System.out.println("------------------AdminFilter--------------------");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		Object o = session.getAttribute("adminInfo");
		if(null == o) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/adminLogin.html");
		}else {
		   // 放行
			System.out.println("222222222222222222222");
			chain.doFilter(request, response);
			System.out.println("222222222222222222222");
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
