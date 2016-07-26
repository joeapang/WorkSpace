package com.joea.javaweb.bookstore.entity;

import java.util.List;

public class Page<T> {

	private int pageNo;// 当前页

	private List<T> list;// 当前页的list

	private int pageSize=5;// 每页显示的内容条数

	private long totalItermNumber;// 总的记录条数

	public Page(int pageNo) {
		this.pageNo = pageNo;

	}


	public int getPageNo() {
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > getTotlePageNumber()) {
			pageNo = getTotlePageNumber();
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalItermNumber() {
		return totalItermNumber;
	}

	public void setTotalItermNumber(long totalItermNumber) {
		this.totalItermNumber = totalItermNumber;
	}

	public int getTotlePageNumber() {
		int totlePageNumber = (int) Math.ceil((double)totalItermNumber / pageSize);
		return totlePageNumber;
	}

	/***
	 * 是否有下一页
	 * 
	 * @return
	 */
	public boolean isHasNext() {

		if (getPageNo() < getTotlePageNumber()) {
			return true;
		}
		return false;
	}

	/***
	 * 是否有上一页
	 * 
	 * @return
	 */
	public boolean isHasPrev() {
		if (getPageNo() <= 1) {
			return false;
		}
		return true;
	}

	/***
	 * 返回上一页
	 * 
	 * @return 返回页数
	 */
	public int getPrevPage() {
		if (isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return getPageNo()+1;
		}
		return getPageNo();
	}
}
