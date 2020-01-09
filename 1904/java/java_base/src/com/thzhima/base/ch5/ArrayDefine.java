package com.thzhima.base.ch5;

public class ArrayDefine {

	public static void main(String[] args) {
		int[] a = new int[3];
		
		int[][] aa = new int[3][4];
		/**
		 * 1,2,3,4
		 * 5,6,7,8
		 * 9,10,11,12
		 */
//		int i = 1;
//		aa[0][0] = i++;
//		aa[0][1] = i++;
//		aa[0][2] = i++;
//		aa[0][3] = i++;
//		aa[1][0] = i++;
//		aa[1][1] = i++;
//		aa[1][2] = i++;
//		aa[1][3] = i++;
//		aa[2][0] = i++;
//		aa[2][1] = i++;
//		aa[2][2] = i++;
//		aa[2][3] = i++;
		
		int count = 1;
		for(int i=0;i<aa.length;i++) {
			int[] ai = aa[i];
			for(int j=0;j<ai.length;j++) {
				ai[j] = count++;
			}
		}
		
		for(int[] i : aa) {
			for(int j : i) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		
		System.out.println("*************************");
		
		
		int[][][] aaa = new int[][][]{{{1,2},{1,3,4}},{{5,5}},{{1},{2,3,2},{0,9}}};
		for(int[][] i: aaa) {
			
			for(int[] j: i) {
				for(int k: j) {
					System.out.print(k +", ");
				}
				System.out.println("\n-------------------");
			}
			System.out.println("=================");
		}

	}

}
