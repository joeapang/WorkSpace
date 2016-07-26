package com.joea.javaweb.bookstore.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.joea.javaweb.bookstore.excption.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static DataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("myc3p0config");
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("Êý¾Ý¿âÒì³££¡");
		}
	}

	public static void releaseConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

		}
	}
	
	public static void releasePreparedStatement(PreparedStatement pstm) {
		try {
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {

		}
	}
	public static void releaseResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {

		}
	}

}
