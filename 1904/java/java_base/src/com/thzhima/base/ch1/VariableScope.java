package com.thzhima.base.ch1;

public class VariableScope {
    int a = 90;
    
    public static void main(String[] args) {
		int a = 80;
		
		if(true) {
			int b = 70;
			System.out.println(a + b);
		}
//		System.out.println(a + b);
		
	}
}
