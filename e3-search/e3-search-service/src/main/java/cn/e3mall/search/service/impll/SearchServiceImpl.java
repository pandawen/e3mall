package cn.e3mall.search.service.impll;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.dao.SearchDao;
import cn.e3mall.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public SearchResult search(String key, int page, int rows) throws Exception {
		//设置一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(key);
		//设置分页条件
		if(page<=0) page=1;
		query.setStart((page-1)*rows);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "item_title");
		//开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		//调用dao执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算总页数
		long recordCount = searchResult.getRecordCount();
		int totalpage = (int) (recordCount/rows);
		if (recordCount%rows > 0) 
			totalpage++;
		searchResult.setTotalPages(totalpage);
		//返回结果
		return searchResult;
	}

}
