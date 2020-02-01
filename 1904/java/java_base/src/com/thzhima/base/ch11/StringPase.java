package com.thzhima.base.ch11;

public class StringPase {

	public static void main(String[] args) {
		String s = "china";
		String s1 = s;
		
		String s2 = "china";
		System.out.println(s==s1);
		System.out.println(s==s2);
		
		String s3 = new String("china");
		String s4 = new String("china");
		
		s1 = "good";
		s3 = "good";
				
	}
}
