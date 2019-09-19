package com.thzhima.base.abs;

public abstract class Car {
	
	public void stop() {
		System.out.println("---stop---");
	}
	
	public abstract void light();
	
	public abstract void run() ;
	
	public static void main(String[] args) {
		Car car = new Car2() {
			@Override
			public void run() {
				System.out.println("run----");
			}
		};
	}
	
}

 abstract class Car2 extends Car{

	@Override
	public void light() {
		System.out.println("---------------");
		
	}

}
