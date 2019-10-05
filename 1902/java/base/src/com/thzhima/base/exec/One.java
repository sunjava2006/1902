package com.thzhima.base.exec;

public class One {
	
	
	public int devide(int a, int b) throws ArithmeticException,NegativeArraySizeException{
		if(b==0) {
			ArithmeticException ex = new ArithmeticException("除数为0, 输入参数不正确。");
			throw ex; // 用来抛出异常
		}
		if(b<0) {
			throw new NegativeArraySizeException("这个参数还要用来创建数组，不能小于0。");
		}
		int[] array = new int[b];
		return a/b;
	}
	
	
	public int todo(int a, int b) throws Exception{
		return this.devide(a, b);
	}

	public static void main(String[] args) throws Exception  {
		One one = new One();
		try {
			one.devide(10, -10);
		}catch(ArithmeticException ex) {
			System.out.println("-----------------");
		}catch(NegativeArraySizeException ex) {
			System.out.println("==================");
			throw ex;
		}catch(Exception ex) {
			System.out.println("0000000000000000000");
		} 
		
	}
}
