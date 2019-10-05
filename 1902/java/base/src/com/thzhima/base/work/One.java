package com.thzhima.base.work;

public class One {

	public static void main(String[] args) {
//		int a, b, sum = 0;
//		a = b = 1;
		
		
//		while(sum<=5000) {
//			sum += a+b;
//			int n = a+b;
//			a = b;
//			b = n;
//			System.out.println(n);
//		}
        
		//===========================================
		
//		do {
//			sum += a+b;
//			int c = a+b;
//			a = b;
//			b = c;
//			System.out.println(c);
//		}while(sum<=5000);
		
		
		for(int a=1, b=1,sum=0; sum<=5000; ) {
			sum += a+b;
			int c = a+b;
			a = b;
			b = c;
			System.out.println(c);
		}
		
		
	}
}
