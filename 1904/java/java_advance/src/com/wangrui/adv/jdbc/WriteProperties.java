package com.wangrui.adv.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		p.setProperty("myName", "wang");
		p.setProperty("gender", "male");
		FileWriter writer = new FileWriter("/home/wangrui/my.properties");
		p.store(writer, "2020-2-2");
	}
}
