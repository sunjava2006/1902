package com.thzhima.base.ch8;

public class C919 {

	private Engine6 e = new AJE8();
	int a = 90;
	
	{
		e.run();
	}
	
	
	public class AJE8 extends Engine6{
		int b = a;

		@Override
		public void run() {
			System.out.println("-----run--------");
		}
		
	}
	
	public static void main(String[] args) {
		C919 c = new C919();
	}
}
