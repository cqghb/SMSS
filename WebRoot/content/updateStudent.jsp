<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>updateStudent</title>
    
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
    	<h2>修改学生信息</h2>
    	
    	
    	<%
  			//String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
  			String name = request.getParameter("name");
    		//String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
  			int sex = Integer.parseInt(request.getParameter("sex"));
  		%>
    	<div>
    		<form class="form-group" action="<%=request.getContextPath() %>/servlet/StudentServlet" method="post" role="form">
				<div class="form form-group">
					<input class="form-control" type="hidden" name="operation" value="<%=request.getParameter("operation") %>" />
				</div>
				<div class="form form-inline">
					<label for="empName">学号:</label>
					<input id="empName" class="form-control" type="text" name="id" value="<%=request.getParameter("id") %>" readonly="readonly" />
				</div>
				<div class="form form-inline">
					<label for="empName">姓名:</label>
					<input id="empName" class="form-control" type="text" name="name" value="<%=name %>" autofocus="autofocus" placeholder="请输入姓名" autocomplete="off" maxlength="6" required="required"/>
				</div>
				<div class="form form-inline">
					<label for="depId">性别:</label>
					<%
					 	if(sex==1){
					%>
					<span class="form-control">
						<input id="depId" type="radio" value="1" name="sex" checked/>男
						<input id="depId" type="radio" value="2" name="sex"/>女
					</span>
					<%
						}
					%>
					<%
					 	if(sex==2){
					%>
					<span class="form-control">
						<input id="depId" type="radio" value="1" name="sex"/>男
						<input id="depId" type="radio" value="2" name="sex" checked/>女
					</span>
					<%
						}
					%>
				</div>
				<div class="form form-inline">
					<label for="title">年龄:</label>
					<input id="title" class="form-control" type="text" placeholder="请输入年龄" name="age" value="<%=request.getParameter("age") %>" autofocus="autofocus" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
				</div>
				<div class="form form-inline">
					<label for="salary">班级:</label>
					<select name="class_id" class="form-control">
						<option selected="selected" value="1">软件一班</option>
						<option value="2">软件1班</option>
					</select>
				</div>
				<div class="form form-group">
					<a href="<%=request.getContextPath() %>/servlet/StudentServlet?operation=select" class="btn btn-primary">取消</a>
					<input class="btn btn-primary" type="submit" value="修改"/>
				</div>	
	    	</form>
    	</div>
    </div>
  </body>
</html>
