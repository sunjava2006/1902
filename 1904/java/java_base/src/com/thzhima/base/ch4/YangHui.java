package com.thzhima.base.ch4;

public class YangHui {

	public static void main(String[] args) {
		
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		
		for(int i=6; i>=1; i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
