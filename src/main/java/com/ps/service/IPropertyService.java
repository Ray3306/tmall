package com.ps.service;

import java.util.List;

import com.ps.vo.PageUtil;
import com.ps.vo.Property;

public interface IPropertyService {

	PageUtil<Property> queryPropertyList(PageUtil<Property> pageUtil,int cid);

	void deletePropertyById(int id);
	
	void addProperty(Property property);
	
	void updateProperty(Property property);
	
	List<Property> queryPropertyValue(int id);
}
