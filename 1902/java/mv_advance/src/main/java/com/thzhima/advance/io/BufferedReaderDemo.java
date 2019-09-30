package com.thzhima.advance.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		
		in = new FileInputStream("/home/wangrui/abc.txt");//System.in;
		inReader = new InputStreamReader(in);
		reader = new BufferedReader(inReader);
		
		try {
			String str = "";
			while(null !=  (str= reader.readLine())) {
			byte[] ccc = str.getBytes();
			str =  new String(ccc,"GB2312");
				System.out.println(str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			inReader.close();
			in.close();
		}
		
	}
}
