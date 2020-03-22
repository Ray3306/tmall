package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IProductService;
import com.ps.vo.Item;
import com.ps.vo.PageUtil;
import com.ps.vo.Product;
import com.ps.vo.Search;

@Controller
public class ProductController {

	@Autowired
	IProductService productService;
	
	@GetMapping("/queryProductList")
	@ResponseBody
	public PageUtil<Product> queryProductList(@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer cid ,Search keywords){
		System.out.println("queryProductList进来了..."+pageSize+"  "+currentPage+"   "+cid+"  "+keywords);
		PageUtil<Product> pageUtil=new PageUtil<>();
		pageUtil.setPageSize(pageSize);
		pageUtil.setCurrentPage(currentPage);
		cid=(null==cid?0:cid);
		
		pageUtil=productService.queryProductList(pageUtil,cid,keywords);
		pageUtil.getRows().forEach(System.out::println);
		return pageUtil;
	}
	
	@PostMapping("/addProduct")
	@ResponseBody
	public void addProduct(Product product) {
		System.out.println("addProduct :"+product);
		productService.addProduct(product);
	}
	
	@GetMapping("/deleteProductById")
	@ResponseBody
	public void deleteProductById(@RequestParam int id) {
		System.out.println("deleteProductById :"+id);
		productService.deleteProductById(id);
	}
	
	@PostMapping("/updateProduct")
	@ResponseBody
	public void updateProduct(Product product) {
		System.out.println("updateProduct :"+product);
		productService.updateProduct(product);
	}
	
	@GetMapping("/queryProductName")
	@ResponseBody
	public Product queryProductName(@RequestParam int id) {
		System.out.println("queryProductName" +id);
		Product product=productService.queryProductName(id);
		return product;
	}
	
	@RequestMapping("/queryOrderDetails")
	@ResponseBody
	public List<Product> queryOrderDetails(@RequestParam int id){
		System.out.println("queryOrderDetails :"+id);
		List<Product> list= productService.queryOrderDetails(id);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/queryProductById")
	@ResponseBody
	public Product queryProductById(@RequestParam int id) {
		return productService.queryProductById(id);
	}
	
	@RequestMapping("/queryCartProductsByUid")
	@ResponseBody
	public List<Product> queryCartProductsByUid(@RequestParam int uid){
		return productService.queryCartProductsByUid(uid);
	}
}
