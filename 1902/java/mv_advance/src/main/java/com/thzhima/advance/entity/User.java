package com.thzhima.advance.entity;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;
	private String userName;
	private String pwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User() {
	
	}

	public User(Integer id, String userName, String pwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd + "]";
	}
	
	@Override
	public int hashCode() {
		
		return 37*(this.id.hashCode()+this.userName.hashCode()+this.pwd.hashCode());
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this ==  o) {
			return true;
		}else {
			if(o instanceof User) {
				User other = (User)o;
				if(other.id  != null && other.id.equals(this.id)  ) {
					if(other.userName!=null && other.userName.equals(this.userName)) {
						if(other.pwd != null && other.pwd.equals(this.pwd)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
