<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
    	用户名：<input type="text" name="username"><br/>
    	密码：<input type="text" name="password"><br/>
    	电话：<input type="text" name="phone"><br/>
    	手机：<input type="text" name="cellphone"><br/>
    	住址：<input type="text" name="address"><br/>
    	邮箱： <input type="text" name="email"><br/>
    	<input type="submit" value="注册">
    
    </form>
  </body>
</html>
