package com.thzhima.base.ch1;

public class Type {

	public static void main(String[] args) {
		//布尔（逻辑）类型,任何其它类型都不能转为布尔值。
		boolean b = true;
		boolean bb = false;
		
//		String isOk = 2-1?"ok":"no";
		
    	//整数 bit位.8bit=1byte
		byte a = 127; // 1字节
		short c = Short.MAX_VALUE;// 2字节 
		System.out.println(c);
		int d = Integer.MAX_VALUE; // 4字节
		System.out.println(d);
		long e = 9999999L; // long型的9999999
		long ee = 9999999; // int型的9999999
		
		// 小数
		float f = 3.14F; // 4字节
		double dd = 3.14; // 8字节 
		float ff = (float)dd; // 强制数据类型转换
		double ddd = f;
		
		// 字符
		char ch = '中'; // 是以''括起来的一个字符.
		
		//类型转换
		int ii = 'c';
		char chh = 76;
		
		
		
	}

}
