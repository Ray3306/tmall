package com.ps.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IOrderDao;
import com.ps.service.IOrderService;
import com.ps.vo.Order;
import com.ps.vo.PageUtil;
import com.ps.vo.Product;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderDao orderDao;
	
	@Override
	public PageUtil<Order> queryOrderList(PageUtil<Order> pageUtil) {
		Map<String,Object> map=new HashMap<>();
		map.put("start", pageUtil.getStart());
		map.put("size", pageUtil.getPageSize());
		
		List<Order> list=orderDao.queryOrderList(map);
		int total=orderDao.queryOrderTotal();
		
		pageUtil.setRows(list);
		pageUtil.setTotal(total);
		return pageUtil;
	}

	
	DateFormat df=new SimpleDateFormat("yyyyMMDDHHmmss");
	/**
	 * 下单
	 */
	@Override
	public int placeOrder(Order order) {
		String orderCode=df.format(new Date());
		order.setOrderCode(orderCode);
		orderDao.placeOrder(order);
		return order.getId();
	}
	
	/**
	 * 付款
	 */
	@Override
	public void payedOrder(int oid) {
		orderDao.payedOrder(oid);
	}

	
	@Override
	public Order queryOrderById(int oid) {
		return orderDao.queryOrderById(oid);
	}

	@Override
	public void clearCartProduct(String[] arr) {
		List<String> list=new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		orderDao.clearCartProduct(list);
		
	}

	

	

}
