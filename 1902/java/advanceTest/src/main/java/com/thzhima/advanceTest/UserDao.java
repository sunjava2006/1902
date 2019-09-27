package com.thzhima.advanceTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
  public boolean createTable(String createtable) throws SQLException{
	  boolean ok=true;
	  String sql=createtable;
	  Connection conn=null;
	  Statement stm=null;
	  try {
		conn=ConnectionUtil.getConnection();
		conn.setAutoCommit(false);
		stm=conn.createStatement();
		if(null!=createtable)
		{
			stm.executeUpdate(sql) ;
		}
	} catch (SQLException e) {
		ok = false;
		conn.rollback();
		e.printStackTrace();
		
	}finally {
		if(null!=conn) {
			conn.setAutoCommit(true);
			conn.close();
		
		}
		if(stm!=null) {
			stm.close();
		}
	}
	  return ok;
  }
  
  
  public boolean add(String name,String pwd) throws SQLException {
	  boolean ok = false;
	  String sql = "insert into t_user(id,name,pwd)values(seq_users.nextval,?,?)";
	  Connection conn = null;
	  PreparedStatement stm = null;
	  try {
		  conn = ConnectionUtil.getConnection();
		  stm = conn.prepareStatement(sql);
		  conn.setAutoCommit(false);
		  stm.setString(1, name);
		  stm.setString(2, pwd);
		  int count = stm.executeUpdate();
		  if(count ==1) {
			  ok = true;
		  }
		  if(ok) {
			  conn.commit();
		  }
		  
	  }catch(SQLException ex) {
		  conn.rollback();
		  ok = false;
		  ex.printStackTrace();
		  
	  }finally {
		  if(null != stm) {
			  stm.close();
		  }
		  if(null != conn) {
			  conn.setAutoCommit(true);
			  conn.close();
		  }
	  }
	  return ok;
  }
  
  
  
}
