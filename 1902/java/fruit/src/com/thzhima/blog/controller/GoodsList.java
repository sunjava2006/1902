package com.thzhima.blog.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.bean.Goods;
import com.thzhima.blog.service.GoodsService;

@WebServlet("/goodsList")
public class GoodsList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p = 1;
		int s = 10;
		
		String page = req.getParameter("page");
		String size = req.getParameter("size");
		System.out.println(page);
		System.out.println(size);
		
		GoodsService gs = new GoodsService();
		List<Goods> list = null;
		try {
			list = gs.list(p, s);
			req.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/List.jsp").forward(req, resp);
	}

    
}
