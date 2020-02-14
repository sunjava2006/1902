package com.wangrui.mulitithread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReceiveValueThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		// 有返回值，并可抛出异常的线程体。
		Callable<String> task =  new MyCall("Li", "123");
		
		// 线程池，调用callable类型的任务。
		Future<String> f = pool.submit(task);
		String value = f.get();
		System.out.println(value);
		
		pool.shutdown();
	}
}

class MyCall implements Callable<String>{
	private String loginName;
	private String pwd;
	
	MyCall(String loginName, String pwd){
		this.loginName = loginName;
		this.pwd = pwd;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("根据用户名:"+this.loginName+"密码:"+this.pwd+"查询数据...");
		return  "李白";
	}
	
}
