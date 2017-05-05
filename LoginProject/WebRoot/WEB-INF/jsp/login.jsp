<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <br><br><br><br><br>
  <h1 align="center"><font color="red">请登录</font></h1><br><br>
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    <table align="center">
      	<tr><td>账号：<input type="text" name="username"><font color="red">${error1 }</font></td></tr>
    	<tr><td>密码：<input type="password" name="password"><font color="red">${error2 }</font></td></tr>
    </table>
    <br>
    	<center><input type="submit" name="sub" value="登陆"></center><br><br>
    <h4 align="center"><font color="red">没有注册？点击进行注册：</font><a href="">注册</a></h4>
    <h5 align="center">@有权保持声明</h5>
    </form>
  </body>
</html>
