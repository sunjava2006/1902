package com.thzhima.base.ch8.constant;

// final类不能被继承。最终类。
public final class People {

	public final String GENDER ;
	public final String COUNTRY;
	public static final int a = 0; // 申明初始化
	public static final int b;
	
	static{
		b = 90; //  静态块初始化静态常量
	}
	
	{
		this.COUNTRY = "china"; // 代码块初始化
	}
	
	public People(String gender) {
		this.GENDER = gender; // 构造初始化
	}
    
	// final方法是不能被覆盖的。
	public final void work() {
		
	}
	
	
//	People p = new People("male") {
////		public void work() {
////			
////		}
//	};
	
	
	Integer i ;
	Long l ;
	Byte by;
	Boolean bb;
	Character c;
	Short s;
	Float f;
	Double dd;
	
}
