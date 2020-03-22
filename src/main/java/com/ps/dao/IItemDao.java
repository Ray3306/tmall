package com.ps.dao;
import java.util.List;
import java.util.Map;

import com.ps.vo.Item;

public interface IItemDao {

	//分页查询种类
	List<Item> queryItemList(Map<String,Object> map);
	
	//查询种类总页数
	int queryItemTotal();
	
	//删除一条种类记录
	void deleteItemById(int id);

	int addItem(Item item);

	void updateItem(Item item);

	Item queryItemName(int id);
	
}
