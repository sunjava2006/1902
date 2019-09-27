package com.thzhima.advance.entity;

public class Goods {
	private Integer ID;
	private String goodsName;
	private int kindID;
	private String unit;
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
	public int getKindID() {
		return kindID;
	}
	public void setKindID(int kindID) {
		this.kindID = kindID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Goods(Integer iD, String goodsName, int kindID, String unit) {
		super();
		ID = iD;
		this.goodsName = goodsName;
		this.kindID = kindID;
		this.unit = unit;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [ID=" + ID + ", goodsName=" + goodsName + ", kindID=" + kindID + ", unit=" + unit + "]";
	}
	
	
	
}
