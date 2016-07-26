package com.joea.javaweb.bookstore.entity;

public class BookEntity {

	private float minPrice=0;
	
	private float maxPrice=Integer.MAX_VALUE;
	
	private int pageNo=1;

	public BookEntity(){
	}
	
	
	public BookEntity(float minPrice, float maxPrice, int pageNo) {
 		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.pageNo = pageNo;
	}


	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}