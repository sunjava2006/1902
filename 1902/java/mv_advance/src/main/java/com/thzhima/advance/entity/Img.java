package com.thzhima.advance.entity;

public class Img {
	private byte[] data;
	private String fileName;
	
	public Img(byte[] data, String fileName) {
		super();
		this.data = data;
		this.fileName = fileName;
	}
	public Img() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
