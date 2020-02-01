package com.thzhima.base.ch11;

public class StringTest {

	public static void main(String[] args) {
		String s = "china";
		String s1 = s;
		System.out.println(s.toUpperCase());
		System.out.println(s);
	    System.out.println(s == s1);
		s = s.toUpperCase();// 新的大写字母的String对象。
		System.out.println(s);
		System.out.println(s == s1);
	}
}
