<html>
<head>
	<title>student</title>
</head>
<body>
 	学生:<br>
 	编号:${student.id}&nbsp;&nbsp;&nbsp;&nbsp;
 	姓名:${student.name}&nbsp;&nbsp;&nbsp;&nbsp;
 	年龄:${student.age}&nbsp;&nbsp;&nbsp;&nbsp;
 	地址:${student.address}<br>
 	学生列表:
 	<table border="1">
 		<tr>
 			<th>序号</th>
 			<th>学号</th>
 			<th>姓名</th>
 			<th>年龄</th>
 			<th>家庭住址</th> 			
 		</tr>
 		<#list stuList as stu>
 		<#if stu_index%2==0>
 		<tr bgcolor="red">
 		<#else>
 		<tr bgcolor="green">
 		</#if>
 			<td>${stu_index}</td>
 			<td>${stu.id}</td>
 			<td>${stu.name}</td>
 			<td>${stu.age}</td>
 			<td>${stu.address}</td>
 		</tr>
 		</#list>
 	</table>
 	<br>
 	当前日期1:${date?datetime}<!--可以使用?date,?time,?datetime,?string(格式)-->
 	<br>
 	当前日期2:${date?string("yyyy/MM/dd HH:mm:ss")}
 	<br>
 	null值的处理:${value!"默认值"}
 	<br>
 	判断value的值是否为null:<br>
 	<#if value??>
 	value中有内容
 	<#else>
 	value的值为null
 	</#if>
 	<br>
 	引用模板测试:<br>
 	<#include "hello.ftl">
</body>
</html>