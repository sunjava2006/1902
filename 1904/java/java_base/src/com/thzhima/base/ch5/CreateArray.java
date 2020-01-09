package com.thzhima.base.ch5;

public class CreateArray {

	public static void main(String[] args) {
		int[] array = new int[3];
		System.out.println("array length is "+array.length);
		
		for(int i=0; i<array.length; i++) {
			System.out.println(i + ":" + array[i]);
		}
		
//		array[3] = 90;
//		System.out.println(array[3]);
		
		boolean[] b = new boolean[3];
		
		for(boolean i : b) {
			System.out.println(i);
		}
		
		char[] c = new char[3];
		for(char i : c) {
			System.out.println((int)i);
		}
		
		String[] s = new String[3];
		for(String i : s) {
			System.out.println(i);
		}
	}
}
