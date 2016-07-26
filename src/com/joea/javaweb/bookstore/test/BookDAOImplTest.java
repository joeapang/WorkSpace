package com.joea.javaweb.bookstore.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.joea.javaweb.bookstore.dao.BookDAO;
import com.joea.javaweb.bookstore.dao.impl.BaseDAO;
import com.joea.javaweb.bookstore.dao.impl.BookDAOImpl;
import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.vo.Book;

public class BookDAOImplTest {

	BookDAO bookDAO=new BookDAOImpl();
	@Test
	public void testGetBook() {
		Book book=new Book();
		book=bookDAO.getBook(5);
		System.out.println(book);
	}

	@Test
	public void testGetPage() {
		BookEntity be=new BookEntity(50,60, 90);
		
		Page<Book> page=bookDAO.getPage(be);
		//System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getList());
		System.out.println(page.getPageNo());
		System.out.println(page.getNextPage());
	}

	@Test
	public void testGetTotleBookNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStoreNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchUpdateStoreNumberAndScaleAmouunt() {
		fail("Not yet implemented");
	}

}
