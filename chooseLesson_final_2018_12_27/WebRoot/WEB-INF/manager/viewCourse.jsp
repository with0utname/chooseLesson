<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网上选课系统</title>
</head>
<body>
	<c:forEach items="username" var="username">
	</c:forEach>

	<form action="Manager" method="get">
		<input type="submit" name="manager" value="index" />
	</form>
	<form action="Manager?username=${username} " method="post">
		<input type="submit" name="manager" value="chooseCourse" />
	</form>
	<div align="center">
		<h1>我的课表</h1>
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
				<td>退课</td>
			</tr>
			<c:forEach items="${list }" var="vars">
				<tr>
					<td>${vars.course_id }</td>
					<td>${vars.course_name}</td>
					<td>${vars.teacher}</td>
					<td>${vars.point}</td>
					<td>${vars.time_1}</td>
					<td>${vars.time_2}</td>
					<td>${vars.location}</td>
					<td>${vars.limited}</td>
					<td><form
							action="ViewCourseController?courseid=${vars.course_id }&username=${username}"
							method="post">
							<input type="submit" name="function" value=deleteCourse />
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
