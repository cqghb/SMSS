<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>updateScore page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
    <div align="center">
    	<%
    		//String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
    		//String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
    		//String course_name = new String(request.getParameter("course_name").getBytes("ISO-8859-1"),"UTF-8");
    		//String class_name = new String(request.getParameter("class_name").getBytes("ISO-8859-1"),"UTF-8");
    		String name = request.getParameter("name");
    		String sex = request.getParameter("sex");
    		String course_name = request.getParameter("course_name");
    		String class_name = request.getParameter("class_name");
    	%>
    	<h2>成绩修改</h2>
    	<form class="form-group" action="<%=request.getContextPath() %>/servlet/ScoreSelectsServlet" method="post" rel="form">
    		<div class="form form-group">
    			<input class="form-control" type="hidden" type="text" name="operation" value="update"/>
    			<input class="form-control" type="hidden" name="score_id" value="<%=request.getParameter("score_id")%>"/>
    		</div>
    		<div class="form form-group">
    			<span>学号:</span>
    			<input class="form form-control" type="text" name="id" value="<%=request.getParameter("id")%>" readonly="readonly">
    		</div>
    		<div class="form form-group">
    			<span>姓名:</span>
    			<input class="form form-control" type="text" name="name" value="<%=name%>" readonly="readonly">
    		</div>
    		<div class="form form-group">
    			<span>性别:</span>
    			<input class="form form-control" type="text" name="sex" value="<%=sex%>" readonly="readonly"/>
    		</div>
    		<div class="form form-group">
    			<span >班级:</span>
    			<input class="form form-control" type="text" name="class_id" value="<%=class_name%>" readonly="readonly">
    		</div>
    		<div class="form form-group">
    			<span >课程名称:</span>
    			<input class="form form-control" type="text" name="course_name" value="<%=course_name%>" readonly="readonly">
    		</div>
    		<div class="form form-group">
    			<span >成绩:</span>
    			<input class="form form-control" type="text" name="score_num" value="<%=request.getParameter("score_num")%>" autofocus="autofocus" placeholder="请输入成绩" autocomplete="off" required="required" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
    		</div>
    		<div class="form form-group">
    			<a class="btn btn-info" href="<%=request.getContextPath()%>/servlet/ScoreSelectsServlet?operation=select&curPage=1">返回</a>
    			<input class="btn btn-info" type="submit" value="修改"/>
    		</div>
    	</form>
    </div>
  </body>
  
</html>
