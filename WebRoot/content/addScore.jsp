<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addScore.jsp' starting page</title>
    
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
    	<h2>添加学生成绩</h2>
    	<div>
    		<form class="form-group" action="<%=request.getContextPath() %>/servlet/ScoreSelectsServlet" method="post" role="form">
				<div class="form form-group">
					<input class="form-control" type="hidden" name="operation" value="add" />
				</div>
				<div class="form form-inline">
					<label for="empName">学号:</label>
					<input id="empName" class="form-control" maxlength="12" placeholder="请输入学号" autocomplete="off" required="required" placeholder="请输入学号" type="text" name="id" autofocus="autofocus" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
				</div>
				<div class="form form-inline">
					<label for="salary">班级:</label>
					<select name="class_id" class="form-control">
						<option selected="selected" value="1">软件一班</option>
						<option value="2">软件1班</option>
					</select>
				</div>
				<div class="form form-inline">
					<label for="salary">课程:</label>
					<select name="course_id" class="form-control">
						<option selected="selected" value="1">计算机网络</option>
						<option value="2">Android</option>
						<option value="3">JSP程序设计——用JSP开发web应用</option>
						<option value="4">软件设计师综合</option>
						<option value="5">软件工程</option>
						<option value="6">物联网应用基础</option>
					</select>
				</div>
				<div class="form form-inline">
					<label for="title">成绩:</label>
					<input id="title" class="form-control" type="text" name="score_num" maxlength="2" autocomplete="off" required="required" placeholder="请输入成绩" autofocus="autofocus" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
				</div>
				<div class="form form-group">
					<a href="<%=request.getContextPath() %>/servlet/ScoreSelectsServlet?operation=select&curPage=1" class="btn btn-primary">取消</a>
					<input class="btn btn-primary" type="submit" value="添加"/>
				</div>
	    	</form>
    	</div>
    </div>
  </body>
</html>
