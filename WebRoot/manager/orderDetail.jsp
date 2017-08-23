<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单明细</title>
  </head>
  
  <body>
    <h3>订单明细</h3>
    <table border="1" width="70%">
    	<tr>
    		<td>书名</td>
    		<td>售价</td>
    		<td>数量</td>
    		<td>应收货款</td>
    	</tr>
    	
    	<c:forEach var="orderitem" items="${order.orderitems}">
    		<tr>
	    		<td>${orderitem.book.name }</td>
	    		<td>${orderitem.book.price }</td>
	    		<td>${orderitem.quantity }</td>
	    		<td>${orderitem.price }</td>
    		</tr>
    	</c:forEach> 
    	
    	<tr>
    		<td>订单总价</td>
    		<td colspan="3">${order.price }元</td>
    	</tr>
    </table>
    
    <br/><br/>
     <h3>收货人信息</h3>
    <table border="1"  width="70%">
    	<tr>
    		<td>用户</td>
    		<td>电话</td>
    		<td>地址</td>
    		<td>手机</td>
    		<td>邮箱</td>
    	</tr>
    	
    	<tr>
    		<td>${order.user.username }</td>
    		<td>${order.user.phone }</td>
    		<td>${order.user.address }</td>
    		<td>${order.user.cellphone }</td>
    		<td>${order.user.email }</td>
    	</tr>
    
    </table>
      <a href="${pageContext.request.contextPath }/manager/ConfirmOrderServlet?order_id=${order.id }">确认发货</a>
  </body>
</html>
