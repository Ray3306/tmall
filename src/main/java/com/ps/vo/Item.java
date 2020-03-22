package com.ps.vo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{

	private int id;
	
	private String name;
	
	private List<Product> productList;
	

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", productList=" + productList + "]";
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
