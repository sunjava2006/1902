package com.thzhima.advance.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {

	public static boolean copy(String source, String target) throws IOException {
		boolean ok = true;
		File sourceFile = new File(source);
		
		if(sourceFile.exists()) {
			File targetFile  = new File(target);
			File parentDir = targetFile.getParentFile();
			
			// 如果目标文件的目录不存在，则需要创建。
			if(!parentDir.exists()) { 
				parentDir.mkdirs();
			}
			
			// 读源文件内容，复制到目标文件中。
			int count = -1;
			FileInputStream in= null;
			FileOutputStream out = null;
			byte[] buffer = new byte[1024*4];
			try {
				in = new FileInputStream(sourceFile);
				out = new FileOutputStream(targetFile);
				while(-1 != (count=in.read(buffer))) {
					out.write(buffer, 0, count);
				}
				out.flush(); // 刷新缓冲区
			} catch (IOException e) {
				ok = false;
				e.printStackTrace();
			} finally {
				if(null != in) {
					in.close();
				}
				if(null != out) {
					out.close();
				}
			}

		}else {
			 ok = false;
		}
		
		return ok;
	}
}
