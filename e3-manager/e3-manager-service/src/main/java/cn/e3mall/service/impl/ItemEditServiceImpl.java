package cn.e3mall.service.impl;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.po.TbItem;
import cn.e3mall.po.TbItemDesc;
import cn.e3mall.po.TbItemDescExample;
import cn.e3mall.po.TbItemDescExample.Criteria;
import cn.e3mall.po.TbItemExample;
import cn.e3mall.service.ItemEditService;

@Service
public class ItemEditServiceImpl implements ItemEditService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Override
	public E3Result reshelfItem(String ids) {
		
		// 找到对应的商品
		String[] buff = ids.split(",");
		for (String id : buff) {
			// 修改商品信息
			TbItem item = itemMapper.selectByPrimaryKey(Long.parseLong(id));
			item.setStatus( (byte)1 );
			// 更改商品信息
			itemMapper.updateByPrimaryKey(item);
		}
		return E3Result.ok();
	}
	
	@Override
	public E3Result instockItem(String ids) {
		// 找到对应的商品
		String[] buff = ids.split(",");
		for (String id : buff) {
			// 修改商品信息
			TbItem item = itemMapper.selectByPrimaryKey(Long.parseLong(id));
			item.setStatus( (byte) 2);
			// 更改商品信息
			itemMapper.updateByPrimaryKey(item);
		}
		return E3Result.ok();
	}


	@Override
	public E3Result deleteItem(String ids) {
		// 找到对应的商品
		String[] buff = ids.split(",");
		for (String id : buff) {
			// 修改商品信息
			TbItem item = itemMapper.selectByPrimaryKey(Long.parseLong(id));
			item.setStatus( (byte)3 );
			// 更改商品信息
			itemMapper.updateByPrimaryKey(item);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result ItemParamData(long id) {
		//查商品
		TbItem item = itemMapper.selectByPrimaryKey(id);
		//创建返回结果
		HashMap<String, Long> result = new HashMap<String, Long>();
		if(item!=null) {
			result.put("paramData", item.getPrice());
		}else {
			result.put("paramData", (long) 01);
		}
		return E3Result.ok(result);
	}

	@Override
	public E3Result ItemDesc(long id) {
		//查商品
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(id);
		//创建返回结果
		HashMap<String, String> result = new HashMap<String, String>();
		if(itemDesc!=null) {
			result.put("itemDesc", itemDesc.getItemDesc());
		}else {
			result.put("itemDesc", "暂时没有描述信息");
		}
		return E3Result.ok(result);
	}

	@Override
	public E3Result UpdateItem(TbItem item, String desc) {
		// 更新商品信息
		if(itemMapper.selectByPrimaryKey( item.getId() ) == null) {
			 throw new IllegalAccessError("商品 不存在");
		}
		// 修改商品最新更新状态
		item.setUpdated(new Date());
		TbItemExample tbItemExample = new TbItemExample();
		cn.e3mall.po.TbItemExample.Criteria criteria = tbItemExample.createCriteria();
		criteria.andIdEqualTo( item.getId() );
		// 插入数据库
		itemMapper.updateByExampleSelective( item , tbItemExample );
        
		// 更新商品描述
		E3Result result = insertTbItemDesc( item.getId() , desc );
		if (result == null ||  result.getStatus() != 200) {
			throw new IllegalAccessError("商品 描述条件不正确");
		}
		// 返回结果
		return E3Result.ok();
	}
	
	public E3Result insertTbItemDesc(long itemDescId, String itemDesc) {
		// 查询是否存在
		TbItemDesc tbItemDesc = new TbItemDesc();
		if( itemDescMapper.selectByPrimaryKey( itemDescId ) == null) {
			// 添加信息
			tbItemDesc.setItemId(itemDescId);
			tbItemDesc.setItemDesc(itemDesc);
			tbItemDesc.setCreated(new Date());
			tbItemDesc.setUpdated(new Date());
			// 插入数据
			itemDescMapper.insert( tbItemDesc );
		}else {
			// 更新的数据
			tbItemDesc.setUpdated(new Date());
			tbItemDesc.setItemDesc( new String( itemDesc ) );
			// 更新的条件
			TbItemDescExample tbItemDescExample = new TbItemDescExample();
			Criteria criteria = tbItemDescExample.createCriteria();
			criteria.andItemIdEqualTo( itemDescId );
			// 执行sql语句数据
			itemDescMapper.updateByExampleSelective( tbItemDesc , tbItemDescExample );
		}
		return E3Result.ok();
	}
}
