package com.joea.javaweb.bookstore.service;

import com.joea.javaweb.bookstore.dao.BookDAO;
import com.joea.javaweb.bookstore.dao.impl.BookDAOImpl;
import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.vo.Book;

public class BookService {

	private BookDAO bookDAO = new BookDAOImpl();

	public Page<Book> getPage(BookEntity be) {
		
		return bookDAO.getPage(be);
	}
	
	public Book getBook(int id){
		return bookDAO.getBook(id);
	}
}