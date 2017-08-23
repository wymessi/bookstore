<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  #category{margin-left: 150px;padding-top: 20px; float: left;}
  #book_page{float: left;margin-left: 200px;}
  </style>
    <title>图书列表</title>
  </head>
  
  <body>
  <div id="content" style="width: 840px">
  
    <div id="category">
    	<ul>
    		<c:forEach items="${categories }" var="c">
    			<li>
    				<a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBookWithCategory&category_id=${c.id}">${c.name }</a>
    			</li>
    		</c:forEach>
    	</ul>
    </div>
    
    <div id="book_page">
	    <div id="books">
	    	<c:forEach items="${page.list }" var="b">
	    		<div style="clear: both">
		    		<div style="float:left;" class="clear">
		    			<img alt="bookimage" src="${pageContext.request.contextPath }/images/${b.image}">
		    		</div>	
	    			<div style="float:left";>
		    			<ul >
		    				<li>${b.name }</li>
		    				<li>${b.author }</li>
		    				<li>${b.price }</li>
		    				<li>${b.description }</li>
		    				<li>
		    					<a href="${pageContext.request.contextPath }/client/BuyServlet?book_id=${b.id}">购买</a>
		    				</li>
		    			</ul>
	    			</div>	
	    		</div>
	    	</c:forEach>
	 	</div>
    	<div style="clear: both" ></div>
    	<div>
	    	当前第[${page.pageNum}]页，
	    	<c:forEach var="pageNum" begin="${page.startPage }" end="${ page.endPage}">
	    		[<a href="${pageContext.request.contextPath }/client/IndexServlet?method=${param.method }&pageNum=${pageNum}&category_id=${param.category_id}">${pageNum }</a>]
	    	</c:forEach>
	    	总共[${page.totalPage }]页，总[${page.totalRecord }]纪录
    	</div>
  	</div>
  </div>
  </body>
</html>
