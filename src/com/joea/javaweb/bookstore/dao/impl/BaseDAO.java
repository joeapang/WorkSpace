package com.joea.javaweb.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.joea.javaweb.bookstore.dao.DAO;
import com.joea.javaweb.bookstore.jdbc.JdbcUtil;
import com.joea.javaweb.bookstore.utils.ReflectionUtils;
import com.mysql.jdbc.Statement;

public class BaseDAO<T> implements DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class clazz;

	public BaseDAO() {
		clazz = ReflectionUtils.getSuperGenericclass(getClass());
	}

	@Override
	public long insert(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		long id = 0;
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i + 1, args[i]);
				}
			}
			pstm.executeUpdate();
			result = pstm.getGeneratedKeys();
			if (result.next()) {
				id = result.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.releasePreparedStatement(pstm);
			JdbcUtil.releaseResultSet(result);
			JdbcUtil.releaseConnection(conn);
		}
		return id;
	}

	@Override
	public void update(String sql, Object... args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			queryRunner.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.releaseConnection(conn);
		}
	}

	@Override
	public T query(String sql, Object... args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.releaseConnection(conn);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryForList(String sql, Object... args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			return (List<T>) queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.releaseConnection(conn);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JdbcUtil.getConnection();
			return (V) queryRunner.query(conn, sql,new ScalarHandler(),args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.releaseConnection(conn);
		}
		return null;
	}

	@Override
	public void batch(String sql, Object[]... args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=JdbcUtil.getConnection();
			queryRunner.batch(conn, sql,args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcUtil.releaseConnection(conn);
		}

	}

}
