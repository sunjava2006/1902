package com.thzhima.base.ch7;

public class ParamTrans {

	void a(People p) {
		p.name="LaLa";
		System.out.println(p);
	}
	
	void b(People p) {
		p = new People("小李","female",20);
		p.name = "小紅";
		System.out.println(p);
	}
	
	public static void main(String[] args) {
		People p = new People("小王","male",30);
		
		ParamTrans pt = new ParamTrans();
		
		pt.a(p);
		System.out.println(p);
	
		System.out.println("-------------------");
		
		pt.b(p);
		System.out.println(p);
		
		
	}
}
