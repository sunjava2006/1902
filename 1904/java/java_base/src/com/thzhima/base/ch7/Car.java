package com.thzhima.base.ch7;

// 定义一个类Car
public class Car {

	float weight = 1.6F; // 重量
	float oilPct = 4.2F; //油耗
	String color = "Block"; //颜色
	float speed = 230;//车速
	int seatNO = 5; // 座位数
	String brand = "QQ"; //品牌
	
    private void adjust() {
    	System.out.println("修改车辆参数");
    }
	
	public void run() {
		System.out.println("开车中......");
	}
	
	public void stop() {
		System.out.println("停车.");
	}
	
	public void turn(String direction) {
		System.out.println("转向:"+direction);
	}
//	
//	public Car() {
//		
//	}
	
	
}
