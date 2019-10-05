package com.thzhima.usually;

import java.io.IOException;

public class PrintDemo {
	
	public static void main(String[] args) throws IOException {
		
		System.out.print("hello");
		System.out.println();
		System.out.println("-----------------------");
		
		
		System.out.write(67);
		byte[] buffer = "你好".getBytes();
		System.out.write(buffer);
		
		System.out.format("%1$.1f : %2$s  %2$s", 3.14, "hello");
		
		System.out.flush();
	}

}
