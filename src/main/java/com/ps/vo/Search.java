package com.ps.vo;

import java.io.Serializable;

public class Search implements Serializable{

	private Double minPrice;
	
	private Double maxPrice;

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "Search [minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

	
	
	
}
