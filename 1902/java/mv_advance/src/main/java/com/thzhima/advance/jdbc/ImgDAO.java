package com.thzhima.advance.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thzhima.advance.entity.Img;

public class ImgDAO {

	public static void add(String imgName) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stm = null;
		String sql = "insert into t_imgs values(?, ?)";
		File f = new File(imgName);
		String name = f.getName();
		FileInputStream in = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			in = new FileInputStream(f);
			stm = conn.prepareStatement(sql);
			stm.setBlob(1, in);
			stm.setString(2, name);
			stm.executeUpdate();
			
			conn.commit();
			
			//----------------------作业 ：实现 从数据库中读出文件，并另存。------------------------------
//			ResultSet rst = stm.executeQuery();
//			Blob b = rst.getBlob(1);
//			InputStream input = b.getBinaryStream();
			
			
			
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
	}
	
	public static Img getImg() throws SQLException {
		Img img = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery("select * from t_imgs where rownum=1");
			if(rst.next()) {
				Blob b = rst.getBlob("picture");
				String fileName = rst.getString("file_name");
				byte[] data = b.getBytes(1, (int)b.length());
				img = new Img(data, fileName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return img;
	}
	
	
	
	
	public static void main(String[] args) throws SQLException, IOException {
		//add("/home/wangrui/下载/girl.jpeg");
		
		Img img = getImg();
		
		FileOutputStream out = null;
		out  = new FileOutputStream("/home/wangrui/"+img.getFileName());
		
		out.write(img.getData());
		
		out.flush();
		out.close();
	}
}
