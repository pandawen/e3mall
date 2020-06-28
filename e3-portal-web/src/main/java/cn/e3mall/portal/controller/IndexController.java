package cn.e3mall.portal.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.po.TbContent;

@Controller
public class IndexController {

	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showindex(Model model) {
		//查询内容列表
		List<TbContent> adList = contentService.getContentListById(CONTENT_LUNBO_ID);
		//把结果传递给页面
		model.addAttribute("ad1List", adList);
		return "index";
	}
}
