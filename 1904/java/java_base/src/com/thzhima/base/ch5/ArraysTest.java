package com.thzhima.base.ch5;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int[] a = new int[5];
		
		Arrays.fill(a, 10); // 填充元素为指定的值
		
		for(int i : a) {
			System.out.print(i+ ",");
		}
		System.out.println();
		///---------------copyOf-------------------
		int[] b = Arrays.copyOf(a, a.length);
		System.out.println(a == b);
		
		// Arrays.equals（）方法，比较数组的内容是否相同。
		System.out.println(Arrays.equals(a, b));
		
		//---------copyOfRange-------------------
		int[] c = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.equals(a, c));
	}
}
