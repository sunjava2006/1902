package com.wangrui.adv.file.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIO {

	public static String read(String fileName) throws IOException {
		FileReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new FileReader(fileName);
			char[] buffer = new char[3];// 设置输入的缓冲区。
			
			int count = -1;
			while(-1 != (count=reader.read(buffer))) { // 读到缓冲区中。返回读到多少字符。结束，读不到内容返回-1.
				String s = new String(buffer, 0, count); // String 的构造。自己查看String 的构造还有几个，都是怎样的。
				System.out.println(s);
				sb.append(s);// 返回一个完整的内容。
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				reader.close();
			}
		}
		return sb.toString();
	}
	
	public static void write(String fileName, String msg) throws IOException {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName, false);
			
			writer.write(msg);
			
			writer.append(msg);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				writer.close();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
//		String msg = read("/home/wangrui/a");
//		System.out.println(msg);
		
		write("/home/wangrui/b","不是10点。");
	}
}
