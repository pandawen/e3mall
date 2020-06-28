package cn.e3mall.solrj;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrJ {
//
//	@Test
//	public void addDocument() throws Exception{
//		//创建一个SolrServer对象,创建一个连接,参数:solr服务的url
//		SolrServer server = new HttpSolrServer("http://192.168.25.131:8080/solr/collection1");
//		//创建一个文档对象SolrInputDocument
//		SolrInputDocument document = new SolrInputDocument();
//		//向文档中添加域.文档中必须包含一个id域,油油的域的名称必须在schema.xml有定义
//		document.addField("id", "doc1");
//		document.addField("item_title", "测试商品01");
//		document.addField("item_price", 1000);
//		//把文档写入索引库
//		server.add(document);
//		//提交
//		server.commit();
//	}
//	
//	@Test
//	public void deleteDoucument()throws Exception{
//		SolrServer server = new HttpSolrServer("http://192.168.25.131:8080/solr/collection1");
////		server.deleteById("id");
//		server.deleteByQuery("id:doc1");
//		server.commit();
//	}
//	
//	@Test
//	public void queryIndex()throws Exception{
//		//创建一个SolrServer对象
//		SolrServer server = new HttpSolrServer("http://192.168.25.131:8080/solr/collection1");
//		//创建一个SolrQuery对象
//		SolrQuery query = new SolrQuery();
//		//设置查询条件
////		query.setQuery("*:*");
//		query.set("q","*:*");
//		//执行查询,QueryResponse对象
//		QueryResponse queryResponse = server.query(query);
//		//取文档列表,取查询结果的总记录数
//		SolrDocumentList documentList = queryResponse.getResults();
//		System.out.println("查询结果总记录数:" + documentList.getNumFound());
//		//遍历文档列表,从文档中取域的值
//		for (SolrDocument solrDocument : documentList) {
//			System.out.println(solrDocument.get("id"));
//			System.out.println(solrDocument.get("item_title"));
//			System.out.println(solrDocument.get("item_sell-point"));
//			System.out.println(solrDocument.get("item_price"));
//			System.out.println(solrDocument.get("item_image"));
//			System.out.println(solrDocument.get("item_category_name"));
//		}
//	}
//	
//	@Test
//	public void queryIndexComplicated() throws SolrServerException {
//		//创建一个SolrServer对象
//		SolrServer server = new HttpSolrServer("http://192.168.25.131:8080/solr/collection1");
//		//创建一个SolrQuery对象
//		SolrQuery query = new SolrQuery();
//		//设置查询条件
//		query.setQuery("手机");
//		query.setStart(0);
//		query.setRows(20);
//		query.set("df", "item_title");
//		query.setHighlight(true);
//		query.addHighlightField("item_title");
//		query.setHighlightSimplePre("<em>");
//		query.setHighlightSimplePost("</em>");
//		//执行查询,QueryResponse对象
//		QueryResponse queryResponse = server.query(query);
//		//取文档列表,取查询结果的总记录数
//		SolrDocumentList documentList = queryResponse.getResults();
//		//取高亮
//		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
//		System.out.println("查询结果总记录数:" + documentList.getNumFound());
//		//遍历文档列表,从文档中取域的值
//		for (SolrDocument solrDocument : documentList) {
//			System.out.println(solrDocument.get("id"));
//			//取高亮显示
//			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
//			String title = "";
//			if(list!=null && list.size()>0) {
//				title = list.get(0);
//			}else {
//				title = (String) solrDocument.get("item_title");
//			}
//			System.out.println(title);
//			System.out.println(solrDocument.get("item_title"));
//			System.out.println(solrDocument.get("item_sell-point"));
//			System.out.println(solrDocument.get("item_price"));
//			System.out.println(solrDocument.get("item_image"));
//			System.out.println(solrDocument.get("item_category_name"));
//		}
//	}
}
