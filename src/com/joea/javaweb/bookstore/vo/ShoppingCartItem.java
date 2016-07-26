package com.joea.javaweb.bookstore.vo;

public class ShoppingCartItem {

	private Book book;
	private int quantity;
	
	public ShoppingCartItem(Book book) {
		// TODO Auto-generated constructor stub
		this.book=book;
		this.quantity=1;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/***
	 * ���ظ���Ʒ�ڹ��ﳵ�е�Ǯ��
	 * @return
	 */
	public float getItemMoney(){
		return book.getPrice()*quantity;
	}
	
	/***
	 * ��Ʒ������count
	 * @param count
	 */
	public void increment(int count){
		quantity+=count;
	}
	/***
	 * ��Ʒ������1
	 */
	public void increment(){
		increment(1);
	}
}
