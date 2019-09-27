package com.thzhima.advanceTest;

import java.sql.SQLException;

import junit.framework.TestCase;

public class UserDaoTest extends TestCase {

	private UserDao dao;
	public UserDaoTest(String name) {
		super(name);
		this.dao = new UserDao();
	}
	
//	public void testCreateTable() throws SQLException {
//		String sql = "create table t_user"
//				   + "("
//				   + "id number, "
//				   + "name nvarchar2(10), "
//				   + "pwd nvarchar2(6)"
//				   + ")";
//		boolean b = dao.createTable(sql);
//		TestCase.assertEquals(true, b);
//	}
	
	public void testAdd() throws SQLException {
		String name = "zhu";
		String pwd = "111111";
		boolean ok = dao.add(name, pwd);
		System.out.println(ok);
		TestCase.assertEquals(true, ok);
	}
	
	

}
