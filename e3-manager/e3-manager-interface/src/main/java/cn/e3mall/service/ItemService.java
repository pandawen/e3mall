package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUiDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.po.TbItem;
import cn.e3mall.po.TbItemDesc;

public interface ItemService {
	
	TbItem geTbItemById(long itemId);
	EasyUiDataGridResult getItemList(int page,int rows);
	E3Result addItem(TbItem item,String desc);
	TbItemDesc getItemDescById(long itemId);
}
