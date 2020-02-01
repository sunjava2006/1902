package com.wangrui.adv.coll;

public class People implements Comparable<People>{//自然比较器

	public String name;
	public int age;
	public String ID;
	
	public People() {
		
	}
	
	public People(String name, int age, String iD) {
		super();
		this.name = name;
		this.age = age;
		ID = iD;
	}
	
	@Override
	public int hashCode() {
		return this.age+this.name.hashCode()+this.ID.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}else {
			if(o instanceof People) {
				People p = (People)o;
				if(this.name.equals(p.name) 
					&& this.age == p.age 
					&& this.ID.equals(p.ID)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int compareTo(People o) {
		//return this.age - o.age;
		return this.ID.compareTo(o.ID);
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", ID=" + ID + "]";
	}
	
	
	
}
