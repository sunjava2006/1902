package com.thzhima.goover;

public class Bubble {

	public static void main(String[] args) {
		int[] a = {5,8,1,2,9,4,3,6,4,7};
		
		for(int j=0; j<a.length-1 ; j++) {
			for(int i=0; i<a.length-j-1; i++) {
				if(a[i]>a[i+1]) {
					int v = a[i];
					a[i]=a[i+1];
					a[i+1] = v;
				}
			}
		}
		
		for(int i : a) {
			System.out.println(i);
		}
		
	
	}
}
