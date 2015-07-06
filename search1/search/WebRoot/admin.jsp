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
    
    <title>管理员界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script  type="text/javascript">
		 function actionDispatcher (actionName){
		   alert("haha");
		   var form = document.getElementById("mainForm")
			if(actionName == "index")
				form.action = "index.action";
			if(actionName == "spider")
				form.action = "spider.action";
			if(actionName == "quit")
				window.location.href = "http://locahost:8080/search/login.jsp";
			else
				window.location.href = "/error.jsp";
		}
	</script>
  </head>
  
	<form method="post"  id="mainForm" >
	
	    <input type="submit" onClick="actionDispatcher('spider')" value="保存爬虫数据" style="width: 169px; "/><br/><br/>
	    
	    <input type="submit" onClick="actionDispatcher('index')" value="更新索引列表" style="width: 169px; "/><br/><br/>
	    
	    <input type="submit" onClick="actionDispatcher('quit')"  value="退出系统管理" style="width: 169px; "/>
	
	</form>
</html>
