package com.ps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IProductDao;
import com.ps.service.IProductService;
import com.ps.vo.Order;
import com.ps.vo.PageUtil;
import com.ps.vo.Product;
import com.ps.vo.Search;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDao productDao;
	
	@Override
	public PageUtil<Product> queryProductList(PageUtil<Product> pageUtil,int cid,Search keywords) {
		Map<String,Object> map=new HashMap<>();
		map.put("start", pageUtil.getStart());
		map.put("size", pageUtil.getPageSize());
		map.put("cid", cid);
		
		map.put("minPrice", keywords.getMinPrice());
		map.put("maxPrice", keywords.getMaxPrice());
		
		List<Product> list=productDao.queryProductList(map);
		int total=productDao.queryProductTotal(cid);
		
		pageUtil.setRows(list);
		pageUtil.setTotal(total);
		return pageUtil;
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public Product queryProductName(int id) {
		return productDao.queryProductName(id);
	}

	@Override
	public List<Product> queryOrderDetails(int id) {
		return productDao.queryOrderDetails(id);
	}

	@Override
	public Product queryProductById(int id) {
		return productDao.queryProductById(id);
	}
	
	@Override
	public List<Product> queryCartProductsByUid(int uid) {
		return productDao.queryCartProductsByUid(uid);
	}
}
