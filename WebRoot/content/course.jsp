<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Courses" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>course page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
    <%
    	ArrayList<Courses> course = (ArrayList)request.getAttribute("course");
    %>
    <table class="table table-striped table-bordered table-hover table-responsive">
    	<thead>
    		<tr>
    			<th>课程编号</th>
    			<th>课程名称</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
    			<td>
    				<%=course.get(0).getCourse_id() %>
    			</td>
    			<td>
    				<%=course.get(0).getCourse_name() %>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			  	 <a target="content" href="<%=request.getContextPath()%>/servlet/CoursesServlet?operation=select" class="btn btn-info">返回</a>
    			</td>
    		</tr>
    	</tbody>
    </table>
    
  </body>
</html>
