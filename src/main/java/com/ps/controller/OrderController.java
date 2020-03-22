package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IOrderService;
import com.ps.vo.Order;
import com.ps.vo.PageUtil;

@Controller
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@RequestMapping("/queryOrderList")
	@ResponseBody
	public PageUtil<Order>  queryOrderList(@RequestParam int pageSize,@RequestParam int currentPage){
		System.out.println("queryOrderList进来了..."+pageSize+"  "+currentPage);
		PageUtil<Order> pageUtil=new PageUtil<>();
		pageUtil.setPageSize(pageSize);
		pageUtil.setCurrentPage(currentPage);
		pageUtil=orderService.queryOrderList(pageUtil);
		pageUtil.getRows().forEach(System.out::println);
		return pageUtil;
	}
	
	@PostMapping("/placeOrder")
	@ResponseBody
	public int placeOrder(Order order){
		System.out.println(order);
		int oid=orderService.placeOrder(order);
		return oid;
	}
	
	@RequestMapping("/payedOrder")
	@ResponseBody
	public void payedOrder(@RequestParam int oid) {
		orderService.payedOrder(oid);
	}
	
	@RequestMapping("/queryOrderById")
	@ResponseBody
	public Order queryOrderById(@RequestParam int oid) {
		Order order= orderService.queryOrderById(oid);
		System.out.println(order);
		return order;
	}
	
	@RequestMapping("/clearCartProduct")
	@ResponseBody
	public void clearCartProduct(@RequestParam String oiids) {
		System.out.println("clearCartProduct :"+oiids);
		String[] arr = oiids.split("-");
		orderService.clearCartProduct(arr);
	}
}
