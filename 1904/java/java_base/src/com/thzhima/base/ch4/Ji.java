package com.thzhima.base.ch4;

public class Ji {

	public static void main(String[] args) {
		// 鸡翁一值钱5,最多有20只。
		for(int w = 1; w<=20; w++) {
			// 鸡母一值钱3,最多33只。
			for(int m=1; m<=33; m++) {
				// 雏3只一个钱。最多99只，一买就是3只。
				for(int c=3; c<=99; c+=3) {
					// 鸡的总数
					int count = w+m+c;
					// 钱的总数
					int money = w*5+m*3+c/3;
					
					if(100==count && 100==money ) {
						System.out.println("翁:"+w+",母:"+m+",雏:"+c);
						System.out.println(w*5+","+m*3+","+c/3);
						System.out.println("--------------------");
						
					}
					else if(100<count || 100<money) {
						break;
					}
					
				}
			}
		}
	}
}
