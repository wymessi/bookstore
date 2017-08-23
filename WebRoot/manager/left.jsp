<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理菜单</title>
  </head>
  
  <body>
    <h3>分类管理</h3>
    <ul>
    	<li><a href="${pageContext.request.contextPath }/manager/addCategory.jsp" target="body">添加分类</a></li>
    	<li><a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=listAllCategory" target="body">查看分类</a></li>
    </ul>
    <h3>图书管理</h3>
    <ul>
    	<li><a href="${pageContext.request.contextPath }/manager/BookServlet?method=addUI" target="body">添加图书</a></li>
    	<li><a href="${pageContext.request.contextPath }/manager/BookServlet?method=listAllBook" target="body">查看图书</a></li>
    </ul>
    <h3>订单管理</h3>
    <ul>
    	<li><a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=false" target="body">查看未发货订单</a></li>
    	<li><a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=true" target="body">查看已发货订单</a></li>
    </ul>
  </body>
</html>
