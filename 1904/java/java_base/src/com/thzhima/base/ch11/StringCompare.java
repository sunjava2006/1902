package com.thzhima.base.ch11;

public class StringCompare {

	public static void main(String[] args) {
		String s  = "china";
		String s2 = new String(s);
		
		System.out.println(s == s2);
		System.out.println(s.compareTo(s2));
		System.out.println(s.equals(s2));
	}
}
