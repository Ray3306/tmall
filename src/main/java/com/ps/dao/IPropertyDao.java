package com.ps.dao;

import java.util.List;
import java.util.Map;

import com.ps.vo.Property;

public interface IPropertyDao {

	List<Property> queryPropertyList(Map map);
	
	//查询种类总页数
	int queryPropertyTotal(int cid);

	void deletePropertyById(int id);
	
	void addProperty(Property property);
	
	void updateProperty(Property property);
	
	List<Property> queryPropertyValue(int id);
	
}
