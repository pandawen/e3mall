package cn.e3mall.service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.po.TbItem;

public interface ItemEditService {

	// 商品下架
	public E3Result instockItem(String ids);
	 
	// 商品上架
	public E3Result reshelfItem(String ids);
	 
	// 商品删除
	public E3Result deleteItem(String ids);
	 
	// 商品规格
	public E3Result ItemParamData(long id);
	 
	// 商品描述
	public E3Result ItemDesc(long id);
	 
	// 更新商品
	public E3Result UpdateItem(TbItem item, String desc);
}
