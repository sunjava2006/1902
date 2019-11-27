package com.thzhima.goover.serialize;

import java.io.Serializable;

public class User  implements Serializable{

	String name = "Wang8";

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}
