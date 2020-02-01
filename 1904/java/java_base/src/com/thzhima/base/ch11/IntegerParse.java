package com.thzhima.base.ch11;

public class IntegerParse {

	public static void main(String[] args) {
		int i = 90;
		Integer ii = new Integer(90);
		Integer in = ii;
		int iii = ii.intValue();
		
		Integer a = 90;
		Integer b = 90;
		int c = a;
		System.out.println(a instanceof Object);
		System.out.println(a == b);
		System.out.println(ii == a);
		ii = 20;
		System.out.println(in == ii);
		
		
		
	}
}
