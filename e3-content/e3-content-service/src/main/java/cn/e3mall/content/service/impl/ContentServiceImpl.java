package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.po.TbContent;
import cn.e3mall.po.TbContentExample;
import cn.e3mall.po.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

	
	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisclient;
	
	@Value("${CONTENT_LIST}")
	private String CONTENT_LIST;
	
	@Override
	public E3Result addContent(TbContent content) {
		//将内容插入到内容表
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入到数据库
		contentMapper.insert(content);
		//缓存同步,删除缓存中对应的数据
		jedisclient.hdel(CONTENT_LIST, content.getCategoryId().toString());
		return E3Result.ok();
	}
	@Override
	public List<TbContent> getContentListById(long cid) {
		//查询缓存
		try {
			//如果缓存中有直接响应结果
			String json = jedisclient.hget(CONTENT_LIST, cid+"");
			if(StringUtils.isNoneBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);	
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果没有,查询数据库
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExample(example);
		//把结果添加到缓存
		try {
			jedisclient.hset(CONTENT_LIST, cid+"", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
