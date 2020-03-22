package com.ps.dao;

import java.util.List;
import java.util.Map;

import com.ps.vo.Order;
import com.ps.vo.Product;

public interface IProductDao {

	List<Product> queryProductList(Map map);
	
	int queryProductTotal(int cid);
	
	void addProduct(Product product);

	void deleteProductById(int id);

	void updateProduct(Product product);

	Product queryProductName(int id);
	
	List<Product> queryOrderDetails(int id);
	
	//foreProduct查询
	Product queryProductById(int id);
	
	List<Product> queryCartProductsByUid(int uid);
}
