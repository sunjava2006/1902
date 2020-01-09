package com.thzhima.base.ch5;

import java.util.Arrays;

public class Cards {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8};
		
		int[] copy = a.clone();
		
		do {
			int[] i = Arrays.copyOfRange(a, 0, 4);
			int[] j = Arrays.copyOfRange(a, 4, 8);
			for(int k = 0; k<i.length; k++) {
				a[2*k] = i[k];
				a[2*k+1] = j[k];
			}
			for(int u : a) {
				System.out.print(u +", ");
			}
			System.out.println();
		}while(!Arrays.equals(a, copy));
	}
}
