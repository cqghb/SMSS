<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>queryScore page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">

  </head>
  
  <body>
    <form action="<%=request.getContextPath() %>/servlet/ScoreSelectsServlet" method="post" class="form-horizontal" rel="form">
    	<div class="form-group">
    		<input type="hidden" name="operation" value="query"/>
    	</div>
    	<div class="form-group">
    		<span class="col-md-4">学号:</span>
    		<span class="col-md-8">
    			<input type="text" name="id" class="form-control" maxlength="2" autocomplete="off" placeholder="请输入学号" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
    		</span>
    	</div>
    	<div class="form-group">
    		<span class="col-md-4">姓名:</span>
    		<span class="col-md-8">
    			<input type="text" class="form-control" name="name" placeholder="请输入姓名" autocomplete="off"/>
    		</span>
    	</div>
    	<div class="form-group">
    		<span class="col-md-4">选择班级:</span>
    		<span class="col-md-8">
    			<select class="form-control" name="class_id">
    				<option selected value="1">软件一班</option>
    				<option value="2">软件1班</option>
    			</select>
    		</span>
    	</div>
    	<div class="form-group">
    		<span class="col-md-12">
    			<input type="reset" class="btn btn-info" value="重置"/>
    			<input type="submit" class="btn btn-info" value="查询"/>
    		</span>
    	</div>
    </form>
  </body>
</html>
