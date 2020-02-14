package com.wangrui.spring.aop.base.entity;

public class A {

	private int month;
	private int kw;
	private long gdp;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getKw() {
		return kw;
	}
	public void setKw(int kw) {
		this.kw = kw;
	}
	public long getGdp() {
		return gdp;
	}
	public void setGdp(long gdp) {
		this.gdp = gdp;
	}
	public A(int month, int kw, long gdp) {
		super();
		this.month = month;
		this.kw = kw;
		this.gdp = gdp;
	}
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "A [month=" + month + ", kw=" + kw + ", gdp=" + gdp + "]";
	}
	
	
	
}
