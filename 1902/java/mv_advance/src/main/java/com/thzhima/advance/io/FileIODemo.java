package com.thzhima.advance.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIODemo {

	public static String read2(String fileName) throws IOException {
		StringBuffer sb = new StringBuffer();
		File f = new File(fileName);
		if(f.exists()) {  // 当文件存在时，才去读文件内容。
			FileReader reader = null;
			try {
				reader = new FileReader(f);
				
				char[] buffer = new char[10]; // 输入字符缓冲区
				int count = -1;  // 读取字符的记数
				while(-1 != (count=reader.read(buffer))) { // 读到缓冲区中，返回读到最大数据记数。
					sb.append(buffer, 0, count); // 汇总每次读取的字符。
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if(null != reader) {
					reader.close();
				}
			}
			
		}
		return sb.toString();
	}
	
	
	
	public static void read() throws IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("/home/wangrui/a.txt");
			
			int ch = -1;
			
			while(-1 != (ch=reader.read())) {// 一次读取一个字符。最后结束时，返回-1.
				System.out.print((char)ch); 
			}
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
	}
	
	public static void write() throws IOException {
		FileWriter writer = null;
		try {
			writer = new FileWriter("/home/wangrui/a.txt", true); // 第二个参数true表示以添加的方式创建输出。
			writer.write("hello ,你好."); // 写出到文件。
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();  // 释放资源。
		}
	}
	
	public static void main(String[] args) throws IOException {
		write();
		String str = read2("/home/wangrui/a.txt");
		System.out.println(str);
	}
}
