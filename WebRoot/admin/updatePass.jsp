<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>updatePass page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
    <div align="center">
    	<h2>密码修改</h2>
    	<form class="form-group" action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post" role="form">
    		<div class="form form-group">
				<input class="form-control" type="hidden" name="operation" value="update" />
			</div>
			<div class="form form-inline">
				<label for="empName">编号:</label>
				<input id="empName" class="form-control" type="text" name="id" value="<%=request.getParameter("id") %>" readonly="readonly"/>
			</div>
			<div class="form form-inline">
				<label for="empName">账号:</label>
				<input id="empName" class="form-control" type="text" name="name" value="<%=request.getParameter("name") %>" autofocus="autofocus" placeholder="请输入账号" maxlength="3" name="password1" required="required"/>
			</div>
			<div class="form form-inline">
				<label for="empName">密码:</label>
				<input id="empName" class="form-control" type="password" name="password1" value="<%=request.getParameter("password") %>" autofocus="autofocus" placeholder="请输入密码" maxlength="3" name="password1" required="required"/>
			</div>
			<div class="form form-inline">
				<input id="empName" class="btn btn-primary" type="submit" value="修改""/>
			</div>
    	</form>
    </div>
  </body>
</html>
