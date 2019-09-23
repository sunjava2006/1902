package com.thzhima;

public class StringDemo {

	public static void main(String[] args) {
		String str = "China";
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		System.out.println(str.indexOf("in", 1));
		System.out.println(str.lastIndexOf("c"));
		System.out.println(str.charAt(0));
		System.out.println(str.codePointAt(0));
		System.out.println(str.codePointBefore(1));
		System.out.println(str.codePointCount(0, 5));
		System.out.println(str.length());
		System.out.println(str.compareTo("china"));
		System.out.println(str.compareToIgnoreCase("CHina"));
		
		System.out.println(str.equals("china"));
		System.out.println(str.equalsIgnoreCase("cHINA"));
		
		System.out.println(str.concat(" is my country."));
		System.out.println(str.contains("ina"));

		System.out.println(str.contentEquals("China"));
//		System.out.println(str.eq);
		
		Object o ;
		
		System.out.println("-----------------------");
		
		System.out.println(str);
		System.out.println('C'-'c');
	}
}
