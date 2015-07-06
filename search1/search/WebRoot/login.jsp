<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
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
    <form action = "login.action" method="post">
    
    	<b>用户名：</b>
    	<input type="text" name="username" style="width: 157px; "/><br/><br/>
    
    	<b>密码：</b>
    	<input type="password" name="password" style="width: 157px; "/><br/><br/>
    	
    	&nbsp;&nbsp;<input type="submit" value="登录" style="width: 87px; "/>
    	
    	&nbsp;&nbsp;<input type="button" onClick="javascript: window.location.href='/index.jsp';" value="浏览" style="width: 87px; "/>
    	
    </form>
  </body>
</html>
