package cn.e3mall.search.service.impll;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchItem;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.search.mapper.ItemMapper;
import cn.e3mall.search.service.SearchItemService;

@Service
public class SearchItemServiceImpl implements SearchItemService{

	@Autowired
	private ItemMapper ItemMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public E3Result importAllItems() {
		try {
			//查询商品列表
			List<SearchItem> itemList = ItemMapper.getItemList();
			//遍历商品列表
			for (SearchItem searchItem : itemList) {
				//创建文档对象
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				//向文档对象中添加域
				solrInputDocument.addField("id", searchItem.getId());
				solrInputDocument.addField("item_title", searchItem.getTitle());
				solrInputDocument.addField("item_sell_point", searchItem.getSell_point());
				solrInputDocument.addField("item_price", searchItem.getPrice());
				solrInputDocument.addField("item_image", searchItem.getImage());
				solrInputDocument.addField("item_category_name", searchItem.getCategory_name());
				//把文档对象写入索引库
				solrServer.add(solrInputDocument);
			}
			//提交
			solrServer.commit();
			//返回导入成功
			return E3Result.ok();
			
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500, "数据导入时发生异常");
		}
	}

}
