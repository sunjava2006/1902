package com.thzhima.goover;

public class VolaTest {

	public static boolean flag = false;
	
	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(" will over..........");
	}



	public static void main(String[] args) throws InterruptedException {
		
//		Thread t = new Thread(()->{
//			flag  = true;
//			while(flag) {
//			System.out.println("---------------");
////			try {
////				Thread.sleep(1000);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}});
//		
//		t.start();
//		
//		Thread.sleep(2000);
//		
//		Thread t2 = new Thread(()->{while(flag) {
//			System.out.println("-----set false----------");
//			flag = false;
//			}
//		});
//		
//		t2.start();
		
		long aaa = Long.parseLong("100");
		Long l = new Long(2);
		Long ll = Long.valueOf(2);
		long aa = ll.longValue();
		
		long aaaaa = l;
		Long llll = 90L;
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.reverse();
		sb.replace(0,1, "sss");
		
		VolaTest vv = new VolaTest();
		
	   vv = null;
	   
	   System.gc();
	   
		Thread.sleep(10000);
	
	}

}
