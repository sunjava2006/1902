package com.thzhima.advanceTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thzhima.advanceTest.bean.User;

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
  
  public boolean updateByID(int id,String userName,String pwd) throws SQLException {
	  boolean ok=false;
	  String sql="update t_user set name=?,pwd=? where id=?";
	  Connection conn=null;
	  PreparedStatement stm=null;
	  try {
		conn=ConnectionUtil.getConnection();
		
		stm=conn.prepareStatement(sql);
		stm.setString(1, userName);
		stm.setString(2, pwd);
		stm.setInt(3, id);
		conn.setAutoCommit(false);
		int count=stm.executeUpdate();
		if(1==count) {
			ok=true;
		}
		conn.commit();
	} catch (SQLException e) {
		// TODO: handle exception
		conn.rollback();
		ok=false;
		e.printStackTrace();
	}finally {
		if(null!=stm) {
			stm.close();
		}
		if(null!=conn) {
			conn.setAutoCommit(true);
			conn.close();
		}
	}
	return ok;
	  
  }
  public Object find(int id) throws SQLException {
	  User u=null;
	  String sql="select * from t_user where id=?";
	  System.out.println(sql);
	  
	  Connection conn=null;
	  PreparedStatement stm=null;
	  
	  ResultSet rst=null;
	  try {
		conn=ConnectionUtil.getConnection();
		stm=conn.prepareStatement(sql);
		stm.setInt(1,id);
		rst=stm.executeQuery();
		if(rst.next()) {
			String name=rst.getString("name");
			String password=rst.getString("pwd");
			u=new User(id,name,password);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(null!=stm) {
			stm.close();
		}
		if(null!=conn) {
			conn.close();
		}
		if(null!=rst) {
			rst.close();
		}
	}
	return u;
	  
  }
  public boolean deleteByID(Integer id) throws SQLException {
	  boolean ok = false;
	  Connection conn = null;
	  PreparedStatement stm = null;
	  String sql="delete from t_user where id=?";
	  try {
	  conn=ConnectionUtil.getConnection();
	  conn.setAutoCommit(false);
	  stm = conn.prepareStatement(sql);
	  stm.setInt(1, id);
	  int count = stm.executeUpdate();
	  if(count==1) {
		  ok=true;
	  }else {
		  conn.rollback();
	  }
	  conn.commit();
	  }catch(SQLException e) {
		  conn.rollback();
		  e.printStackTrace();
	  }finally {
		  
	  }
	  return ok;
  }
  
  
}
