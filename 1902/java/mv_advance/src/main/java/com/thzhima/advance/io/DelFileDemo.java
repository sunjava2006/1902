package com.thzhima.advance.io;

import java.io.File;

public class DelFileDemo {
	
	public static void del(File d) {
		if(d.isDirectory()) {  // 判断如果是目录
			File[] childs = d.listFiles();  // 列出目录下的文件（包含文件和目录）
			for(int i=0; i<childs.length; i++) {
				del(childs[i]); // 递归调用
			}
		}else {
			d.delete();  // 是文件，直接删除。
		}
		d.delete(); // 删除当前入参目录。
	}

	public static void main(String[] args) {
		File d = new File("/home/wangrui/tempdir");
	
		del(d);
		
	
	}
}
