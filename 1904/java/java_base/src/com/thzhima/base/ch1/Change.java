package com.thzhima.base.ch1;

public class Change {

	public static void main(String[] args) {
		int a = 10;
		byte b = 10;
		short s = 10;
		long l = Long.MAX_VALUE;//10L; //64 bits
		
		a = b;
		b = (byte)a;
		
		s = b;
		b = (byte)s;
		
		l = a;
		a = (int)l;
		
		float f =3.14F; // 32 bits
		double d =3.14;
		
		d = f; // 隐示的转换
		f = (float)d; //显示类型转换（强制类型转换）
		
		
		l = (long)f; // 小数变整数一定要强转。
		l = Long.MAX_VALUE;
		f = l; // 
		System.out.println(f);
		
		f = (float) d;
		
		final int j = 90; // 最终的 常量
		// 常数，字面量 90
		 //j = 9;
	}
}
