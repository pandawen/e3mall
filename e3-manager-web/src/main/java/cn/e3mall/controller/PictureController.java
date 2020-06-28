package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.activation.MailcapCommandMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

@Controller
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		try {
			//创建一个FastDFS的客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			//取文件扩展名
			String originalFileNameString = uploadFile.getOriginalFilename();
			String extName = originalFileNameString.substring(originalFileNameString.lastIndexOf(".")+1);
			//得到一个图片的地址和文件名
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//补充完整的url
			url = IMAGE_SERVER_URL + url;
			//封装到map中返回
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url",url);
			return JsonUtils.objectToJson(result);//返回String而不是Map是因为考虑到浏览器兼容性
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("message","图片上传失败");
			return JsonUtils.objectToJson(result);
		}
	}
}
