package com.thzhima.bean;

import java.io.Serializable;

public class Goods implements Serializable{

	private Integer ID;
	private String goodsName;
	private String description;
	private String unit;
	private float price;
	private String location;
	private String picture;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Goods(Integer iD, String goodsName, String description, String unit, float price, String location,
			String picture) {
		super();
		ID = iD;
		this.goodsName = goodsName;
		this.description = description;
		this.unit = unit;
		this.price = price;
		this.location = location;
		this.picture = picture;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
