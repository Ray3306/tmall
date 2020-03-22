package com.ps.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IImgDao;
import com.ps.dao.IItemDao;
import com.ps.service.IItemService;
import com.ps.vo.Img;
import com.ps.vo.Item;
import com.ps.vo.PageUtil;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemDao itemDao;
	
	@Autowired
	IImgDao imgDao;
	
	@Override
	public PageUtil<Item> queryItemList(PageUtil<Item> pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageUtil.getStart());
		map.put("size", pageUtil.getPageSize());
		
		List<Item> list=itemDao.queryItemList(map);
		int total=itemDao.queryItemTotal();
		
		pageUtil.setRows(list);
		pageUtil.setTotal(total);
		return pageUtil;
	}

	@Override
	public void deleteItemById(int id) {
		itemDao.deleteItemById(id);
	}

	@Override
	public void addItem(String name, String filePath) {
		Item item=new Item();
		item.setName(name);
		itemDao.addItem(item);
		System.out.println("id:"+item.getId());
		Img img=new Img();
		img.setPath(filePath);
		img.setCid(item.getId());
		img.setType("single_category");
		imgDao.addImg(img);
		
	}

	@Override
	public void updateItem(Item item, String filePath) {
		itemDao.updateItem(item);
		if("".equals(filePath)) {
		}else {
			Img img=new Img();
			img.setCid(item.getId());
			img.setPath(filePath);
			img.setType("single_category");
			System.out.println(img);
			imgDao.updateImg(img);
		}
		
	}

	@Override
	public Item queryItemName(int id) {
		return itemDao.queryItemName(id);
	}

}
