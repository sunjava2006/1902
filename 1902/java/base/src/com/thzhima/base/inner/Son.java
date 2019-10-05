package com.thzhima.base.inner;

class Base {
	public int a;

	public static int b;

	public Base() {
		a = 1;
		b = 1;
	}

	public void addFivetoa() {
		a += 5;
	}

	public static void addSixtob() {
		b += 6;
	}
}

public class Son extends Base {
    static int b;
	public Son() {
		a = 2;
		b = 2;
	}

	public void addFivetoa() {
		a += 4;
	}

	public static void addSixtob() {
		b += 7;
	}

	public static void main(String args[]) {
		Son son = new Son();// a=2, Base.b=1,Son.b=2
		Base base = son;
		base.addFivetoa();// a=6
		base.addSixtob(); // b=7
		System.out.println(base.a);
		System.out.println(base.b);
		System.out.println(son.a);
		son.addSixtob();
		System.out.println(son.b);
	}
}