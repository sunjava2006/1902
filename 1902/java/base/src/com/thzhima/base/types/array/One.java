package com.thzhima.base.types.array;

public class One {
	
	public static void main(String[] args) {
//		int c;
//		int[] a ;
//		int[] b = null;
//		System.out.println("----------");
//		System.out.println(b);
////		System.out.println(a);
//		System.out.println(c);
		
		
		int[] a = new int[3];
		char[] b = new char[3];
		boolean[] c = new boolean[3];
		String[] d = new String[3];
		d[0] = "java";
		d[1] = "python";
		d[2] = "oracle";
		
		a[3] = 90;
		
		System.out.println(d.length);
		System.out.println("china".length());
		
		a = new int[] {10,20,30};
		int[] aa = {20,30,40};
//		a = {20,20};
	}

}
