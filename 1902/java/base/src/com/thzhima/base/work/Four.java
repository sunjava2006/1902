package com.thzhima.base.work;

public class Four {

	public static void main(String[] args) {
		
		/*求100到999之间的“水仙花”数。
		 * 153=1*1*1+5*5*5+3*3*3*/
		for(int i=100; i<1000; i++) {
			int h = i/100;
			int m = i%100/10;
			int l = i%10;
			if(i == h*h*h + Math.pow(m, 3) + l*l*l) {
				System.out.println(i);
				System.out.println(h + ":" + m + ":" + l);
			}

		}
		
	}
}
