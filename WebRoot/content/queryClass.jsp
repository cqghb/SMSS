<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryClass.jsp' starting page</title>
    
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
    <form action="<%=request.getContextPath() %>/servlet/ClassServlet" class="form-horizontal" method="post" role="form">
		<div class="form-group">
			<input name="operation" value="selBClassId" type="hidden">
		</div>
		<div class="form-group">
			<span class="col-md-3">
				班级名:
			</span>
			<span class="col-md-9">
				<select name="class_id" class="form-control">
					<option selected="selected" value="1"/>软件一班
					<option value="2"/>软件1班
				</select>
			</span>
		</div>
		<div class="form-group">
			<span class="col-md-12">
				<input type="reset" value="重置" class="btn btn-info"/>
				<input type="submit" value="查询" class="btn btn-info"/>
			</span>
		</div>
  	</form>
  </body>
</html>
