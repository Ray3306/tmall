package com.ps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IPropertyDao;
import com.ps.service.IPropertyService;
import com.ps.vo.Item;
import com.ps.vo.PageUtil;
import com.ps.vo.Property;
@Service
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	IPropertyDao propertyDao;
	
	@Override
	public PageUtil<Property> queryPropertyList(PageUtil<Property> pageUtil,int cid) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageUtil.getStart());
		map.put("size", pageUtil.getPageSize());
		map.put("cid", cid);
		
		List<Property> list=propertyDao.queryPropertyList(map);
		int total=propertyDao.queryPropertyTotal(cid);
		
		pageUtil.setRows(list);
		pageUtil.setTotal(total);
		return pageUtil;
	}

	@Override
	public void deletePropertyById(int id) {
		propertyDao.deletePropertyById(id);
		
	}

	@Override
	public void addProperty(Property property) {
		propertyDao.addProperty(property);
		
	}

	@Override
	public void updateProperty(Property property) {
		propertyDao.updateProperty(property);
		
	}

	@Override
	public List<Property> queryPropertyValue(int id) {
		return propertyDao.queryPropertyValue(id);
	}

}
