package cn.e3mall.pagehelper;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TsetPublishService {

	//测试不启动tomcat的情况下服务能否启动
	@Test
	public void publicService() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		System.out.println("服务已启动");
		System.in.read();
		System.out.println("服务已结束");
	}
}
