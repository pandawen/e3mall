package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.po.TbContent;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentservice;
	
	@RequestMapping(value = "/content/save",method = RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(TbContent content) {
		//调用服务把内容插入到数据库
		E3Result e3Result = contentservice.addContent(content);
		return e3Result;
	}
}
