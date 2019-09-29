package com.thzhima.advance.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIODemo {

	public static void read() throws IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("/home/wangrui/a.txt");
			int ch = -1;
			while(-1 != (ch=reader.read())) {
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
			writer = new FileWriter("/home/wangrui/a.txt", true);
			writer.write("hello ,你好.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		write();
		read();
	}
}
