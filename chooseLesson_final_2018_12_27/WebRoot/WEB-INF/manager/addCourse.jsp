<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加课系统</title>
</head>
<body>
		<form action="Manager" method="get">
		<input type="submit" name="manager" value="index" />
	</form>
	<form action="Manager?username=${username}"  method="post">
		<input type="submit" name="manager" value="courseList" />
	</form>

	<form action="AddCourseController" method="get">
		<table>
			<caption>课程添加</caption>
			<tr>
				<td>课程编号</td>
				<td colspan="7"><input type="text" name="courseid1"
					style="width: 70px" /></td>
			</tr>
			<tr>
				<td>课程名称</td>
				<td colspan="7"><input type="text" name="coursename1"
					style="width: 130px" /></td>
			</tr>
			<tr>
				<td>教师姓名</td>
				<td colspan="7"><input type="text" name="teacher"
					style="width: 120px" /></td>
			</tr>
			<tr>
				<td>学分</td>
				<td colspan="7"><input type="text" name="point"
					style="width: 50px" />(1-6)</td>
			</tr>
			<tr>
				<th rowspan="2">上课时间</th>
				<td colspan="7">第一次:<input type="date" name="time_1"
					style="width: 130px" /></td>
			</tr>
			<tr>
				<td colspan="7">第二次:<input type="date" name="time_2"
					style="width: 130px" /></td>
			</tr>
			<tr>
				<td>上课地点</td>
				<td colspan="7"><input type="text" name="location"
					style="width: 100px" /></td>
			</tr>
			<tr>
				<td>限制人数</td>
				<td colspan="7"><input type="text" name="limited"
					style="width: 70px" /></td>
			</tr>
		</table>
		<input type="submit" name="function" value="addCourse" />
	</form>
</body>
</html>
