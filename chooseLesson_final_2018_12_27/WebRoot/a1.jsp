<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网上选课系统</title>
</head>
<body>
	<div align="center">
		<h1>选课表</h1>
	</div>
	<div align="center">
		<table border="1">
			<tr>
				<td>course_id</td>
				<td>course_name</td>
				<td>teacher</td>
				<td>point</td>
				<td>time_1</td>
				<td>time_2</td>
				<td>location</td>
				<td>limited</td>
			</tr>
			<c:foreach items="${list}" var="vars">
				<tr>
					<td>${vars.course.course_id}</td>
					<td>${vars.course.course_name}</td>
					<td>${vars.course.teacher}</td>
					<td>${vars.course.point}</td>
					<td>${vars.course.time_1}</td>
					<td>${vars.course.time_2}</td>
					<td>${vars.course.location}</td>
					<td>${vars.course.limited}</td>
				</tr>
			</c:foreach>
		</table>
	</div>
</body>
</html>
