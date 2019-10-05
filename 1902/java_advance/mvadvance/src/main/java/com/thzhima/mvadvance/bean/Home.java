package com.thzhima.mvadvance.bean;

public class Home<P> {

	P pet = null;
	
	public void setPet(P p) {
		this.pet = p;
	}
	

	public static void main(String[] args) {
		Home<Cat> home = new Home<Cat>();
		home.setPet(new Cat());
		
		Home<Dog> home2 = new Home<>();
		home2.setPet(new Dog());
	
		
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		Home<Animal> h3 = new Home<Animal>();
		h3.setPet(new Cat());
		
	}
}
