package com.joea.javaweb.bookstore.vo;

public class TradeItem {

	private Integer tradeItemId;

	// 和TradeItem关联的Book
	private Book book;

	private Integer bookId;

	private Integer tradeId;

	private Integer quantity;

	public TradeItem(Integer tradeItemId, Book book, Integer bookId, Integer tradeId, Integer quantity) {
		this.tradeItemId = tradeItemId;
		this.book = book;
		this.bookId = bookId;
		this.tradeId = tradeId;
		this.quantity = quantity;
	}

	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "TradeItem [tradeItemId=" + tradeItemId + ", book=" + book + ", bookId=" + bookId + ", tradeId="
				+ tradeId + ", quantity=" + quantity + "]";
	}

}
