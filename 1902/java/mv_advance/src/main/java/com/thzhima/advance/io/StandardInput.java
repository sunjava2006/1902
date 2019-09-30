package com.thzhima.advance.io;

import java.io.IOException;
import java.io.InputStream;

public class StandardInput {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
	    char c = '\n';
		while('\n' != (c=(char)in.read())) {
			System.out.print((int)c +":"+ c + ",");
		}
		//------------------------------------------
//		byte[] buffer  = new byte[4];
//		for( ; ; ) {
//			int count = in.read(buffer);
//			System.out.println(new String(buffer,0,count));
//			if('\n' == buffer[count-1]) {
//				break;
//			}
//		}
		
//		System.out.print((char)128);
		
	}
}
