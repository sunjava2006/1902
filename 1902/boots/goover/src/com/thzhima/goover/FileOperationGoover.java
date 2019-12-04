package com.thzhima.goover;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOperationGoover {

	public static void main(String[] args) throws IOException {
		
		FileReader r = null;
		int count =-1;
		char[] cbuf = new char[2];
		try {
			r = new FileReader("/home/wangrui/a");
			
			
			while(-1 != (count=r.read(cbuf))) {
				String s = new String(cbuf,0,count);
				System.out.println(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			r.close();
		}
		
		System.out.println("=====================================");
		//-------------------------------------------
		FileInputStream in = new FileInputStream("/home/wangrui/a");
		InputStreamReader reader = new InputStreamReader(in, "iso-8859-1");
		
		while(-1 != (count=reader.read(cbuf))) {
			String s = new String(cbuf,0,count);
			System.out.println(s);
		}
		
		reader.close();
//		byte[] buf = new byte[2];
//		
//		while(-1 != (count=in.read(buf))) {
//			for(int i=0;i<count;i++) {
//				System.out.println((char)buf[i]);
//			}
//		}
//		
//		in.close();
//		
	}
}
