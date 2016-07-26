package com.joea.javaweb.bookstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.joea.javaweb.bookstore.dao.impl.BaseDAO;
import com.joea.javaweb.bookstore.dao.impl.BookDAOImpl;
import com.joea.javaweb.bookstore.dao.impl.UserDAOImpl;
import com.joea.javaweb.bookstore.vo.Book;
import com.joea.javaweb.bookstore.vo.User;

public class BaseDAOTest {

	BaseDAO baseDAO=new BookDAOImpl();
	@Test
	public void testInsert() {
		String sql="INSERT INTO account (balance) VALUES (?)";
		System.out.println(baseDAO.insert(sql,12345));
	}

	@Test
	public void testUpdate() {
		String sql="UPDATE mybooks SET Salesamount=? where id=?";
		baseDAO.update(sql, 10,4);
	}

	@Test
	public void testQuery() {
		Book book=new Book();
		String sql="SELECT * FROM mybooks WHERE Id=?";
		book=(Book) baseDAO.query(sql, 4);
		System.out.println(book.toString());
	}

	@Test
	public void testQueryForList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSingleVal() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatch() {
		fail("Not yet implemented");
	}

}
