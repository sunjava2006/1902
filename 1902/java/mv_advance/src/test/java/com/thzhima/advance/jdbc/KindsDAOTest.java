package com.thzhima.advance.jdbc;

import java.sql.SQLException;

import junit.framework.TestCase;

public class KindsDAOTest extends TestCase {

	private KindsDAO dao;
	public KindsDAOTest(String name) {
		super(name);
		dao =  new KindsDAO();
	}

	public void testGetKindName() throws SQLException {
		String name = dao.getKindName(20);
		TestCase.assertEquals("耗材", name);
	}

}
