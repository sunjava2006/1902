package com.thzhima.base.work;

public class Two {
	
	
	static int gui(int i) {
		if(i==1) {
			return 1;
		}else {
			return i * gui(i-1);
		}
	}

	
	public static void main(String[] args) {
		long sum = 1;
		for(int i=3; i>0; i--) {
			sum *= i;
		}
		System.out.println(sum);
		
		System.out.println(gui(3));
		
	}
}
