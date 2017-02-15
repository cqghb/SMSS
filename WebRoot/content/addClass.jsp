<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addClass</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
 	<script type="text/javascript" src="<%=request.getContextPath() %>/web_sys/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/web_sys/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div align="center">
    	<h2>添加班级</h2>
    	<div>
    		<form class="form-group" action="<%=request.getContextPath() %>/servlet/ClassServlet" method="post" role="form">
				<div class="form form-group">
					<input class="form-control" type="hidden" name="operation" value="add" />
				</div>
				<div class="form form-inline">
					<label for="empName">班级名称:</label>
					<input id="empName" class="form-control" type="text" name="class_name" autofocus="autofocus" placeholder="请输入班级" autocomplete="off" maxlength="20" required="required"/>
				</div>
				<div class="form form-group">
					<a href="<%=request.getContextPath() %>/servlet/ClassServlet?operation=select&curPage=1" class="btn btn-primary">取消</a>
					<input class="btn btn-primary" type="submit" value="添加"/>
				</div>
	    	</form>
    	</div>
    </div>
  </body>
</html>
