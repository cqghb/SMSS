<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>content</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- 
  <frameset cols="20%,*">
  		<frame name="left" src="<%=request.getContextPath() %>/main/left.jsp" marginwidth="0px" marginheight="0px" scrolling="no"/>
  		<frame name="right" src="<%=request.getContextPath() %>/main/right.jsp" marginwidth="0px" marginheight="0px" scrolling="yes"/>
  	</frameset>
  -->
  <body style="background-color: ;">
  
  </body>
</html>
