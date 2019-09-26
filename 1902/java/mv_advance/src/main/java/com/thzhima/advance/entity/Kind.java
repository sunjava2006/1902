package com.thzhima.advance.entity;

public class Kind {
	private Integer ID;
	private String kindName;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	
	
	public Kind() {
		super();
	}
	
	public Kind(Integer iD, String kindName) {
		super();
		ID = iD;
		this.kindName = kindName;
	}
	
	@Override
	public String toString() {
		return "Kind [ID=" + ID + ", kindName=" + kindName + "]";
	}
	
	
	
	
}
