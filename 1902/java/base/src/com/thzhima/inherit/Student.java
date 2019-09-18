package com.thzhima.inherit;

import java.sql.Date;

public class Student extends Human{
	public String name = "小张";
	public String NO ;
	
	static{
		System.out.println("load Student");
	}
	
	{
		System.out.println(22);
	}
	public Student(String name, Date birthday) {
		super(name, birthday);
	}
	
	public Student() {
		//super();
		System.out.println(2);
		
	}
	
	@Override
	public void work() {
		super.work();
		this.study();
	}
	
	@Override   //方法重写（覆盖）
	public String toString() {
		return "name:" + this.name+ "; birthday:"+this.birthday 
				+"; NO:" + NO ;
	}
	
	public void study() {
		System.out.println("study ..................");
	}
	
	public static void main(String[] args) {
		Student s = new Student();

	}
}
