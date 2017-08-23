<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车页面</title>
  </head>
  
  <body>
    <h2>购物车列表</h2>
    <table border="1" width="60%" style="margin-left: 300px;">
    	<tr>
    		<td>书名</td>
    		<td>作者</td>
    		<td>单价</td>
    		<td>数量</td>
    		<td>小计</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach var="me" items="${cart.map }">
    		<tr>
	    		<td>${me.value.book.name }</td>
	    		<td>${me.value.book.author }</td>
	    		<td>${me.value.book.price }</td>
	    		<td>${me.value.number}</td>
	    		<td>${me.value.price }</td>
	    		<td>
	    			<a href="">删除</a>
	    		</td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="3">总计</td>
    		<td colspan="3">${cart.price }</td>
    	</tr>
    	<tr>
    		<td colspan="6"><a href="${pageContext.request.contextPath }/client/OrderServlet">提交订单</a></td>
    	</tr>
    </table>
    
  </body>
</html>
