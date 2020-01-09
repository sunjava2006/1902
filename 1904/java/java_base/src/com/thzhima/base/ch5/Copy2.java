package com.thzhima.base.ch5;

public class Copy2 {

	public static void main(String[] args) {
		int[] a = {10,20,30,40};
		
		int[] b = new int[20];
		
		System.arraycopy(a, 3, b, 10, 1);
	
		for(int i : b) {
			System.out.print(i+ ", ");
		}
	}
}
