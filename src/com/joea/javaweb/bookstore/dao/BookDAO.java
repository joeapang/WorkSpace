package com.joea.javaweb.bookstore.dao;

import java.util.Collection;
import java.util.List;

import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.vo.Book;
import com.joea.javaweb.bookstore.vo.ShoppingCartItem;

public interface BookDAO {
	
	/***
	 * ����id ��ȡָ����Book����
	 * @param id
	 * @return
	 */
	public abstract Book getBook(int id);
	
	/***
	 * ���ݴ����BookEntity���ض�Ӧ��Page����
	 * @param be
	 * @return
	 */
	
	public abstract Page<Book> getPage(BookEntity be);
	
	/***
	 * ���ݴ����BookEntity�����ȡ���Ӧ�ļ�¼����
	 * @param be
	 * @return
	 */
	public abstract long getTotleBookNumber(BookEntity be);
	
	/***
	 * ���ݴ����BookEntity��PageSize���ص�ǰ��Ӧ��List
	 * @param be
	 * @param pageSize
	 * @return
	 */
	public abstract List<Book> getPageList(BookEntity be,int pageSize);
	
	/***
	 * �����ƶ�id��Book��storeNumber�ֶε�ֵ
	 * @param id
	 * @return
	 */
	public abstract int getStoreNumber(Integer id);
	
	/***
	 * ���ݴ����ShoppingCartItem����
	 * ��������books���е�storenumber��salenumber�ֶ�
	 * @param items
	 */
	public abstract void batchUpdateStoreNumberAndScaleAmouunt(Collection<ShoppingCartItem> items);

}
