<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单</title>
  </head>
  
  <body>
    <h2>订单列表</h2>
  		
    	<table width="80%" border="1">
    		<tr>
    			<td>订单号</td>
    			<td>订单人</td>
    			<td>订单时间</td>
    			<td>订单总价</td>
    			<td>订单状态</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${orders }" var="o">
    			<tr>
	    			<td>${o.id }</td>
	    			<td>${o.user.username }</td>
	    			<td>${o.orderTime }</td>
	    			<td>${o.price }</td>
	    			<td>${o.state==true?'已发货':'未发货' }</td>
	    			<td>
	    				<a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?order_id=${o.id }">查看明细</a>
	    				<a href="">删除</a>
	    			</td>
    			</tr>
    		</c:forEach>
    	</table>
  </body>
</html>
