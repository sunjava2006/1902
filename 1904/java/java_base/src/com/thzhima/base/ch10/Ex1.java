package com.thzhima.base.ch10;

public class Ex1 {

	
	public static void main(String[] args) {
		int[] a = null;
		int len = (int)(Math.random()*10-5);
		try {
			a = new int[len];
			a[len-3] = 100;
			
			System.out.println("hello");
		}catch(NegativeArraySizeException ex) {
			System.out.println("catch exception.");
			a = new int[10];
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("下标越界了。");
			throw ex;
		}
		finally {
			System.out.println(a.length);
		}
		
		try {
			
		} finally {
			
		}
		
		
		
		
	}
}
