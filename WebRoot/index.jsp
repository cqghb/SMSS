<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <frameset rows="15%,8%,*,8%" frameborder="0" framespacing="0px">
  	<frame name="top" src="main/top.jsp" marginwidth="0px" marginheight="0px" noresize="" scrolling="no"/>
  	<frame name="menu" src="main/menu.jsp" marginwidth="0px" marginheight="0px" noresize="no" scrolling="no"/>
  	<!-- 
  	<frameset cols="20%,*">
  		<frame name="left" src="main/left.jsp" marginwidth="0px" marginheight="0px" scrolling="no"/>
  		<frame name="right" src="main/right.jsp" marginwidth="0px" marginheight="0px" scrolling="yes"/>
  	</frameset>
  	 -->
  	<frame name="content" src="main/content.jsp" marginwidth="0px" marginheight="0px" noresize="no" scrolling="yes"/>
  	 
  	<frame name="bottom" src="main/bottom.jsp" marginwidth="0px" marginheight="0px" noresize="no" scrolling="no"/>
  </frameset>
  <body>
  </body>
</html>
