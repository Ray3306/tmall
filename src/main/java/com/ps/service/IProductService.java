package com.ps.service;

import java.util.List;

import com.ps.vo.PageUtil;
import com.ps.vo.Product;
import com.ps.vo.Search;

public interface IProductService {

	PageUtil<Product> queryProductList(PageUtil<Product> pageUtil,int cid,Search keywords);
	
	void addProduct(Product product);

	void deleteProductById(int id);

	void updateProduct(Product product);

	Product queryProductName(int id);
	
	List<Product> queryOrderDetails(int id);
	
	Product queryProductById(int id);
	
	List<Product> queryCartProductsByUid(int uid);
}
