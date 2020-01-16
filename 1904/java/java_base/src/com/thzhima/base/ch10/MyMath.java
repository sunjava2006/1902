package com.thzhima.base.ch10;

public class MyMath {

	public static int divide(int a, int b)throws ParameterException {
		if(b!=0) {
			return a/b;
		}else {
			throw new ParameterException("b参数是除数，不能为0.");
		}
		
	}
	
	
	public static void main(String[] args)  {
	boolean f = false;
	do {
		try {
			int  a = MyMath.divide(10, 0);
			f = false;
		} catch (ParameterException e) {
		     f =true;
		}
	}while(f);
		
	}
}
