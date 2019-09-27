package com.thzhima.advance.jdbc;

import java.sql.SQLException;

import com.thzhima.advance.entity.User;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {

	private UserDAO dao;
	
	public UserDAOTest(String name) {
		super(name);
		this.dao = new UserDAO();
	}

//	public void testFind() throws SQLException {
//		String userName = "admin";
//		String pwd = "123456";
//		User u  = dao.find(userName, pwd);
//		System.out.println(u);
//		TestCase.assertNotNull(u);
//	}
//
//	public void testFind2() throws SQLException {
//		String userName = "xxxxx' or 1=1 --";
//		String pwd = "123456";
//		User u  = dao.find(userName, pwd);
//		System.out.println(u);
//		TestCase.assertEquals(null ,u);
//	}
	
	//======================================================
//	public void testAdd() throws SQLException {
//		User u  = new User(null, "zhang", "123456");
//		boolean ok = dao.add(u);
//		TestCase.assertEquals(true, ok);
//	}
//	
//	public void testAdd2() throws SQLException {
//		User u  = new User(null, "xie", "12345");
//		boolean ok = dao.add(u);
//		TestCase.assertEquals(false, ok);
//	}
//	public void testAdd3() throws SQLException {
//		User u  = new User(null, "li", "1234567");
//		boolean ok = dao.add(u);
//		TestCase.assertEquals(false, ok);
//	}
//	public void testAdd4() throws SQLException {
//		User u  = new User(null, "zhang", "123456");
//		boolean ok = dao.add(u);
//		TestCase.assertEquals(false, ok);
//	}
	
	public void testDeleteByID() throws SQLException {
		boolean ok = dao.deleteByID(4,6);
		TestCase.assertEquals(true, ok);
	}
	

}
