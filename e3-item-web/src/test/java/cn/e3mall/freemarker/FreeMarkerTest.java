package cn.e3mall.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import javassist.expr.NewArray;

public class FreeMarkerTest {
	
	@Test
	public void testFreeMarker() throws Exception{
		//创建一个模板文件
		//创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//设置模板文件保存的目录
		configuration.setDirectoryForTemplateLoading(new File("E:\\eclipse-workspace\\e3-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
		//模板文件的编码格式,一般是utf-8
		configuration.setDefaultEncoding("utf-8");
		//加载一个模板文件,创建一个模板对像
//		Template template = configuration.getTemplate("hello.ftl");
		Template template = configuration.getTemplate("student.ftl");
		//创建一个数据集,可以是pojo也可以是map,推荐使用map
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker");
		//创建一个pojo对象
		Student student = new Student(1, "小明", 18, "回龙观");
		data.put("student", student);
		//添加日期类型
		data.put("date",new Date());
		//创建一个List
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "小明1", 18, "回龙观"));
		students.add(new Student(2, "小明2", 19, "回龙观"));
		students.add(new Student(3, "小明3", 20, "回龙观"));
		students.add(new Student(4, "小明4", 21, "回龙观"));
		students.add(new Student(5, "小明5", 22, "回龙观"));
		students.add(new Student(6, "小明6", 23, "回龙观"));
		students.add(new Student(7, "小明7", 24, "回龙观"));
		students.add(new Student(8, "小明8", 25, "回龙观"));
		data.put("stuList", students);
		//null值测试
		data.put("value", "123");
		
		//创建一个writer对象,指定输出文件的路径及文件名
//		Writer out = new FileWriter(new File("F:\\freemarker-html\\hello.txt"));
		Writer out = new FileWriter(new File("F:\\freemarker-html\\student.html"));
		//生成静态页面
		template.process(data, out);
		//关闭流
		out.close();
	}
}
