package com.ps.service;

import com.ps.vo.Order;
import com.ps.vo.PageUtil;

public interface IOrderService {

	PageUtil<Order> queryOrderList(PageUtil<Order> pageUtil);

	//下单
	int placeOrder(Order order);

	//付款
	void payedOrder(int oid);

	//
	Order queryOrderById(int oid);

	//清购物车
	void clearCartProduct(String[] arr);
	
	
}
