<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
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
  	<a href="${pageContext.servletContext.contextPath }/servlet/LogoffServlet">注销</a>   
    <h1 align="center">您好，尊敬的会员</h1><br><br><br>
    <h2 align="center"><font color="red">${logoffmessage }</font></h2>
    <h2 align="center"><font color="blue">${user.nickname }</font></h2><br><br><br>
    <h1 align="center">这里是主页！</h1>
  </body>
</html>
