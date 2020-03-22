package com.ps.dao;

import java.util.List;
import java.util.Map;

import com.ps.vo.Order;
import com.ps.vo.Product;

public interface IOrderDao {

	List<Order> queryOrderList(Map map);
	
	int queryOrderTotal();

	//下单
	int placeOrder(Order order);

	//付款
	void payedOrder(int oid);

	//查询订单信息
	Order queryOrderById(int oid);

	void clearCartProduct(List list);

	
}
