package com.wangrui.adv.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDeom {
	
	public static boolean createFile(String fileName) throws IOException {
		File f = new File(fileName);
		System.out.println("绝对路径："+f.getAbsolutePath());
		System.out.println("文件名:" + f.getName());
		System.out.println("分隔符："+File.separator);
		return f.createNewFile();
	}
	
	public static boolean createDir(String dirName) {
		boolean ok = false;
		File d = new File(dirName);
		if(!d.exists()) { // 判断目录是否存在
			ok = d.mkdirs(); // 创建目录
		} 
		return ok;
	}
	
	public static boolean delFile(String fileName) {
		File f = new File(fileName);
		return f.delete();
	}
	
	public static void set(String name,boolean read, boolean write, boolean exe) {
		File f = new File(name);
		f.setReadable(read, false);
		f.setWritable(write);
		f.setExecutable(exe);
	
	}
	
	public static void delDir(File dir) {
		File[] childern = dir.listFiles(); // 取目录下的子（文件、目录）
		if(childern!=null) {
			for(File f : childern) {
				if(f.isFile()) {
					f.setWritable(true);//设置文件写权限。
					f.delete();
				}else {
					delDir(f);
					f.setWritable(true);
					f.delete();
				}
			}
		}
		dir.setWritable(true);
		dir.delete();
	}
	


	public static void main(String[] args) throws IOException {
		
//		System.out.println(createFile("/home/wangrui/my"));
//		System.out.println(createDir("/home/wangrui/a/b/c/d"));
//		delDir(new File("/home/wangrui/a"));
//		set("/home/wangrui/a", true, true, true);
		
//		File d = new File("/home/wangrui");
//		String parent = d.getParent();
//		System.out.println(parent);
		
		File f = new File("/home/wangrui/a");
		long time = f.lastModified();
		Date date = new Date(time);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate = fmt.format(date);
		System.out.println(sdate);
		
		
	}
}
