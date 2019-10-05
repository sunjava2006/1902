package com.thzhima.base.types.array.work;

import java.util.Arrays;

public class One {
	public static void main(String[] args) {
		int[][] a = new int[5][5];
		
		int v = 1;
		
		for(int i=0;i<a.length;i++) {
			for(int ii=0;ii<a[i].length;ii++) {
				a[i][ii] = v++;
			}
		}
		
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		
		//=====================================
		int sum = 0;
		for(int i=0,j=0; i<a.length; i++,j++) {
			sum += a[i][j];
			System.out.print(a[i][j]+ ", ");
		}
		System.out.println("\n sum: "+sum);
		
		//------------------------------------
		sum = 0;
		for(int i=0, j=a[i].length-1;
				i<a.length;
				i++,j--) {
			
				int value = a[i][j];
				System.out.print(value + ", ");
				sum += value;
			
		}
		System.out.println("\n sum : " + sum);
		
	}
}
