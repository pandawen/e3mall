package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.po.TbItem;
import cn.e3mall.service.ItemEditService;

@Controller
@RequestMapping("/rest")
public class ItemRestController {

	@Autowired
	private ItemEditService itemEditService;
	
	@RequestMapping("/page/item-edit")
	public String ItemEdit() {
		// 编辑单个商品的信息界面
		return "item-edit";
	}
	
	@RequestMapping(value = "/item/update" , method=RequestMethod.POST)
	@ResponseBody
	public E3Result ItemEdit(TbItem item , String desc) {
		// 编辑单个商品的信息界面
		E3Result updateItem = null;
		try{
			updateItem = itemEditService.UpdateItem( item , desc );
			return updateItem;
		}catch(Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/item/query/item/desc/{id}")
	@ResponseBody
	public E3Result ItemDesc(@PathVariable long id) {
		// 加载商品描述
		E3Result itemDesc = itemEditService.ItemDesc( id );
		return itemDesc;
	}
	
	@RequestMapping(value = "/item/param/item/query/{id}")
	@ResponseBody
	public E3Result ItemParamData(@PathVariable long id) {
		// 加载商品规格
		E3Result itemParamData = itemEditService.ItemParamData(id);
		return itemParamData;
	}
	
	@RequestMapping(value = "/item/delete" , method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteItem(@RequestParam String ids) {
		// 商品删除
		E3Result deleteItem = itemEditService.deleteItem( ids );
		return deleteItem;
	}
 
	@RequestMapping(value = "/item/instock" , method = RequestMethod.POST)
	@ResponseBody
	public E3Result instockItem(@RequestParam String ids) {
		// 商品下架
		E3Result instockItem = itemEditService.instockItem( ids );
		return instockItem;
	}
	
	@RequestMapping(value = "/item/reshelf",method=RequestMethod.POST)
	@ResponseBody
	public E3Result reshelfItem(@RequestParam String ids) {
		 // 商品上架
		 E3Result reshelfItem = itemEditService.reshelfItem( ids );
		 return reshelfItem;
	}
}
