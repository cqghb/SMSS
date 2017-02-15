<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addUser page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/shore.css">
  </head>
  
  <body>
    <div align="center">
    	<h2>用户注册</h2>
    	<form class="form-group" action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post" role="form">
    		<div class="form form-group">
				<input class="form-control" type="hidden" name="operation" value="add" />
			</div>
			<div class="form form-inline">
				<label id="lab" for="empName">账号:</label>
				<input id="empName" class="form-control" type="text" maxlength="6"placeholder="请输入账号"required="required" name="name" autofocus="autofocus" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
			</div>
			<div class="form form-inline">
				<label id="lab" for="empName">密码:</label>
				<input id="empName" class="form-control" type="password" placeholder="请输入密码" maxlength="3" name="password1" required="required" autofocus="autofocus"/>
			</div>
			<!-- 
			<div class="form form-inline">
				<label id="lab" for="empName">确认密码:</label>
				<input id="empName" class="form-control" type="password" maxlength="3" name="password2" required="required" autofocus="autofocus"/>
			</div>
			 -->
			<div class="form form-inline">
				<a href="<%=request.getContextPath()%>/login.jsp" class="btn btn-primary">返回</a>
				<input id="empName" class="btn btn-primary" type="submit" value="注册""/>
			</div>
    	</form>
    </div>
  </body>
</html>
