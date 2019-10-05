package com.thzhima.usually;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("I like Java.");
		
		String key = "Java";
		
		int at = sb.indexOf(key);
//		
//		sb.delete(at, at+key.length());
//		
//		sb.insert(at, "Oracle and Python");
		
		
//		sb.replace(at, at+key.length(), "Oracle and Python");
		
		
		System.out.println(sb);
		
		
		String s = sb.toString();
		System.out.println(s.replace("Java", "Oracle and python"));
		
		
		
		
		
		
		
	}
}
