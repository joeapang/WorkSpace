package com.joea.javaweb.bookstore.dao.impl;

import java.util.Collection;
import java.util.List;

import com.joea.javaweb.bookstore.dao.BookDAO;
import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.vo.Book;
import com.joea.javaweb.bookstore.vo.ShoppingCartItem;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM mybooks WHERE id=?";
		return query(sql, id);
	}

	@Override
	public Page<Book> getPage(BookEntity be) {
		// TODO Auto-generated method stub
		Page<Book> page = new Page<>(be.getPageNo());
		page.setTotalItermNumber(getTotleBookNumber(be));
		be.setPageNo(page.getPageNo());
		page.setList(getPageList(be, 5));
		return page;
	}

	@Override
	public long getTotleBookNumber(BookEntity be) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(id) FROM mybooks WHERE price>=? AND price<=?";
		return getSingleVal(sql, be.getMinPrice(), be.getMaxPrice());
	}

	@Override
	public List<Book> getPageList(BookEntity be, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM mybooks  WHERE price>=? AND price<=? LIMIT ? ,?";
		return queryForList(sql, be.getMinPrice(), be.getMaxPrice(), (be.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public int getStoreNumber(Integer id) {
		// TODO Auto-generated method stub
		String sql = " SELECT storeNumber FROM mybooks WHERE id=?";

		return getSingleVal(sql, id);
	}

	@Override
	public void batchUpdateStoreNumberAndScaleAmouunt(Collection<ShoppingCartItem> items) {
		// TODO Auto-generated method stub

	}

}
