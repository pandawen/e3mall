package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.po.TbContent;

public interface ContentService {

	E3Result addContent(TbContent content);
	List<TbContent> getContentListById(long cid);
}
