package com.ps.service;

import com.ps.vo.Item;
import com.ps.vo.PageUtil;

public interface IItemService {

	PageUtil<Item> queryItemList(PageUtil<Item> pageUtil);

	void deleteItemById(int id);

	void addItem(String name, String filePath);

	void updateItem(Item item,String filePath);

	Item queryItemName(int id);
}
