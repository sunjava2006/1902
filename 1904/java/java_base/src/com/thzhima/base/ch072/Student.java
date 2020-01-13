package com.thzhima.base.ch072;

import java.util.Date;

public class Student extends Human{
	
	int sid;
	String name;
	
	public void study() {
		System.out.println(this.name + "正在學習中....");
	}
	
	static {
		System.out.println("Student static");
	}
	
	{
		System.out.println();
	}
	
	public Student(){
		super();
	}
	
	public Student(String name,String gender, Date birthDate) {
		super.name = name;
		this.gender = gender;
		super.birthDate = birthDate;
	}
	
	public Student(String gender, Date birthDate) {
		super(gender, birthDate);
	}
	
	public Student(String name, int sid) {
		super(name, null, null);//父類屬性先初始化。
		this.sid = sid;
		
	}
	
	@Override
	public  void work() {
		super.work();
		System.out.println("找人做的");
	}
	
//	@Override
//	public String getMessage() {
//		return "xxx";
//	}

}
