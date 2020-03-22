package com.ps.vo;

import java.io.Serializable;
import java.util.List;

public class PageUtil<T> implements Serializable{

	private int total;
	
	private List<T> rows;
	
	private Integer pageSize;
	
	private Integer currentPage;
	
	public int getStart() {
		if(null==currentPage) {
			return 0;
		}else {
			return (currentPage-1)*pageSize;
		}
		
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PageUtil [total=" + total + ", rows=" + rows + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ "]";
	}

	
}
