package com.thzhima.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thzhima.blog.service.GoodsService;

@WebServlet("/publish")
@MultipartConfig()
public class Publish extends HttpServlet{
	
	private boolean isSimpleField(Part p) {
		String disposition = p.getHeader("content-disposition");
		if(disposition.contains("filename=")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private String getValue(Part p) throws IOException {
		String val = null;
		InputStream in = null;
		InputStreamReader reader =  null;
		try {
			in = p.getInputStream();
			reader = new InputStreamReader(in);
			char[] buffer =  new char[(int)p.getSize()];
			reader.read(buffer);
			val = new String(buffer);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader!=null) {
				reader.close();
			}
			if(null != in) {
				in.close();
			}
		}
		
		return val;
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = null;
		InputStreamReader inReader = null;
		char[] buffer = new char[100];
		  try {
			 // 取文本数据 
//			request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
			
			Part goodsPart = request.getPart("goodsName");
			String goodsName = this.getValue(goodsPart);
		    
			Part descPart = request.getPart("description");
			String description = this.getValue(descPart);
			
			Part unitPart = request.getPart("unit");
			String unit = this.getValue(unitPart);
			
			Part pricePart = request.getPart("price");
			String priceStr = this.getValue(pricePart);
			float price = priceStr!=null? Float.valueOf(priceStr):0F;
			
			Part locationPart = request.getPart("location");
			String location = this.getValue(locationPart);
			
			//------------------------取上传文件，并存储--------------------------------------
			Part picturePart = request.getPart("picture");
			String fileName = picturePart.getSubmittedFileName();
			// 取文件的后缀名
			String surfix = fileName.substring(fileName.lastIndexOf("."));
			String newName = System.currentTimeMillis()+surfix;
			
			ServletContext appliction = request.getServletContext();
//			this.getServletContext();
//			request.getSession(true).getServletContext();
//			this.getServletConfig().getServletContext();
			
			String path = appliction.getRealPath("/pictures");
			System.out.println(path);
			picturePart.write(path+"/"+newName);
			
			String picture = newName;
			
			//==============写入数据库======================
			GoodsService gs = new GoodsService();
			gs.publish(goodsName, description, unit, price, location, picture);
			
			//================================
//			Collection<Part> parts = request.getParts();
			
//			for(Part p : parts) {
//			    if(this.isSimpleField(p)) {
//			    	String name = p.getName();
//			        String value = this.getValue(p);
//			        System.out.println(name +":" + value);
//			    }
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 请求转发商品列表
			request.getRequestDispatcher("/goodsList").forward(request, response);
		}
		  
		  
	}
}
