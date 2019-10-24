package com.thzhima.mvcblog.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.sun.javafx.webkit.WebConsoleListener;
import com.thzhima.mvcblog.beans.User;
import com.thzhima.mvcblog.services.UserService;


@Component(value = "autoLoginFilter")
public class AutoLoginFilter  implements Filter{
	
	@Autowired
	private UserService userService;
//	public UserService getUserService() {
//		return ContextLoader.getCurrentWebApplicationContext().getBean(UserService.class);
//	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("userInfo");
		if(null == o) {
			Cookie[] cks = request.getCookies();
			Map<String, String> map = new HashMap<>();
			if(null!=cks)
			for(Cookie c : cks) {
				String name = c.getName();
				String value = c.getValue();
				map.put(name, value);
			}
			String userName = map.get("userName");
			String pwd = map.get("pwd");
			if(userName!=null && pwd!=null) {
				User u = new User(null,userName,pwd);
				u = this.userService.login(u); 
				session.setAttribute("userInfo", u);
			}
			
		}
		chain.doFilter(req, res);
	}

}
