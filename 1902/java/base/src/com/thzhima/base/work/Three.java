package com.thzhima.base.work;

public class Three {
	public static void main(String[] args) {
		for(int i=2; i<=10000; i++) {
			for(int j=2; j<=i; j++) {
				if(i%j==0) {
					if(i==j) {
						System.out.println(i);
					}
					break;
					
				}
			}
		}
	}
}
