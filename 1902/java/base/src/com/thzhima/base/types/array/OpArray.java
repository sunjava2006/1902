package com.thzhima.base.types.array;

import java.util.Arrays;

public class OpArray {
	public static void main(String[] args) {
		
		int[] a = new int[] {10,20,30};
		
		int len = a.length; // 数组的 length属性，返回数组的长度 。
		
		int[] b = a.clone();
		
		System.out.println(a);
		System.out.println(b);
		
		int[] c = new int[30];
		
		System.arraycopy(a, 0, c, 4, 2);
//		for(int i : c) {
//			System.out.println(i);
//		}
		
		//-----------数组操作工具类 Arrays ---------
		int[] d = Arrays.copyOf(a, 2);
		int[] e = Arrays.copyOfRange(a, 1, 3);
		
		Arrays.fill(a, 100);
		
		int[] f = {20,10,1,60,6,90,4,65,78,21};
//		Arrays.sort(f);
		
		
		System.out.println(Arrays.toString(f));
		int at = Arrays.binarySearch(f, 20);
		
		System.out.println(at);
	}
}
