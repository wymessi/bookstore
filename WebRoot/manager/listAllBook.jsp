<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示所有图书</title>
</head>

<body>
	<table border="1" width="60%">
		<tr>
			<td>图书名称</td>
			<td>作者</td>
			<td>价格</td>
			<td>图片</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="b">
			<tr>
				<td>${b.name }</td>
				<td>${b.author }</td>
				<td>${b.price }</td>
				<td><a href="${pageContext.request.contextPath }/images/${b.image }">查看图片</a>
				</td>
				<td>${b.description }</td>
				<td><a href="#">修改</a> <a href="#">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	当前第[${page.pageNum }]页，
	<c:forEach var="pageNum" begin="${page.startPage }"
			end="${page.endPage }">
			[<a
				href="${pageContext.request.contextPath }/manager/BookServlet?method=listAllBook&pageNum=${pageNum}">${pageNum}</a>]
	</c:forEach>
	总共[${ page.totalPage}]页，共[${page.totalRecord }]条记录
</body>
</html>
