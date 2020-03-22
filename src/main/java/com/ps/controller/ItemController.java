package com.ps.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;
import com.ps.service.IItemService;
import com.ps.vo.Item;
import com.ps.vo.PageUtil;

@Controller
public class ItemController {

	@Autowired
	IItemService itemService;
	
	@GetMapping("/queryItemList")
	@ResponseBody
	public PageUtil<Item> queryItemList(@RequestParam(required = false) Integer pageSize,@RequestParam(required = false) Integer currentPage) {
		System.out.println("queryItemList进来了..."+pageSize+"  "+currentPage);
		PageUtil<Item> pageUtil=new PageUtil<>();
		pageUtil.setPageSize(pageSize);
		pageUtil.setCurrentPage(currentPage);
		pageUtil=itemService.queryItemList(pageUtil);
		pageUtil.getRows().forEach(System.out::println);
		return pageUtil;
	}
	
	@GetMapping("/deleteItemById")
	@ResponseBody
	public void deleteIemById(@RequestParam int id) {
		System.out.println("deleteItemById进来了..."+id);
		itemService.deleteItemById(id);
	}
	
	@PostMapping("/addImg")
	@ResponseBody
	public void addImg(HttpServletResponse response, HttpServletRequest request, MultipartFile upload,@RequestParam String name) {
		System.out.println("addImg...."+name);
		// 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        System.out.println(filename);
        System.out.println(path);
        // 完成文件上传
        try {
			upload.transferTo(new File(path,filename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(name);
        String filePath="uploads"+filename;
        
        itemService.addItem(name,filePath);
        
        try {
			response.sendRedirect("http://localhost:8080/#/admin/item");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@PostMapping("/updateImg")
	@ResponseBody
	public void updateImg(HttpServletResponse response, HttpServletRequest request, MultipartFile upload,@RequestParam String name,@RequestParam int id) {
		System.out.println("updateImg....."+name+"   "+id);
		Item item=new Item();
		item.setId(id);
		item.setName(name);
		// 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        if(!StringUtils.isNullOrEmpty(filename)) {
        	
        	// 把文件的名称设置唯一值，uuid
        	String uuid = UUID.randomUUID().toString().replace("-", "");
        	filename = uuid+"_"+filename;
        	System.out.println(filename);
        	System.out.println(path);
        	// 完成文件上传
        	try {
        		upload.transferTo(new File(path,filename));
        	} catch (IllegalStateException | IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	
        	String filePath="/uploads/"+filename;
        	itemService.updateItem(item,filePath);
        }else {
        	itemService.updateItem(item,"");
        }
        
        try {
			response.sendRedirect("http://localhost:8080/#/admin/item");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@GetMapping("/queryItemName")
	@ResponseBody
	public Item queryItemName(@RequestParam int id) {
		System.out.println("queryItemName"+id);
		Item item=itemService.queryItemName(id);
		return item;
	}
}
