package com.thzhima.base.ch7;

public class People {
	
	String name;
	String gender;
	int age;
	
	public People() {
		
	}
	
	public People(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public void work() {
		System.out.println("工作中....");
	}
	
	public int work(String task) {
		System.out.println("完成 " + task + "工作中....");
		return 6000;
	}
	
	public int toWork() {
		return 5000;
	}
	
//	@Override
	public String toString() {
		return "{name:"+this.name+", gneder:"
	             +this.gender+",age:"+this.age+"}";
	}
	
	public static void main(String[] args) {
		People xiaoZhang = new People("張小光", "male", 20);
		
		System.out.println(xiaoZhang);
		
		xiaoZhang.work();
		String s = xiaoZhang.name;
		System.out.println(s);
		
		
	}
}
