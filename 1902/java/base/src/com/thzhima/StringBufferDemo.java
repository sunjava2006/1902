package com.thzhima;

public class StringBufferDemo {

	public static void main(String[] args) {
		
//		StringBuffer sb = new StringBuffer("I ");
		StringBuilder sb = new StringBuilder("I ");
		
		
		StringBuilder sb2 = sb.append("love My country.");
		sb.setCharAt(0, 'i');
		sb.deleteCharAt(1);
		
		System.out.println(sb == sb2);
		System.out.println(sb);
		
	}
}
