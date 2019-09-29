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
	
//	public void testAdd() throws SQLException {
//		String name = "zhu";
//		String pwd = "111111";
//		boolean ok = dao.add(name, pwd);
//		System.out.println(ok);
//		TestCase.assertEquals(true, ok);
//	}
	
//	public void testUpdateByID() throws SQLException{
//		String name="russ";
//		String pwd="123456";
//		int id=7;
//		boolean ok=dao.updateByID(id,name,pwd);
//		TestCase.assertEquals(true, ok);
//	}
//	public void testDeleteByID() throws SQLException {
//		boolean ok = dao.deleteByID(8);
//		TestCase.assertEquals(true, ok);
//	}
	public void testFind() throws SQLException {
		int id=7;

		Object u=dao.find(id);
		System.out.println(u);
	}

}
