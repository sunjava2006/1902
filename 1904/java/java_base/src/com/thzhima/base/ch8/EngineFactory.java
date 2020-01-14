package com.thzhima.base.ch8;

public class EngineFactory {

	public static Engine6 create() {

		Engine6 e = new Engine6() {

			@Override
			public void run() {
				System.out.println("run-------");

			}
		};
		
		class E extends Engine6{
			@Override
			public void run() {
				System.out.println("run-------");

			}
		}
		
		Engine6 e2= new E();
		Engine6 e12= new E();
		Engine6 e22= new E();

		return e;
	}

}
