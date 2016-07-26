package com.joea.javaweb.bookstore.dao;

import java.util.Collection;
import java.util.List;

import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.vo.Book;
import com.joea.javaweb.bookstore.vo.ShoppingCartItem;

public interface BookDAO {
	
	/***
	 * 根据id 获取指定的Book对象
	 * @param id
	 * @return
	 */
	public abstract Book getBook(int id);
	
	/***
	 * 根据传入的BookEntity返回对应的Page对象
	 * @param be
	 * @return
	 */
	
	public abstract Page<Book> getPage(BookEntity be);
	
	/***
	 * 根据传入的BookEntity对象获取其对应的记录数量
	 * @param be
	 * @return
	 */
	public abstract long getTotleBookNumber(BookEntity be);
	
	/***
	 * 根据传入的BookEntity和PageSize返回当前对应的List
	 * @param be
	 * @param pageSize
	 * @return
	 */
	public abstract List<Book> getPageList(BookEntity be,int pageSize);
	
	/***
	 * 返回制定id的Book的storeNumber字段的值
	 * @param id
	 * @return
	 */
	public abstract int getStoreNumber(Integer id);
	
	/***
	 * 根据传入的ShoppingCartItem集合
	 * 批量更新books表中的storenumber和salenumber字段
	 * @param items
	 */
	public abstract void batchUpdateStoreNumberAndScaleAmouunt(Collection<ShoppingCartItem> items);

}
