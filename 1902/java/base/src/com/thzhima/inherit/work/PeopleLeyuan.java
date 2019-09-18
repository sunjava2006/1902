package com.thzhima.inherit.work;

public class PeopleLeyuan {
	
	public static void main(String[]args) {
		Person p=new Person("man");
		Worker w =new Worker("man","shipingchang","zhijianyuan");
		Student s=new Student("man","xuexiao","jisuanji");
		System.out.println(p.GENDER);
		System.out.println(w.GENDER+w.factoryName+w.prefession);
		
		//========================================
		Person p2 = new Student("南京大学", "计算机", "男");
		Person p3 = new Worker("女", "长沙纺织厂", "纺织工");
		
		p2.work();
		p3.work();

		
	}
	
	
}
