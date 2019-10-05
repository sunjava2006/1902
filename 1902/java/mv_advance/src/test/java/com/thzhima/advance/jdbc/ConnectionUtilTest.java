package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

public class ConnectionUtilTest extends TestCase {

	public ConnectionUtilTest(String name) {
		super(name);
		System.out.println("-----constrctor-------");
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("------setUp----");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("------tearDown---------");
	}

	public void testGetConnection() throws SQLException {
		System.out.println("=======TEST=======");
		Connection c = null;
		try {
			c= ConnectionUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			TestCase.assertNotNull(c);
			
			if(null != c) {
			    TestCase.assertEquals(false, c.isClosed());
				c.close();
			}
			
		}
		
	
		
	}
	

}
