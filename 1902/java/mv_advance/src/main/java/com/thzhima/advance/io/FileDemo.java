package com.thzhima.advance.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		
		File d = new File("/home/wangrui/tempdir/a/b/c");// File 构造重载的方法。
		String path = d.getAbsolutePath(); // 取文件的绝对路径名（文件名）
		System.out.println(path);
		
		if(d.exists()) { // 判断文件（目录）是否存在
			System.out.println("目录存在");
			System.out.println(d.getAbsolutePath() +" can  "+ (d.canRead()?"read":"not read"));
			System.out.format("%1$s can %2$s \n", d.getAbsolutePath(), d.canWrite()?"write":" not write");
			System.out.format("%1$s can %2$s \n", d.getAbsolutePath(), d.canExecute()?"execute":" not execute");
			
			
			File f = new File(d, "Hello.java");// File 构造重载的方法。
			System.out.println(f.getAbsolutePath());
			if(f.exists()) {
				System.out.println(f.getName() + "存在。"); // 取文件名，不含目录。
				System.out.format("%s can %s \n", f.getAbsolutePath() , f.canRead()?"read":"not read");
				System.out.format("%s can %s \n",  f.getAbsolutePath(), f.canWrite()?"write":"not write");
				System.out.format("%s can %s \n",  f.getAbsolutePath(), f.canExecute()?"execute":"not execute");
				System.out.format("%s is %s \n",  f.getAbsolutePath(), f.isHidden()?"hidden":"not hidden");
				System.out.format("%1$s  created  %2$tY-%2$tm-%2$td  %2$tH:%2$tm:%2$tS \n",  f.getAbsolutePath(), new Date( f.lastModified()));
				System.out.println("change to can execute---------------");
				f.setExecutable(true, false);
				System.out.format("%s can %s \n",  f.getAbsolutePath(), f.canExecute()?"execute":"not execute");
				
			}else {
				boolean b = f.createNewFile();   //  创建文件。
				System.out.println("新建文件："+(b? "成功":"失败"));
			}

		}else {
			boolean ok = d.mkdirs();  //创建多级目录。mkdir只能创建一级目录。
			System.out.println(ok);
		}
		
	}
}
