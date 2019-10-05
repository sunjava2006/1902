package com.thzhima.base.types.array;

import java.util.Arrays;

public class TwoArray {
	public static void main(String[] args) {
		
		int[][] a = new int[3][2];
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		Arrays.fill(a[0], 100);
		Arrays.fill(a[1], 200);
		Arrays.fill(a[2], 300);
		
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		//-------------------最外层数组长度必须初始化时指定。--------------------
		int[][] b = new int[3][];
		b[0] = new int[] {1,2,3};
		b[1] = new int[]{4,5}; // 创建子元素数组为长度不同的数组。
		b[2] = new int[5];
		for(int[] i : b) {
			System.out.println(Arrays.toString(i));
		}
		//------------------------显示初始化所有元素-----------------------
		int[][][] c = new int[][][] {
				                         {{1,2},{3,4,5,6}},
				                         {{7,8}},
				                         {{9},{10,11,12},{0}}
			                         };
		System.out.println(c[2][1][2]);
		
		System.out.println();
		
	}
}
