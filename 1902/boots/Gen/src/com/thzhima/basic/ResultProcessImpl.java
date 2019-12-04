package com.thzhima.basic;

import java.util.ArrayList;
import java.util.List;

public  class ResultProcessImpl<T, E extends Runnable> implements ResultProcess<T>{

	//static T tt; // 静态成员不能是泛型。
	
	@Override
	public String process(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
   private T a ;//= new T(); 不能new泛型
   private E b;
	
	public<V> V c(V v) {
		return null;
	}
	
	public static void main(String[] args) {
		List<? extends Number> list = new ArrayList<>();
	
		List<? super Number> list2 = new ArrayList();
		
		
		List<? extends Object> list3 = new ArrayList();
//	    list3.add(new Object());
	}
	
	
	
	
}
