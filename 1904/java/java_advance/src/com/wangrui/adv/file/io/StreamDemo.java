package com.wangrui.adv.file.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo {

	public static void read(String fileName) throws IOException {
		
		FileInputStream in =  null;
		try {
			in = new FileInputStream(fileName);
//			System.out.println(in.available());
//			int c = -1;
//			do {
//				c = in.read();
//				System.out.println(String.valueOf((char)c));
//			}while(c != -1);
			
			byte[] buffer = new byte[4];
			int count = -1;
			do {
				count = in.read(buffer);
				in.skip(1); // 跳过多少个字节。
//				System.out.println(in.available());
				if(count>0) {
					
					String s = new String(buffer, 0, count);
					System.out.println(s);
				}
				
			}while(count!=-1);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	
	public static void write(String fileName, String msg) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			
			byte[] data = msg.getBytes();
//			for(byte b : data) {
//				out.write(b);
//			}
			
			out.write(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
		}
	}
	
	
	public static void copy(String resource, String target) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(resource);
			out = new FileOutputStream(target);
			byte[] buffer = new byte[1024];
			int count=-1; 
			while(-1!=(count=in.read(buffer))) {
				out.write(buffer, 0, count);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
			if(null != out) {
				out.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//		read("/home/wangrui/a");
//		write("/home/wangrui/a", "大家好.hello world.hi.");
		
		copy("/home/wangrui/下载/laugh.jpeg","/home/wangrui/下载/laugh2.jpeg");
	}
}
