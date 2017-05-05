<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teachRegister.jsp' starting page</title>
    
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
	<br><br>
    <h1 align="center"><font color="red">注册页面</h1><br><br><br>
    <form method="post" action="${pageContext.request.contextPath }/servlet/RegisterServlet">
    <table align="center">
    <tr><td>登录账号：*</td><td><input type="text" name="username" value=${form.username }></td><td><font color="red">${form.errors.username }</font>输入账号位数为3-8个英文字母</td></tr>
    <tr><td>输入密码：*</td><td><input type="password" name="password" ></td><td><font color="red">${form.errors.password }</font>输入密码为3-8个数字组成</td></tr>
    <tr><td>确认密码：*</td><td><input type="password" name="password2" ></td><td><font color="red">${form.errors.password2 }</font>确认您的密码</td></tr>
    <tr><td>电子邮箱：*</td><td><input type="text" name="email" value=${form.email }></td><td><font color="red">${form.errors.email }</font>输入您的电子邮箱</td></tr>
    <tr><td>您的生日：*</td><td><input type="text" name="birthday" value=${form.birthday }></td><td><font color="red">${form.errors.birthday }</font>输入您的生日</td></tr>
    <tr><td>您的昵称：*</td><td><input type="text" name="nickname" value=${form.nickname }></td><td><font color="red">${form.errors. nickname}</font>输入您汉子的昵称</td></tr>
    <tr><td>图片认证：*</td><td><input type="text" name=""></td><td>请输入验证码</td></tr>
    </table>
    <br><br>
    <center><input type="submit" value="提交"><input type="reset" value="清空"></center>>
    </form>
  </body>
</html>
