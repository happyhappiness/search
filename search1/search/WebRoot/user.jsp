<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户界面</title>
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

    <s:property value="username" /><br/>
    
	<br/>
	<form method="post" action="searchForUser.action"  id="mainForm" method="post">
	
	    <input type="text" name="queryString" style="width: 558px; "/>
	    
	    <input type="submit" value="搜索" style="width: 169px; "/>
	    
	    <input type="hidden" name="username" value=<s:property value="username" /> style="width: 169px; "/>
	        
	</form>
	
	<s:iterator  value="wordsList"  id="words">
    	<s:property value="words" />&nbsp;&nbsp;&nbsp;
    </s:iterator>
   

</body>
</html>
