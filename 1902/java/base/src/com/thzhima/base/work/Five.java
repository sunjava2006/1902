package com.thzhima.base.work;

public class Five {
	public static void main(String[] args) {
		int[] array = {10,20,30,40};
		
		for(int i : array) {
			System.out.println(i);
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.println(i + ":" + array[i]);
		}
		
		
	}
	
}
