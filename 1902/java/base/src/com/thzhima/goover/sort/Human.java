package com.thzhima.goover.sort;

public class Human implements Comparable<Human>{

	int age;
	int tall;
	
	public Human() {
	}
	
	public Human(int age, int tall) {
		super();
		this.age = age;
		this.tall = tall;
	}

	@Override
	public int compareTo(Human o) {
	
		return o.age-this.age;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", tall=" + tall + "]";
	}
	
	
	
	
}
