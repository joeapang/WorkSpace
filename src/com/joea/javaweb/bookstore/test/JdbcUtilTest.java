package com.joea.javaweb.bookstore.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.joea.javaweb.bookstore.jdbc.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection conn=JdbcUtil.getConnection();
		System.out.println(conn);
	}

	@Test
	public void testReleaseConnection() {
		fail("Not yet implemented");
	}

}
