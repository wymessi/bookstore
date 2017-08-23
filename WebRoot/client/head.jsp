<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页头</title>
  <script type="text/javascript">

  </script>
  </head>
  
  <body>
    <h1 align="center">冠马逊网上书店</h1>
    <div style="float: left;margin-left: 580px">
	    <a href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" target="body">首页</a>
	    <a href="${pageContext.request.contextPath }/client/listCart.jsp" target="body">查看购物车</a>
	    <a href="${pageContext.request.contextPath }/client/ListUserOrderServlet" target="body"">查看订单</a>
    </div>
    
    <div style="float: left; margin-top: 50px;">
    	<c:choose>
    		<c:when test="${user==null }">
    			<form action="${pageContext.request.contextPath }/client/LoginServlet" method="POST">
		    		用户名：<input type="text" name="username"/>
		    		密码：<input type="text" name="password"/>
		    		<input type="submit" value="登录"/>
		    		<a href="${pageContext.request.contextPath }/client/register.jsp" target="body">
		    			<input type="button" value="注册" id="register"/>
		    		</a>
    			</form>
    		</c:when>
    		<c:otherwise>
    			欢迎你：${user.username }
    			<a href="${pageContext.request.contextPath }/client/LogoutServlet">注销</a>
    		</c:otherwise>
    	</c:choose>
    	
    </div>
  </body>
</html>
