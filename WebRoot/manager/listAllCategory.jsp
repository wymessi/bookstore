<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>所有分类信息</title>
  </head>
  
  <body style="text-align: center;">
    <h2>分类信息</h2>
    <table width="60%" border="1" style="margin-left: 200px;">
    	<tr>
    		<td>分类名称</td>
    		<td>分类描述</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${categories }" var="c">
    		<tr>
    			<td>${c.name }</td>
    			<td>${c.description }</td>
    			<td>
	    			<a href="">删除</a>
		    		<a href="">修改</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
