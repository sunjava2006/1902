package com.thzhima.base.ch5;

public class ArrayInitial {
	public static void main(String[] args) {
		String[] a;
		a = new String[] {"hi","hello", "ok"};
		
		System.out.println(a.length);
		
		for(String e : a) {
			System.out.print(e + ", ");
		}
		
		
		int[] b = {10,20,30};
//		b= {10,20,30};
		
	    for(int i : b) {
	    	System.out.println(i);
	    }
		
		
	}
}
