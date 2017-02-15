<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateClass.jsp' starting page</title>
    
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
    	<h2>修改课程</h2>
    	<%
    		//String course_name = new String(request.getParameter("course_name").getBytes("ISO-8859-1"),"UTF-8");
    		String course_name = request.getParameter("course_name");
    	%>
    	<div>
    		<form class="form-group" action="<%=request.getContextPath() %>/servlet/CoursesServlet" method="post" role="form">
				<div class="form form-group">
					<input class="form-control" type="hidden" name="operation" value="update" />
				</div>
				<div class="form form-inline">
					<label for="title">课程编号:</label>
					<input id="title" class="form-control" type="text" name="course_id" value="<%=request.getParameter("course_id") %>" readonly="readonly"/>
				</div>
				<div class="form form-inline">
					<label for="empName">课程名称:</label>
					<input id="empName" class="form-control" type="text" name="course_name" value="<%=course_name %>" autofocus="autofocus" placeholder="请输入课程名称" autocomplete="off" maxlength="20" required="required"/>
				</div>
				<div class="form form-group">
					<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?operation=select" class="btn btn-primary">取消</a>
					<input class="btn btn-primary" type="submit" value="修改"/>
				</div>
	    	</form>
    	</div>
    </div>
  </body>
</html>
