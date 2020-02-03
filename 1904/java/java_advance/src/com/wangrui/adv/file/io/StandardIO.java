package com.wangrui.adv.file.io;

import java.io.IOException;
import java.io.InputStream;

public class StandardIO {

     public static void main(String[] args) throws IOException {
		System.out.println("hello"); // 标准输出
		System.out.println("error:"+System.out.checkError());
		System.out.println("-------------------");
		System.out.close();
		System.out.println("world!");
		System.out.println("error:"+System.out.checkError());
		
		
//		InputStream in = System.in;// 输入流类型 ,键盘输入的。
//		
//		byte[] buffer = new byte[1024];
//		while(true) {
//			int count = in.read(buffer);
//			
//			String s= new String(buffer, 0, count);
//			System.out.println(s);
//		}
	}
}
