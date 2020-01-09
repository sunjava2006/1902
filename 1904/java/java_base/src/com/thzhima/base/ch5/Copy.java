package com.thzhima.base.ch5;

public class Copy {

	public static void main(String[] args) {
		int[] a = {10,15,20,25,30};
		
		int[] b = a.clone();
		
		for(int i : b) {
			System.out.println(i);
		}
		System.out.println("========================");
		//a[0] = 100;
		for(int i : b) {
			System.out.println(i);
		}
		
		System.out.println(a==b);
		
		System.out.println(a.equals(b));
		System.out.println(2==2);
	}

}
