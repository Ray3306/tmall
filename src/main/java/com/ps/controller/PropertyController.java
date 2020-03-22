package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IPropertyService;
import com.ps.vo.PageUtil;
import com.ps.vo.Property;

@Controller
public class PropertyController {

	@Autowired
	IPropertyService propertyService;
	
	@GetMapping("/queryPropertyList")
	@ResponseBody
	public PageUtil<Property> queryPropertyList(@RequestParam int pageSize,@RequestParam int currentPage,@RequestParam int cid){
		System.out.println("queryPropertyList进来了..."+pageSize+"  "+currentPage);
		PageUtil<Property> pageUtil=new PageUtil<>();
		pageUtil.setPageSize(pageSize);
		pageUtil.setCurrentPage(currentPage);
		pageUtil=propertyService.queryPropertyList(pageUtil,cid);
		pageUtil.getRows().forEach(System.out::println);
		return pageUtil;
	}
	
	@GetMapping("/deletePropertyById")
	@ResponseBody
	public void deleteIemById(@RequestParam int id) {
		System.out.println("deleteItemById进来了..."+id);
		propertyService.deletePropertyById(id);
	}
	
	@PostMapping("/addProperty")
	@ResponseBody
	public void addProperty(Property property) {
		System.out.println("addProperty.."+property);
		propertyService.addProperty(property);
	}
	
	@PostMapping("updateProperty")
	@ResponseBody
	public void updateProperty(Property property) {
		System.out.println("updateProperty.."+property);
		propertyService.updateProperty(property);
	}
	
	@GetMapping("/queryPropertyValue")
	@ResponseBody
	public List<Property> queryPropertyValue(@RequestParam int id) {
		System.out.println("queryPropertyValue :"+id);
		List<Property> list=propertyService.queryPropertyValue(id);
		list.forEach(System.out::println);
		return list;
	}
	
}
