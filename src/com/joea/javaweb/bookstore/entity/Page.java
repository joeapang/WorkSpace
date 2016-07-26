package com.joea.javaweb.bookstore.entity;

import java.util.List;

public class Page<T> {

	private int pageNo;// ��ǰҳ

	private List<T> list;// ��ǰҳ��list

	private int pageSize=5;// ÿҳ��ʾ����������

	private long totalItermNumber;// �ܵļ�¼����

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
	 * �Ƿ�����һҳ
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
	 * �Ƿ�����һҳ
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
	 * ������һҳ
	 * 
	 * @return ����ҳ��
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
