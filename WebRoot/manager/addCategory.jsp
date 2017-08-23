<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加分类</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=addCategory" method="post">
    	分类名称：<input type="text" name="name"/><br/><br/>
    	分类描述：<textarea name="description" cols="30" rows="10"></textarea><br/><br/>
    	<input type="submit" value="添加分类"/>
    </form>
  </body>
</html>
