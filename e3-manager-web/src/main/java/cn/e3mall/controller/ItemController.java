package cn.e3mall.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUiDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.po.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")//对应接受的链接请求
	@ResponseBody	//将返回对象转换为json
	public TbItem getItemById(@PathVariable("itemId") long itemId) {
		TbItem item = itemService.geTbItemById(itemId);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUiDataGridResult getItemList(Integer page,Integer rows) {
		EasyUiDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value = "/item/save", method=RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item,String desc) {//可以使用pojo接收表单的数据，要求pojo的属性和input的name属性要一致
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
}
