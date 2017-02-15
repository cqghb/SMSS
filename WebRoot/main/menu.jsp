<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>menu</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
	<!--  
	<script type="text/javascript" src="<%=request.getContextPath() %>/web_sys/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/web_sys/js/bootstrap.min.js"></script>
	 -->
  </head>
  
  <body>
    <div align="center">
    	<ul class="nav nav-tabs">
    		<li>
    			<a target="content" href="<%=request.getContextPath()%>/servlet/StudentServlet?operation=select&curPage=1">查看学生</a>
    		</li>
    		<li>
    			<a target="content" href="<%=request.getContextPath()%>/servlet/CoursesServlet?operation=select&curPage=1">查看课程</a>
    		</li>
    		<li>
    			<a target="content" href="<%=request.getContextPath()%>/servlet/ClassServlet?operation=select&curPage=1">查看班级</a>
    		</li>
    		
    		<li>
    			<a target="content" href="<%=request.getContextPath()%>/servlet/ScoreSelectsServlet?operation=select&curPage=1">查看学生成绩</a>
    		</li>
    		<!-- 
    		<li>
    			<a target="content" href=""></a>
    		</li>
    		 -->
    	</ul>
    </div>
  </body>
</html>
