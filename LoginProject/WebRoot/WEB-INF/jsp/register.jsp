<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <style type="text/css">
	#title{color:#FF7B0B;font-size:20px;font-weigh:bod;}
	#i{width:350ph;height:15px;color:blue;font-size:12px;}
	table{text-align:left;}
	#t{text-align:right;}
	</style>

  </head>
  
  <body>
    <h2 align="center" ><font color="red">您好，请注册</font></h2>
   	<form action="${pageContext.request.contextPath }/servlet/RegisterServlet"  method="post" >
   	<table border="0" align="center" >
   	<tr><td id="t" >用户名：*</td><td><input type="text" name="username" value=${form.username }></td><td id="i"><font color="red">${form.errors.username }</font>用户名由字母开头，后跟字母、数字或下划线！</td></tr>
   	<tr><td id="t" >密码：*</td><td><input type="password" name="password" ></td><td id="i"><font color="red">${form.errors.password }</font>设置登录密码，至少为六位！</td></tr>
   	<tr><td id="t">确认密码：*</td><td><input type="password" name="password2" ></td><td id="i"><font color="red">${form.errors.password2 }</font>请再次输入您的密码！</td></tr>
   	<tr><td id="t">性别：*</td><th><input type="radio" name="Sex" value="男">男
   	    <input type="radio" name="Sex" value="女">女</th>
   	    <td  id="i">请选择您的性别！</td>
   	</tr>
   	<tr><td>邮箱地址：*</td><td><input type="text" name="email" value=${form.email }></td><td id="i"><font color="red">${form.errors.email}</font>请输入您常用的邮箱，可以用此邮箱找回密码</td></tr>
   	<tr><td>基本情况：*</td></tr>
   	<tr><td></td><td colspan="2"><textarea name="area" rows="7" cols="45" value=${form.area }></textarea><font color="red">${form.errors.area }</font></td></tr>
   	<tr><td colspan="3" align="center"><input type="checkbox" name="checke">我已经仔细阅读并且接受用户注册协议</td></tr>
   	<tr><td>请输入验证码：*</td><td><input type="text" name="yanzheng"></td><td id="i">看不清楚，点击换一张<img src="/MyDIY_1/servlet/PictureServlet" onclick="changeImage(this)" alt="换一张" style="cursor:hand"></td></tr>
   	<tr><td colspan="3" align="center"><input type="submit" name="tijiao" value="提交" "></td></tr><br>
   	</table>
   	<h5 align="left">发神技术有限公司<font size="1" color="blue">TM</font></h5>
   	<font size="2">华为技术有限公司提供支持</font><font size="1" color="red">TM</font><center><font size="2">@版权所有,违者必究<font size="1">power by Ca</font></font></center>
   	</form>
  </body>
</html>
